# Day 29 - Palindrome Number

## Problem
LeetCode 9: Palindrome Number

Given an integer x, return true if x is a palindrome, and false otherwise.

A palindrome number reads the same backward as forward.

## Examples

Input: x = 121
Output: true

Input: x = -121
Output: false

Input: x = 120
Output: false

## Approach

1. Check if the number is negative.
2. Store the original number.
3. Extract the last digit using the modulo operator (%).
4. Reverse the number digit by digit.
5. Remove the last digit using integer division (/).
6. Compare the original number with the reversed number.

## Java Code

class Solution {
    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        int original = x;
        int reverse = 0;

        while (x > 0) {
            int digit = x % 10;
            reverse = reverse * 10 + digit;
            x = x / 10;
        }

        return original == reverse;
    }
}

## Complexity

Time Complexity: O(log n)
Space Complexity: O(1)

## Key Learning

- Modulo operator (%)
- Integer division (/)
- Number reversal
- While loop
- Palindrome logic

