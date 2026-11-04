# Day 31 - Power of Two

## Problem
LeetCode 231: Power of Two

Given an integer n, return true if it is a power of two.
Otherwise, return false.

A number is a power of two if it can be written as 2^x,
where x is a non-negative integer.

## Examples

Input: n = 1
Output: true

Explanation: 2^0 = 1

Input: n = 16
Output: true

Explanation: 2^4 = 16

Input: n = 3
Output: false

Input: n = 0
Output: false

## Approach

1. Check if n is less than or equal to 0.
2. If n is not positive, return false.
3. Divide n by 2 while it is divisible by 2.
4. After the loop, check whether n becomes 1.
5. If n becomes 1, return true.
6. Otherwise, return false.

## Java Code

class Solution {
    public boolean isPowerOfTwo(int n) {

        if (n <= 0) {
            return false;
        }

        while (n % 2 == 0) {
            n = n / 2;
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
- Power of two logic
- Number manipulation

## Status

Completed: Day 31
