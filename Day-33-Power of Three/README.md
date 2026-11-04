# Day 33 - Power of Three

## Problem
LeetCode 326: Power of Three

Given an integer n, return true if it is a power of three.
Otherwise, return false.

A number is a power of three if it can be written as 3^x,
where x is a non-negative integer.

## Examples

Input: n = 27
Output: true

Explanation: 3^3 = 27

Input: n = 1
Output: true

Explanation: 3^0 = 1

Input: n = 9
Output: true

Explanation: 3^2 = 9

Input: n = 10
Output: false

Input: n = 0
Output: false

## Approach

1. Check if n is less than or equal to 0.
2. If n is not positive, return false.
3. Divide n by 3 while it is divisible by 3.
4. After the loop, check whether n becomes 1.
5. If n becomes 1, return true.
6. Otherwise, return false.

## Java Code

class Solution {
    public boolean isPowerOfThree(int n) {

        if (n <= 0) {
            return false;
        }

        while (n % 3 == 0) {
            n = n / 3;
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
- Power of three logic
- Number manipulation

## Status

Completed: Day 33
