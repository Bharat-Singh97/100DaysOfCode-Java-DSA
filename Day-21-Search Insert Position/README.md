# Day 21 - Search Insert Position

## 📝 Problem

Given a sorted array of distinct integers and a target value, return the index if the target is found.

If the target is not found, return the index where it would be inserted in order.

Example 1:

Input: nums = [1,3,5,6], target = 5

Output: 2

Example 2:

Input: nums = [1,3,5,6], target = 2

Output: 1

Example 3:

Input: nums = [1,3,5,6], target = 7

Output: 4

---

## 💡 Approach 1: Brute Force

Used Linear Search.

Traverse the array from left to right.

Find the first index where nums[i] is greater than or equal to target.

If no such element exists, return nums.length.

### Java Code

class Solution {
    public int searchInsert(int[] nums, int target) {

        // Traverse the array from left to right
        for (int i = 0; i < nums.length; i++) {

            // Find the first element greater than or equal to target
            if (nums[i] >= target) {
                return i;
            }
        }

        // If target is greater than all elements, return the end index
        return nums.length;
    }
}

---

## ⚙️ Brute Force Algorithm

1. Traverse the array from left to right.
2. Check whether nums[i] >= target.
3. If true, return index i.
4. If no such element exists, return nums.length.

---

## ⏱️ Brute Force Time Complexity

O(n)

In the worst case, the entire array may need to be traversed.

---

## 💾 Brute Force Space Complexity

O(1) auxiliary space

Only a loop variable is used. No extra array or collection is created.

---

## ⚡ Approach 2: Optimized

Used Binary Search.

Since the array is sorted, we can eliminate half of the search range in each iteration.

Initialize left = 0 and right = nums.length - 1.

Calculate the middle index  mid = left + (right - left)/2.

If nums[mid] equals target, return mid.

If nums[mid] is smaller than target, search the right half.

Otherwise, search the left half.

When the loop ends, left represents the correct insertion position.

### Java Code

class Solution {
    public int searchInsert(int[] nums, int target) {

        // Define the search boundaries
        int left = 0;
        int right = nums.length - 1;

        // Continue while the search range is valid
        while (left <= right) {

            // Calculate the middle index safely
            int mid = left + (right - left) / 2;

            // Return the index if target is found
            if (nums[mid] == target) {
                return mid;
            }

            // Search the right half
            if (nums[mid] < target) {
                left = mid + 1;
            }
            // Search the left half
            else {
                right = mid - 1;
            }
        }

        // Left is the correct insertion position
        return left;
    }
}

---

## ⚙️ Optimized Algorithm

1. Initialize left = 0.
2. Initialize right = nums.length - 1.
3. Continue while left <= right.
4. Calculate mid = left + (right - left) / 2.
5. If nums[mid] == target, return mid.
6. If nums[mid] < target, update left = mid + 1.
7. Otherwise, update right = mid - 1.
8. When the loop ends, return left.

---

## ⏱️ Optimized Time Complexity

O(log n)

The search range is approximately halved in each iteration.

---

## 💾 Optimized Space Complexity

O(1) auxiliary space

Only the left, right, and mid variables are used.

---

## 🔍 Dry Run

Input: nums = [1,3,5,6], target = 4

| left | right | mid | nums[mid] | Action |
|---|---|---|---|---|
| 0 | 3 | 1 | 3 | left = 2 |
| 2 | 3 | 2 | 5 | right = 1 |

Now left = 2 and right = 1.

The loop terminates because left > right.

Output: 2

The target 4 should be inserted between 3 and 5.

---

## 📊 Brute Force vs Optimized

| Feature | Brute Force | Optimized |
|---|---|---|
| Technique | Linear Search | Binary Search |
| Time Complexity | O(n) | O(log n) |
| Auxiliary Space | O(1) | O(1) |
| Requires Sorted Array | No | Yes |
| Search Strategy | Check elements sequentially | Halve the search range |

Binary Search improves the time complexity by using the sorted order of the array.

---

## 🧠 Pattern

Binary Search | Sorted Array

---

## 🚀 Key Learning

- Linear Search checks elements one by one.
- Binary Search works efficiently on sorted arrays.
- The mid index divides the current search range.
- If nums[mid] < target, move left to mid + 1.
- If nums[mid] > target, move right to mid - 1.
- When the target is not found, left gives the insertion index.
- Binary Search reduces time complexity from O(n) to O(log n).
- Both approaches use O(1) auxiliary space.

---

## 🎯 Pattern Recognition

| If the problem says...Think... |
|---|
| Sorted array | Binary Search |
| Find a target index | Search |
| Find insertion position | Lower Bound |
| Reduce search range | Binary Search |
| Target is larger than all elements | Return nums.length |

---

## ❓ Interview Q&A

Q1. What is Linear Search?

It checks each element sequentially until the target or insertion position is found.

Q2. Why is Binary Search suitable here?

The array is sorted, allowing half of the search range to be eliminated in each iteration.

Q3. What is the time complexity of Binary Search?

O(log n).

Q4. What is the auxiliary space complexity?

O(1), because only a constant number of variables are used.

Q5. Why do we return left after the loop?

When the search ends, left points to the correct insertion position.

Q6. What happens if the target is greater than every element?

The left pointer becomes nums.length, so that value is returned.

Q7. Why use left + (right - left) / 2?

It calculates the middle index while reducing the risk of integer overflow compared with (left + right) / 2.

Q8. What is the main difference between Linear Search and Binary Search?

Linear Search takes O(n) time in the worst case, while Binary Search takes O(log n) time on a sorted array.

---

## 📌 Tags

Java, DSA, Array, Binary Search, Linear Search, LeetCode, Problem Solving, Java Developer

---

## 🔗 Problem Link

https://leetcode.com/problems/search-insert-position/
