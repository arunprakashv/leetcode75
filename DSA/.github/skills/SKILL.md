---
name: pr-review
description: "Automate PR code review for Java files changed between feature and develop branches using structured prompts and AI analysis."
---

# Automated PR Code Review Skill

This skill automates the process of reviewing Java code changes in a pull request. It identifies changed files between the current branch and the develop branch, reads each Java file, and generates detailed reviews using the pr-review prompt.

## Workflow

1. **Get Changed Files**: Use git to find Java files changed between the current branch and develop.
2. **Read Code**: Read the content of each changed Java file.
3. **Generate Review**: Use the pr-review prompt to analyze the code for bugs, quality, design, performance, and testing issues.
4. **Output Reviews**: Provide structured reviews for each file, including issues, suggestions, and refactored code where applicable.

## Usage

Invoke this skill in Copilot chat with: `/pr-review`

The agent will:
- Run git commands to detect changes.
- Process each Java file.
- Apply the Senior Java PR Reviewer role from the prompt.
- Output reviews in the specified format.

## Requirements

- Git repository with develop branch.
- pr-review.prompt.md in .github/prompts/
- Agent has access to run terminal commands and read files.

## Assets

- Prompt: .github/prompts/pr-review.prompt.md (defines the reviewer role and output format)