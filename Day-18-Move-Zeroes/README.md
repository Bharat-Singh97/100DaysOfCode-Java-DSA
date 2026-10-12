# Day 18 - Move Zeroes

## 📝 Problem

Given an integer array `nums`, move all zeros to the end while maintaining the relative order of non-zero elements.

The operation must be performed in-place without using an extra array.

Example:

Input: `nums = [0,1,0,3,12]`

Output: `[1,3,12,0,0]`

---

## 💡 Approach

Used Two Pointers.

The `i` pointer traverses the array, while `j` tracks the position where the next non-zero element should be placed.

First, move all non-zero elements to the beginning. Then fill the remaining positions with zeros.

---

## ⚙️ Algorithm

1. Initialize `j = 0`.
2. Traverse the array using `i`.
3. If `nums[i] != 0`, copy `nums[i]` to `nums[j]`.
4. Increment `j`.
5. After the first loop, all non-zero elements are at the beginning.
6. Start a second loop from `j` to the end.
7. Fill all remaining positions with `0`.

---

## ⏱️ Time Complexity

**O(n)**

Two separate loops → `O(n) + O(n) = O(n)`.

---

## 💾 Space Complexity

**O(1)** auxiliary space

The original array is modified in-place, and only constant extra variables are used.

---

## 🧠 Pattern

Two Pointers | In-Place Array Modification

---

## 🚀 Key Learning

- Use two pointers to separate traversal from placement.
- Preserve the relative order of non-zero elements.
- Modify the original array without creating an extra array.
- Use a second pass to fill the remaining positions with zeros.
- Two separate loops still give `O(n)` time complexity.

---

## 🎯 Pattern Recognition

| **If the problem says...Think...** | |
| ---------------------------------- | ------------------------ |
| Move zeros to the end              | ✅ Two Pointers           |
| Preserve element order              | ✅ Left-to-right traversal |
| Modify the array in-place           | ✅ O(1) auxiliary space    |
| Fill remaining positions            | ✅ Second pass             |

---

## ❓ Interview Q&A

**Q1. Why is the time complexity O(n)?**

A. Two separate loops traverse the array, so `O(n) + O(n) = O(n)`.

**Q2. What is the purpose of pointer `j`?**

A. It tracks the position where the next non-zero element should be placed.

**Q3. Why do we need the second loop?**

A. To fill all remaining positions with zeros.

**Q4. Why is auxiliary space O(1)?**

A. The original array is modified directly, and no extra array is created.

**Q5. Does this approach preserve the order of non-zero elements?**

A. Yes. The array is traversed from left to right, so non-zero elements retain their original order.

---

## 📌 Tags

`Java` `DSA` `Array` `Two Pointers` `In-Place Algorithm` `LeetCode` `Problem Solving`
