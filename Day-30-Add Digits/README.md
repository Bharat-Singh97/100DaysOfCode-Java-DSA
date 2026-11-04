# Day 30 - Add Digits

## Problem
LeetCode 258: Add Digits

Given an integer num, repeatedly add all its digits
until the result has only one digit.

Return the final single-digit number.

## Examples

Input: num = 38
Output: 2

Explanation:
3 + 8 = 11
1 + 1 = 2

Input: num = 0
Output: 0

Input: num = 123
Output: 6

Explanation:
1 + 2 + 3 = 6

## Approach

1. Check whether the number has more than one digit.
2. Initialize sum = 0.
3. Extract the last digit using num % 10.
4. Add the digit to sum.
5. Remove the last digit using num / 10.
6. Repeat until all digits are added.
7. Assign sum back to num.
8. Repeat until num becomes a single digit.
9. Return num.

## Java Code

class Solution {
    public int addDigits(int num) {

        while (num >= 10) {

            int sum = 0;

            while (num > 0) {
                int digit = num % 10;
                sum += digit;
                num = num / 10;
            }

            num = sum;
        }

        return num;
    }
}

## Complexity

Time Complexity: O(log n)
Space Complexity: O(1)

## Key Learning

- Modulo operator (%)
- Integer division (/)
- Digit extraction
- Nested while loop
- Repeated digit sum
- Number manipulation

## Status

Completed: Day 30
