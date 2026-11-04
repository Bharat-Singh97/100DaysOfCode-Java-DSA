## Day 41 - Intersection of Two Arrays

### Problem
LeetCode 349: Intersection of Two Arrays

Given two integer arrays nums1 and nums2, return
an array containing their intersection.

Each element in the result must be unique.

The result can be returned in any order.

### Examples

Input:
nums1 = [1,2,2,1]
nums2 = [2,2]

Output:
[2]

Explanation:
The number 2 is present in both arrays.
It appears only once in the result.

Input:
nums1 = [4,9,5]
nums2 = [9,4,9,8,4]

Output:
[4,9]

Explanation:
The numbers 4 and 9 are common to both arrays.

### Approach

1. Create a HashSet to store elements from nums1.
2. Traverse nums1 and add every element to the HashSet.
3. Create an ArrayList to store common elements.
4. Traverse nums2.
5. Check whether the current element exists in the HashSet.
6. Check whether the element is already present in the result.
7. If both conditions are true, add the element to the result.
8. Create an integer array with the size of the result.
9. Copy the ArrayList elements into the integer array.
10. Return the final array.

### Java Code

import java.util.HashSet;
import java.util.ArrayList;

class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();

        ArrayList<Integer> result = new ArrayList<>();

        // Step 1: Store nums1 elements in HashSet
        for (int num : nums1) {
            set.add(num);
        }

        // Step 2: Find common unique elements
        for (int num : nums2) {

            if (set.contains(num) && !result.contains(num)) {

                result.add(num);
            }
        }

        // Step 3: Convert ArrayList into int[]
        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {

            answer[i] = result.get(i);
        }

        // Step 4: Return result
        return answer;
    }
}

### Complexity

Time Complexity:
O(n + m) average for HashSet operations,
plus result.contains() scanning.

Space Complexity:
O(n + m)

n = nums1.length
m = nums2.length

### Key Learning

- Array
- HashSet
- ArrayList
- Array traversal
- contains() method
- Duplicate handling
- ArrayList to Array conversion
- Common elements

### Status

Completed: Day 41
