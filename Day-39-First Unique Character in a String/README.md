# Day 39 - First Unique Character in a String

## Problem
LeetCode 387: First Unique Character in a String

Given a string s, find the first non-repeating character
and return its index.

If it does not exist, return -1.

## Examples

Input: s = "leetcode"
Output: 0

Explanation:
'l' appears only once and is the first unique character.

Input: s = "loveleetcode"
Output: 2

Explanation:
'v' appears only once and is the first unique character.

Input: s = "aabb"
Output: -1

Explanation:
All characters appear more than once.

## Approach

1. Create an integer array of size 26.
2. Traverse the string and count each character's frequency.
3. Traverse the string again from left to right.
4. Check the frequency of each character.
5. If its frequency is 1, return its index.
6. If no unique character exists, return -1.

## Java Code

class Solution {
    public int firstUniqChar(String s) {

        int[] frequency = new int[26];

        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (frequency[ch - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}

## Complexity

Time Complexity: O(n)
Space Complexity: O(1)

## Key Learning

- String traversal
- charAt()
- Character frequency
- Integer array
- Index-based searching
- First non-repeating character

## Status

Completed: Day 39
