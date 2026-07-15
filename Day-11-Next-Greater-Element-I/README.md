# Day 11 - Next Greater Element I

## 📝 Problem

Given two arrays `nums1` and `nums2`, find the next greater element for each element in `nums1` based on its position in `nums2`.

---

## 💡 Approach

- Traverse `nums2` from **right to left**.
- Use a **Monotonic Stack** to find the next greater element for every number.
- Store the mapping `(number → next greater number)` in a **HashMap**.
- Traverse `nums1` and retrieve answers directly from the HashMap.

---

## ⏱️ Time Complexity

**O(n)**

- Traverse `nums2` once.
- Traverse `nums1` once.
- Stack operations are O(1) amortized.

---

## 💾 Space Complexity

**O(n)**

- HashMap stores mappings for elements.
- Stack stores elements while processing.

---

## 🧠 Pattern

- Monotonic Stack
- HashMap

---

## 🚀 Key Learning

- Monotonic Stack helps eliminate repeated comparisons.
- Traversing from **right to left** makes it easier to know the next greater element.
- Remove all smaller (or equal) elements before finding the answer.
- HashMap provides **O(1)** lookup for the final answers.

---

## 📌 Tags

`Java` `DSA` `LeetCode` `Monotonic Stack` `HashMap`
