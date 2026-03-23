import subprocess
import os
from pathlib import Path

# -------------------------
# Configuration
# -------------------------
DEVELOP_BRANCH = "Develop"
SCRIPT_DIR = Path(__file__).parent
PROMPT_FILE = SCRIPT_DIR.parent / "prompts" / "pr-review.prompt.md"
OUTPUT_DIR = SCRIPT_DIR.parent / "pr-reviews"

INSTRUCTIONS_FILE = SCRIPT_DIR.parent / "instructions" / "pr.instructions.md"
AGENT_FILE = SCRIPT_DIR.parent / "agents" / "pr-review.agent.md"
SKILL_FILE = SCRIPT_DIR.parent / "skills" / "SKILL.md"

# -------------------------
# Helper functions
# -------------------------
def get_current_branch():
    """Get current git branch."""
    result = subprocess.run(
        ["git", "rev-parse", "--abbrev-ref", "HEAD"],
        capture_output=True, text=True, check=True
    )
    return result.stdout.strip()

def get_changed_java_files(current_branch, target_branch=DEVELOP_BRANCH):
    """Return a list of changed Java files between branches."""
    result = subprocess.run(
        ["git", "fetch", "origin", target_branch],
        capture_output=True, text=True, check=True
    )

    diff_result = subprocess.run(
        ["git", "diff", "--name-only", f"origin/{target_branch}...{current_branch}"],
        capture_output=True, text=True, check=True
    )
    files = [f.strip() for f in diff_result.stdout.splitlines() if f.endswith(".java")]
    return files

def load_prompt_template():
    """Load the agent.md, instructions.md, skill.md, and prompt.md content."""
    agent_content = ""
    if AGENT_FILE.exists():
        with open(AGENT_FILE, "r", encoding="utf-8") as f:
            agent_content = f.read()
    
    instructions_content = ""
    if INSTRUCTIONS_FILE.exists():
        with open(INSTRUCTIONS_FILE, "r", encoding="utf-8") as f:
            instructions_content = f.read()
    
    skill_content = ""
    if SKILL_FILE.exists():
        with open(SKILL_FILE, "r", encoding="utf-8") as f:
            skill_content = f.read()
    
    with open(PROMPT_FILE, "r", encoding="utf-8") as f:
        prompt_content = f.read()
    
    # Combine: agent, instructions, skill, then prompt
    full_template = f"{agent_content}\n\n{instructions_content}\n\n{skill_content}\n\n{prompt_content}"
    return full_template

def replace_selection(prompt_template, code):
    """Replace {{selection}} placeholder with actual code."""
    return prompt_template.replace("{{selection}}", code)

def send_to_ai(prompt_text, file_path):
    """Print the prompt for manual review in Copilot chat and return it for saving."""
    print(f"\n--- PROMPT FOR {file_path} ---\n{prompt_text}\n--- END PROMPT ---\n")
    print("Copy the above prompt into Copilot chat to get the review, then paste the response below.")
    # Return the prompt so it can be saved to file
    return prompt_text

def get_repo_root():
    """Get the absolute path to the git repository root."""
    result = subprocess.run(
        ["git", "rev-parse", "--show-toplevel"],
        capture_output=True, text=True, check=True
    )
    return result.stdout.strip()

# -------------------------
# Main workflow
# -------------------------
def main():
    repo_root = get_repo_root()
    os.chdir(repo_root)  # Change to repo root so relative paths work

    current_branch = get_current_branch()
    print(f"Current branch: {current_branch}")

    changed_files = get_changed_java_files(current_branch)
    if not changed_files:
        print("No Java files changed in this branch.")
        return

    OUTPUT_DIR.mkdir(exist_ok=True)

    prompt_template = load_prompt_template()

    for file_path in changed_files:
        print(f"Reviewing {file_path}...")
        with open(file_path, "r", encoding="utf-8") as f:
            code_content = f.read()

        prompt = replace_selection(prompt_template, code_content)
        ai_response = send_to_ai(prompt, file_path)

        output_file = OUTPUT_DIR / f"{Path(file_path).name}.review.txt"
        with open(output_file, "w", encoding="utf-8") as f:
            f.write(ai_response)

        print(f"Saved review: {output_file}")

    print("All PR reviews completed.")

if __name__ == "__main__":
    main()