# Day 35 - Reverse Bits

## Problem
LeetCode 190: Reverse Bits

Reverse the bits of a given 32-bit unsigned integer
and return the resulting integer.

## Examples

Input: n = 00000010100101000001111010011100
Output: 00111001011110000010100101000000

Input: n = 11111111111111111111111111111101
Output: 10111111111111111111111111111111

## Approach

1. Initialize result = 0.
2. Repeat the process for all 32 bits.
3. Shift result left by one bit.
4. Extract the last bit of n using n & 1.
5. Add that bit to result using bitwise OR.
6. Shift n right using unsigned right shift (>>>).
7. Return result after processing all 32 bits.

## Java Code

class Solution {
    public int reverseBits(int n) {

        int result = 0;

        for (int i = 0; i < 32; i++) {

            result <<= 1;

            result |= (n & 1);

            n >>>= 1;
        }

        return result;
    }
}

## Complexity

Time Complexity: O(1) - exactly 32 iterations
Space Complexity: O(1)

## Key Learning

- Bit manipulation
- Bitwise AND (&)
- Bitwise OR (|)
- Left shift (<<)
- Unsigned right shift (>>>)
- 32-bit integer representation

## Status

Completed: Day 35
