
# Day 22 - Find First and Last Position of Element in Sorted Array

**LeetCode Problem:** 34  
**Difficulty:** Medium  
**Language:** Java  
**Pattern:** Binary Search

## 📝 Problem

Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given target value.

If the target is not found in the array, return `[-1, -1]`.

The solution must run in O(log n) time.

### Example 1

Input:
nums = [5, 7, 7, 8, 8, 10]
target = 8

Output:
[3, 4]

### Example 2

Input:
nums = [5, 7, 7, 8, 8, 10]
target = 6

Output:
[-1, -1]

### Example 3

Input:
nums = []
target = 0

Output:
[-1, -1]

---

## 💡 Approach 1: Brute Force

Traverse the entire array from left to right.

- Initialize `first = -1` and `last = -1`.
- When the target is found for the first time, store its index in `first`.
- Every time the target is found, update `last`.
- Return `[first, last]`.

### Java Code

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {

        // Initialize first and last occurrence as -1
        int first = -1;
        int last = -1;

        // Traverse the complete array
        for (int i = 0; i < nums.length; i++) {

            // Check whether the current element is the target
            if (nums[i] == target) {

                // Store the first occurrence only once
                if (first == -1) {
                    first = i;
                }

                // Update the last occurrence at every match
                last = i;
            }
        }

        // Return both indices; -1 if target is not found
        return new int[] {first, last};
    }
}
```

### Algorithm

1. Initialize `first` and `last` to `-1`.
2. Traverse the array using a `for` loop.
3. If `nums[i] == target`, store `i` in `first` if it is the first match.
4. Update `last = i` for every match.
5. Return the array containing both indices.

### Dry Run

Input:
nums = [5, 7, 7, 7, 8, 10]
target = 7

| Index | Value | First | Last |
|---|---|---|---|
| 0 | 5 | -1 | -1 |
| 1 | 7 | 1 | 1 |
| 2 | 7 | 1 | 2 |
| 3 | 7 | 1 | 3 |
| 4 | 8 | 1 | 3 |
| 5 | 10 | 1 | 3 |

Output: `[1, 3]`

### Complexity

**Time Complexity: O(n)**

The entire array may need to be traversed.

**Auxiliary Space: O(1)**

Only a constant number of variables are used, excluding the returned array.

---

## 🚀 Approach 2: Optimized Binary Search

Because the array is sorted, binary search can find the boundaries in logarithmic time.

Use two binary searches:

- First binary search: Find the first occurrence.
- Second binary search: Find the last occurrence.

### Java Code

```java
class Solution {

    // Find the first occurrence of the target
    public int firstRange(int[] nums, int target) {

        int first = -1;                 // Store first matching index
        int left = 0;                   // Start of search range
        int right = nums.length - 1;    // End of search range

        // Continue while the search range is valid
        while (left <= right) {

            // Calculate middle index safely
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {

                first = mid;            // Save current match
                right = mid - 1;        // Search the left half

            } else if (nums[mid] < target) {

                left = mid + 1;         // Target may be on the right

            } else {

                right = mid - 1;        // Target may be on the left
            }
        }

        // Return first index, or -1 if not found
        return first;
    }

    // Find the last occurrence of the target
    public int lastRange(int[] nums, int target) {

        int last = -1;                  // Store last matching index
        int left = 0;                   // Start of search range
        int right = nums.length - 1;    // End of search range

        // Continue while the search range is valid
        while (left <= right) {

            // Calculate middle index safely
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {

                last = mid;             // Save current match
                left = mid + 1;         // Search the right half

            } else if (nums[mid] < target) {

                left = mid + 1;         // Target may be on the right

            } else {

                right = mid - 1;        // Target may be on the left
            }
        }

        // Return last index, or -1 if not found
        return last;
    }

    // Combine both searches and return the target's range
    public int[] searchRange(int[] nums, int target) {

        // Find the starting and ending indices
        return new int[] {
            firstRange(nums, target),
            lastRange(nums, target)
        };
    }
}
```

### Algorithm

1. Initialize `left = 0` and `right = nums.length - 1`.
2. Calculate the middle index safely.
3. For the first occurrence:
   - If the target is found, save `mid` and continue searching left.
   - If the middle value is smaller than the target, move right.
   - Otherwise, move left.
4. For the last occurrence:
   - If the target is found, save `mid` and continue searching right.
   - If the middle value is smaller than the target, move right.
   - Otherwise, move left.
5. Return both indices in an integer array.

### Dry Run: First Occurrence

Input:
nums = [5, 7, 7, 7, 10]
target = 7

| Step | Left | Right | Mid | Value | Action |
|---|---|---|---|---|---|
| 1 | 0 | 4 | 2 | 7 | Save first = 2; move left |
| 2 | 0 | 1 | 0 | 5 | Move left boundary to 1 |
| 3 | 1 | 1 | 1 | 7 | Save first = 1; move left |
| 4 | 1 | 0 | - | - | Stop |

First occurrence = `1`

### Dry Run: Last Occurrence

Input:
nums = [5, 7, 7, 7, 10]
target = 7

| Step | Left | Right | Mid | Value | Action |
|---|---|---|---|---|---|
| 1 | 0 | 4 | 2 | 7 | Save last = 2; move right |
| 2 | 3 | 4 | 3 | 7 | Save last = 3; move right |
| 3 | 4 | 4 | 4 | 10 | Move right boundary to 3 |
| 4 | 4 | 3 | - | - | Stop |

Last occurrence = `3`

Output: `[1, 3]`

### Complexity

**Time Complexity: O(log n)**

Each binary search takes O(log n). Running two binary searches still gives O(log n) overall time.

**Auxiliary Space: O(1)**

Only a constant number of variables are used, excluding the returned array.

---

## 📊 Brute Force vs Optimized Approach

| Feature | Brute Force | Binary Search |
|---|---|---|
| Technique | Linear Traversal | Binary Search |
| Time Complexity | O(n) | O(log n) |
| Auxiliary Space | O(1) | O(1) |
| Requires Sorted Array | No | Yes |
| Number of Traversals | One full traversal | Two binary searches |
| Best Use | Simple baseline solution | Efficient solution for sorted arrays |

---

## 🧠 Pattern

**Binary Search + Boundary Search**

- First Occurrence: Move left after finding the target.
- Last Occurrence: Move right after finding the target.
- Sorted Array: Use binary search to reduce the search space by half.

---

## 🚀 Key Learning

- Learned how to find the first and last occurrences of a target.
- Practiced binary search on a sorted array.
- Understood why finding a match does not always mean the search should stop.
- Learned to move left to find the first occurrence.
- Learned to move right to find the last occurrence.
- Compared linear traversal with binary search.
- Practiced handling missing targets and empty arrays.
- Learned to reuse binary search logic through separate methods.

---

## 🎯 Pattern Recognition

| If the problem says... | Think... |
|---|---|
| Array is sorted | Binary Search |
| Find the first occurrence | Binary Search toward the left |
| Find the last occurrence | Binary Search toward the right |
| Find a target's range | Two Boundary Searches |
| Target does not exist | Return `[-1, -1]` |
| Reduce O(n) to O(log n) | Binary Search |

---

## ❓ Interview Q&A

**Q1. Why is binary search suitable for this problem?**

Because the array is sorted, we can eliminate half of the search space in each iteration.

**Q2. Why do we use two binary searches?**

One finds the first occurrence, while the other finds the last occurrence.

**Q3. Why do we continue searching after finding the target?**

The target may occur multiple times, so we must find the correct boundary.

**Q4. How do you find the first occurrence?**

Save the matching index and set `right = mid - 1`.

**Q5. How do you find the last occurrence?**

Save the matching index and set `left = mid + 1`.

**Q6. What if the target is absent?**

Both indices remain `-1`, so the result is `[-1, -1]`.

**Q7. What is the time complexity of the optimized solution?**

O(log n), because it performs two binary searches.

**Q8. What is the auxiliary space complexity?**

O(1), because only a constant number of variables are used.

**Q9. Why calculate mid as `left + (right - left) / 2`?**

It avoids the potential integer overflow of `(left + right) / 2`.

---

## 📌 Tags

`Java` `DSA` `LeetCode` `Binary Search` `Array` `Medium` `Problem Solving`

## 🔗 Links

LeetCode: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/


---

**Day 22 Completed — Find First and Last Position of Element in Sorted Array**

Today I learned how to optimize a linear search solution using two binary searches to achieve O(log n) time complexity.
