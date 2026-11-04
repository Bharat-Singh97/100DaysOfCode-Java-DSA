# Day 40 - Intersection of Two Arrays II

## Problem
LeetCode 350: Intersection of Two Arrays II

Given two integer arrays nums1 and nums2,
return their intersection.

Each element in the result must appear as many times
as it occurs in both arrays.

The result can be returned in any order.

## Examples

Input:
nums1 = [1,2,2,1]
nums2 = [2,2]

Output: [2,2]

Input:
nums1 = [4,9,5]
nums2 = [9,4,9,8,4]

Output: [4,9]

## Approach

1. Create a HashMap to store the frequency of elements in nums1.
2. Traverse nums1 and count each element.
3. Create an ArrayList to store the intersection.
4. Traverse nums2.
5. If an element exists in the HashMap with frequency greater than 0:
   - Add the element to the result.
   - Decrease its frequency by 1.
6. Convert the ArrayList into an integer array.
7. Return the result.

## Java Code

import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int num : nums2) {

            if (map.containsKey(num) && map.get(num) > 0) {

                result.add(num);

                map.put(num, map.get(num) - 1);
            }
        }

        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}

## Complexity

Time Complexity: O(n + m)
Space Complexity: O(n)

n = nums1.length
m = nums2.length

## Key Learning

- Arrays
- HashMap
- Frequency counting
- getOrDefault()
- ArrayList
- Duplicate handling
- Array conversion

## Status

Completed: Day 40
