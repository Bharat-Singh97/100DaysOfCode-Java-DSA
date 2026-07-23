# Day 12 - Contains Duplicate

# Problem
Given an integer array `nums`, return `true` if any value appears at least twice in the array, and return `false` if every element is distinct.

# Examples

Input:
nums = [1,2,3,1]

Output:
true

Input:
nums = [1,2,3,4]

Output:
false

# Approach

- Create a HashSet.
- Traverse the array once.
- If the current element already exists in the HashSet, return `true`.
- Otherwise, add it to the HashSet.
- If the loop completes, return `false`.

# Algorithm

1. Create an empty HashSet.
2. Traverse the array.
3. Check `contains()`.
4. If found, return `true`.
5. Else, `add()` the element.
6. Return `false`.

# Time Complexity

- Average: *O(n)*

# Space Complexity

- *O(n)*

# Concepts Learned

- HashSet
- Fast Lookup
- contains()
- add()
- Average O(1) HashSet Operations
- Time vs Space Complexity
- Why auxiliary space is O(n)

# Pattern

Hashing | HashSet

## LeetCode

217. Contains Duplicate
