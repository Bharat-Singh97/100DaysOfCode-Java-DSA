# Day 34 - Number of 1 Bits

## Problem
LeetCode 191: Number of 1 Bits

Given a positive integer n, return the number of set bits
in its binary representation.

A set bit is a bit whose value is 1.

## Examples

Input: n = 11
Output: 3

Explanation:
Binary representation of 11 = 1011
Number of set bits = 3

Input: n = 128
Output: 1

Explanation:
Binary representation of 128 = 10000000

Input: n = 2147483645
Output: 30

## Approach

1. Initialize count = 0.
2. Check the last bit using n & 1.
3. If the last bit is 1, increase count.
4. Shift n right by one bit using unsigned right shift (>>>).
5. Repeat until n becomes 0.
6. Return count.

## Java Code

class Solution {
    public int hammingWeight(int n) {

        int count = 0;

        while (n != 0) {
            count += (n & 1);
            n >>>= 1;
        }

        return count;
    }
}

## Complexity

Time Complexity: O(1) for a fixed 32-bit integer
Space Complexity: O(1)

## Key Learning

- Binary representation
- Bitwise AND (&)
- Unsigned right shift (>>>)
- Counting set bits
- Bit manipulation

## Status

Completed: Day 34
