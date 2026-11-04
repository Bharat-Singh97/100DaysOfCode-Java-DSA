# Day 36 - Missing Number

## Problem
LeetCode 268: Missing Number

Given an array nums containing n distinct numbers
in the range [0, n], return the only number
that is missing from the array.

## Examples

Input: nums = [3,0,1]
Output: 2

Input: nums = [0,1]
Output: 2

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8

## Approach

1. Find the length of the array.
2. Calculate the expected sum from 0 to n.
3. Calculate the actual sum of all array elements.
4. Subtract the actual sum from the expected sum.
5. Return the difference as the missing number.

## Java Code

class Solution {
    public int missingNumber(int[] nums) {

        int n = nums.length;

        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}

## Complexity

Time Complexity: O(n)
Space Complexity: O(1)

## Key Learning

- Arrays
- For-each loop
- Sum formula
- Missing number logic
- Mathematical approach

## Status

Completed: Day 36
