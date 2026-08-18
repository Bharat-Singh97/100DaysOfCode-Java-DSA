# Day 15 - Product of Array Except Self

## 📝 Problem

Given an integer array `nums`, return an array where each element is the product of all elements except itself.

Example:

Input: `nums = [1,2,3,4]`

Output: `[24,12,8,6]`

---

## 💡 Approach

Used Prefix Product + Suffix Product.

First pass stores the product of elements on the left.

Second pass multiplies the product of elements on the right.

No division is used.

---

## ⚙️ Algorithm

1. Create an output array of size `nums.length`.
2. Initialize `leftProduct = 1`.
3. Traverse from left to right.
4. Store `leftProduct` in the output array.
5. Update `leftProduct` using `nums[i]`.
6. Initialize `rightProduct = 1`.
7. Traverse from right to left.
8. Multiply the output by `rightProduct`.
9. Update `rightProduct` using `nums[i]`.
10. Return the output array.

---

## ⏱️ Time Complexity

**O(n)**

Two separate loops → `O(n) + O(n) = O(n)`.

---

## 💾 Space Complexity

**O(1)** auxiliary space

The output array is not counted as extra space.

**Output Space:** `O(n)`

---

## 🧠 Pattern

Prefix Product | Suffix Product

---

## 🚀 Key Learning

- Avoid repeated calculations by reusing previous products.
- `leftProduct` stores the product of elements before the current index.
- `rightProduct` stores the product of elements after the current index.
- Two non-nested loops give `O(n)` time.
- Output space is excluded from auxiliary space.

---

## 🎯 Pattern Recognition

| If the problem says... | Think... |
|-------------------------|----------|
| Product except self | ✅ Prefix + Suffix |
| Avoid division | ✅ Left + Right Product |
| Repeated calculations | ✅ Reuse previous results |
| Two separate passes | ✅ O(n) |

---

## ❓ Interview Q&A

**Q1. Why is the optimized solution O(n)?**

A. The two loops are separate, not nested.  
`O(n) + O(n) = O(n)`.

**Q2. Why initialize `leftProduct` and `rightProduct` with `1`?**

A. `1` is the multiplicative identity, so multiplying by `1` does not change the product.

**Q3. Why traverse from right to left in the second pass?**

A. To maintain the product of elements on the right and combine it with the left product.

**Q4. Why is auxiliary space O(1)?**

A. The output array is excluded from auxiliary space, and only constant extra variables are used.

**Q5. Why is brute force O(n²)?**

A. For every index, we traverse the array again, causing repeated calculations.

---

## 📌 Tags

`Java` `DSA` `Array` `Prefix Product` `Suffix Product` `LeetCode` `Problem Solving`
