# Day 37 - Single Number

## Problem
LeetCode 136: Single Number

Given a non-empty array of integers nums,
every element appears twice except for one.

Find the element that appears only once.

Your solution should have linear runtime complexity
and use constant extra space.

## Examples

Input: nums = [2,2,1]
Output: 1

Input: nums = [4,1,2,1,2]
Output: 4

Input: nums = [1]
Output: 1

## Approach

1. Initialize result = 0.
2. Traverse every element in the array.
3. Apply XOR operation between result and the current element.
4. Store the XOR result.
5. After processing all elements, return result.

## Java Code

class Solution {
    public int singleNumber(int[] nums) {

        int result = 0;

        for (int num : nums) {
            result = result ^ num;
        }

        return result;
    }
}

## Complexity

Time Complexity: O(n)
Space Complexity: O(1)

## Key Learning

- Arrays
- For-each loop
- Bitwise XOR (^)
- XOR properties
- Finding unique elements

## XOR Properties

a ^ a = 0
a ^ 0 = a

Example:

2 ^ 2 ^ 1
= 0 ^ 1
= 1

## Status

Completed: Day 37
