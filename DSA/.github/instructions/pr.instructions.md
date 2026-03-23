---
name: java-pr-instructions
description: Global rules for reviewing Java PRs
---

# Java PR Review Instructions

## Coding Standards
- Follow Java 17+ conventions
- Apply SOLID principles
- Use clear, descriptive variable and method names
- Avoid tight coupling; code should be testable

## Null Safety
- Avoid returning null; use Optional
- Validate inputs and check for nulls
- Watch for potential NullPointerExceptions

## Performance
- Avoid inefficient loops or queries
- Reuse objects where appropriate

## Testing & Coverage
- Ensure code is testable
- Identify missing or insufficient unit tests

## Documentation
- Public methods should have Javadoc if complex
- Ensure comments are accurate