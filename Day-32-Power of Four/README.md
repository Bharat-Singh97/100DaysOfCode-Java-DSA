# Day 32 - Power of Four

## Problem
LeetCode 342: Power of Four

Given an integer n, return true if it is a power of four.
Otherwise, return false.

A number is a power of four if it can be written as 4^x,
where x is a non-negative integer.

## Examples

Input: n = 16
Output: true

Explanation: 4^2 = 16

Input: n = 1
Output: true

Explanation: 4^0 = 1

Input: n = 5
Output: false

Input: n = 0
Output: false

## Approach

1. Check if n is less than or equal to 0.
2. If n is not positive, return false.
3. Divide n by 4 while it is divisible by 4.
4. After the loop, check whether n becomes 1.
5. If n becomes 1, return true.
6. Otherwise, return false.

## Java Code

class Solution {
    public boolean isPowerOfFour(int n) {

        if (n <= 0) {
            return false;
        }

        while (n % 4 == 0) {
            n = n / 4;
        }

        return n == 1;
    }
}

## Complexity

Time Complexity: O(log n)
Space Complexity: O(1)

## Key Learning

- While loop
- Modulo operator (%)
- Integer division (/)
- Power of four logic
- Number manipulation

## Status

Completed: Day 32
