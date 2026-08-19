# Day 16 - Maximum Product Subarray

## 📝 Problem

Given an integer array `nums`, find the contiguous subarray that has the largest product and return the product.

Example:

Input: `nums = [-2,3,-4]`

Output: `24`

---

## 💡 Approach

Used Dynamic Programming with `currentMax` and `currentMin`.

For every element, maintain the maximum and minimum product ending at the current position.

We maintain both because a negative number can turn the minimum product into the maximum product.

Example:

`-6 × -4 = 24`

---

## ⚙️ Algorithm

1. Initialize `currentMax` with `nums[0]`.
2. Initialize `currentMin` with `nums[0]`.
3. Initialize `maxProduct` with `nums[0]`.
4. Traverse the array from index `1`.
5. Store the current element in `current`.
6. Calculate `newMax` from:
   - `current`
   - `current × currentMax`
   - `current × currentMin`
7. Calculate `newMin` from the same three possibilities.
8. Update `currentMax` with `newMax`.
9. Update `currentMin` with `newMin`.
10. Update `maxProduct` using `currentMax`.
11. Return `maxProduct`.

---

## ⏱️ Time Complexity

**O(n)**

Only one loop is used, so every element is processed once.

---

## 💾 Space Complexity

**O(1)**

Only a fixed number of variables are used.

No extra array or data structure is required.

---

## 🧠 Pattern

Running Maximum | Running Minimum

---

## 🚀 Key Learning

- Maintain both maximum and minimum products.
- A negative number can change the minimum product into the maximum product.
- `currentMax` stores the maximum product ending at the current index.
- `currentMin` stores the minimum product ending at the current index.
- `maxProduct` stores the overall maximum answer.
- Calculate `newMax` and `newMin` before updating the current values.
- A single traversal gives **O(n)** time.

---

## 🎯 Pattern Recognition

| **If the problem says...Think...** | |
| ---------------------------------- | ------------------------ |
| Maximum product subarray           | ✅ Running Max + Min      |
| Negative numbers involved          | ✅ Track both Max + Min   |
| Product can change sign            | ✅ Maintain Minimum       |
| Contiguous subarray                | ✅ Running product        |
| One-pass optimization              | ✅ O(n)                   |

---

## ❓ Interview Q&A

**Q1. Why do we maintain both `currentMax` and `currentMin`?**

A. A negative number can turn the minimum negative product into the maximum positive product.

**Q2. Why initialize `currentMax`, `currentMin`, and `maxProduct` with `nums[0]`?**

A. The first element itself is a valid subarray, and this also correctly handles arrays containing only negative numbers.

**Q3. Why does `newMax` consider three possibilities?**

A. The maximum product ending at the current index can be the current element itself, `current × currentMax`, or `current × currentMin`.

**Q4. Why does `newMin` also consider the same three possibilities?**

A. We need to keep the smallest product because a future negative number can turn it into the maximum product.

**Q5. Why can `currentMin` become `currentMax`?**

A. When a negative number is multiplied by a negative minimum product, the result becomes positive.

Example:

`-6 × -4 = 24`

**Q6. Why is the optimized solution O(n)?**

A. There is only one loop, and each element is processed once.

**Q7. Why is the space complexity O(1)?**

A. Only a fixed number of variables are used regardless of the input size.

**Q8. Why is brute force O(n²)?**

A. We use nested loops to calculate the product of every possible subarray.

---

## 📌 Tags

`Java` `DSA` `Array` `Dynamic Programming` `Maximum Product` `LeetCode` `Problem Solving`
