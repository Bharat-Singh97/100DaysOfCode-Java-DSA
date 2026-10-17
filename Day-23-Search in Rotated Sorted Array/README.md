# Day 23 - Search in Rotated Sorted Array

## 📝 Problem

LeetCode 33: Search in Rotated Sorted Array

Given an array of distinct integers that was originally sorted in ascending order and then rotated at an unknown pivot, find the index of the target element.

Return -1 if the target does not exist.

The solution must run in O(log n) time.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1

---

## 💡 Approach 1: Brute Force

Check every element from left to right.

If the current element equals the target, return its index.
If the loop finishes without finding the target, return -1.

### Java Code

public static int searchBruteForce(int[] arr, int target) {

    // Traverse every element in the array
    for (int i = 0; i < arr.length; i++) {

        // Check whether the current element is the target
        if (arr[i] == target) {
            return i;
        }
    }

    // Target was not found
    return -1;
}

### Time Complexity

O(n)

In the worst case, every element must be checked.

### Auxiliary Space Complexity

O(1)

Only a constant amount of extra space is used.

---

## 💡 Approach 2: Optimized Binary Search

The array is rotated, so the entire array is not necessarily sorted.

However, because all elements are distinct, at least one half of the current search range is sorted.

Steps:

1. Initialize left = 0 and right = arr.length - 1.
2. Calculate the middle index.
3. If arr[mid] equals target, return mid.
4. If the left half is sorted, check whether the target lies within its range.
5. If it does, search the left half.
6. Otherwise, search the right half.
7. If the left half is not sorted, the right half must be sorted. Check whether the target lies in the right half.
8. Continue until the target is found or left exceeds right.
9. Return -1 if the target is absent.

### Java Code

public static int searchInRotatedSortedArray(int[] arr, int target) {

    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {

        // Calculate the middle index safely
        int mid = left + (right - left) / 2;

        // Target found
        if (arr[mid] == target) {
            return mid;
        }

        // Check whether the left half is sorted
        if (arr[left] <= arr[mid]) {

            // Check whether target lies in the sorted left half
            if (arr[left] <= target && target < arr[mid]) {
                right = mid - 1;
            } else {
                // Search the right half
                left = mid + 1;
            }

        } else {

            // The right half is sorted

            // Check whether target lies in the sorted right half
            if (arr[mid] < target && target <= arr[right]) {
                left = mid + 1;
            } else {
                // Search the left half
                right = mid - 1;
            }
        }
    }

    // Target was not found
    return -1;
}

### Time Complexity

O(log n)

The search range is reduced by approximately half in every iteration.

### Auxiliary Space Complexity

O(1)

The algorithm uses a constant amount of extra space.

---

## 🔍 Dry Run

Array: [4,5,6,7,0,1,2]
Target: 0

Iteration 1:
left = 0, right = 6, mid = 3
arr[mid] = 7

The left half [4,5,6,7] is sorted.
Target 0 is not in this half.
Update left = mid + 1 = 4.

Iteration 2:
left = 4, right = 6, mid = 5
arr[mid] = 1

The left half [0,1] is sorted.
Target 0 belongs to this half.
Update right = mid - 1 = 4.

Iteration 3:
left = 4, right = 4, mid = 4
arr[mid] = 0

Target found at index 4.

Output: 4

---

## ⚖️ Brute Force vs Optimized

Brute Force:
Time Complexity: O(n)
Auxiliary Space: O(1)
Technique: Linear Search

Optimized:
Time Complexity: O(log n)
Auxiliary Space: O(1)
Technique: Modified Binary Search

The optimized approach satisfies the logarithmic time requirement.

---

## 🧠 Pattern

Modified Binary Search
Sorted Half Identification
Search Space Reduction

---

## 🚀 Key Learning

- A rotated array is not completely sorted.
- At least one half remains sorted when elements are distinct.
- Identify the sorted half before deciding which direction to search.
- Check whether the target belongs to the sorted half's range.
- Use left and right pointers to reduce the search space.
- Return -1 when the target does not exist.
- Binary search improves the time complexity from O(n) to O(log n).

---

## 🎯 Pattern Recognition

If the problem says:
"Sorted array" and "search in O(log n)"
Think: Binary Search

If the problem says:
"Sorted array rotated at an unknown pivot"
Think: Modified Binary Search

If the problem says:
"Find the target in a rotated sorted array with distinct values"
Think: Identify the sorted half and eliminate the other half.

---

## ❓ Interview Q&A

Q1. What is a rotated sorted array?
An originally sorted array rotated at an unknown pivot.

Q2. Why does modified binary search work?
At least one half is sorted when all elements are distinct.

Q3. How do you identify a sorted left half?
Check whether arr[left] <= arr[mid].

Q4. What is the optimized time complexity?
O(log n).

Q5. What is the auxiliary space complexity?
O(1).

Q6. Why calculate mid as left + (right - left) / 2?
To avoid potential integer overflow.

Q7. What do you return if the target is absent?
-1.

---

## 📌 Tags

Java, DSA, LeetCode 33, Binary Search,
Rotated Sorted Array, Interview Preparation, Java Developer 
