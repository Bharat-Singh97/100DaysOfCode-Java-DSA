# Day 19 - Remove Duplicates from Sorted Array

## 📝 Problem

Given a sorted integer array `nums`, remove duplicates in-place so that each unique element appears only once.

Return the number of unique elements `k`. The first `k` elements of the array must contain the unique elements in their original sorted order.

Example:

Input: `nums = [1,1,2,2,3]`

Output: `k = 3`, `nums = [1,2,3,_,_]`

---

## 💡 Approach

Used Two Pointers.

The `i` pointer tracks the position of the last unique element, while the `j` pointer traverses the array to find new unique elements.

When `nums[i] != nums[j]`, increment `i` and copy `nums[j]` to `nums[i]`.

Finally, return `i + 1` as the number of unique elements.

---

## ⚙️ Algorithm

1. If the array is empty, return `0`.
2. Initialize `i = 0`.
3. Traverse the array using `j` from index `1`.
4. Compare `nums[i]` with `nums[j]`.
5. If both are different, increment `i`.
6. Copy `nums[j]` to `nums[i]`.
7. Continue until the array is traversed.
8. Return `i + 1`.

---

## ⏱️ Time Complexity

**O(n)**

A single loop traverses the array → `O(n)`.

---

## 💾 Space Complexity

**O(1)** auxiliary space

The original array is modified in-place, and only constant extra variables are used.

---

## 🧠 Pattern

Two Pointers | In-Place Array Modification

---

## 🚀 Key Learning

- A sorted array places duplicate elements next to each other.
- Use two pointers to identify unique elements efficiently.
- `i` tracks the last unique element's position.
- `j` scans the remaining elements.
- `i + 1` gives the count of unique elements.
- In-place modification avoids using an extra array.

---

## 🎯 Pattern Recognition

| **If the problem says...Think...** | |
| ---------------------------------- | ------------------------ |
| Sorted array with duplicates       | ✅ Adjacent comparison    |
| Remove duplicates in-place         | ✅ Two Pointers           |
| Return unique element count        | ✅ `i + 1`                |
| Avoid an extra array               | ✅ O(1) auxiliary space   |

---

## ❓ Interview Q&A

**Q1. Why is the time complexity O(n)?**

A. The array is traversed once using the `j` pointer.

**Q2. Why does the algorithm work for a sorted array?**

A. Duplicate values appear next to each other, so adjacent comparisons are sufficient.

**Q3. What is the purpose of pointer `i`?**

A. It tracks the position of the last unique element.

**Q4. Why do we return `i + 1`?**

A. Array indexing starts at `0`, so the last unique element's index plus one gives the count.

**Q5. Why is auxiliary space O(1)?**

A. The array is modified directly without creating another array.

---

## 📌 Tags

`Java` `DSA` `Array` `Two Pointers` `Sorted Array` `In-Place Algorithm` `LeetCode` `Problem Solving`
