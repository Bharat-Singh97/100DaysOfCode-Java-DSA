# Day 17 - Two Sum II - Input Array Is Sorted

## 📝 Problem

Given a **sorted** integer array `numbers` and an integer `target`, find two numbers whose sum is equal to `target`.

Return their **1-based indices**.

Example:

Input: `numbers = [2,7,11,15]`, `target = 9`

Output: `[1,2]`

---

## 💡 Approach

### Brute Force

Use two nested loops to check every possible pair.

For every index `i`, check the elements after it using index `j`.

If `numbers[i] + numbers[j] == target`, return their 1-based indices.

### Optimized - Two Pointers

Because the array is **sorted**, use two pointers:

- `left` starts from the beginning.
- `right` starts from the end.

Calculate the sum of both elements.

- If `sum < target` → move `left++`
- If `sum > target` → move `right--`
- If `sum == target` → pair found.

---

## ⚙️ Algorithm

1. Initialize `left = 0`.
2. Initialize `right = numbers.length - 1`.
3. Run a loop while `left < right`.
4. Calculate `sum = numbers[left] + numbers[right]`.
5. If `sum == target`, return `left + 1` and `right + 1`.
6. If `sum < target`, move `left` forward.
7. If `sum > target`, move `right` backward.
8. Continue until the pair is found.
9. Return `[-1,-1]` as a fallback.

---

## ⏱️ Time Complexity

### Brute Force

**O(n²)**

Two nested loops check the possible pairs.

### Optimized

**O(n)**

The two pointers move through the array from both ends, and each pointer moves at most `n` times.

---

## 💾 Space Complexity

**O(1)**

Only a constant number of variables are used.

No extra data structure is required.

---

## 🧠 Pattern

Two Pointers

---

## 🚀 Key Learning

- A **sorted array** is an important clue for the Two Pointers pattern.
- Start one pointer from the left and one from the right.
- `sum < target` → move `left++`.
- `sum > target` → move `right--`.
- `sum == target` → answer found.
- The problem asks for **1-based indices**, so return `left + 1` and `right + 1`.
- Two nested loops give `O(n²)`.
- Two Pointers reduces the time complexity to `O(n)`.

---

## 🎯 Pattern Recognition

| **If the problem says...Think...** | |
| ---------------------------------- | ------------------------ |
| Sorted array                       | ✅ Two Pointers           |
| Find two elements                  | ✅ Left + Right pointers  |
| Pair sum equals target             | ✅ Two Pointers           |
| Sum is too small                   | ✅ Move left              |
| Sum is too large                   | ✅ Move right             |
| Avoid nested loops                 | ✅ O(n) Two Pointers      |

---

## ❓ Interview Q&A

**Q1. Why is the brute-force solution O(n²)?**

A. Two nested loops are used to check every possible pair, so the time complexity is `O(n²)`.

**Q2. Why can we use Two Pointers?**

A. The array is sorted, so we can use the order of the elements to decide which pointer to move.

**Q3. Why do we start `left` from `0`?**

A. `0` is the first index of the array.

**Q4. Why do we start `right` from `numbers.length - 1`?**

A. `numbers.length - 1` is the last valid index of the array.

**Q5. What happens when `sum < target`?**

A. The sum is too small, so we move `left++` to use a larger value.

**Q6. What happens when `sum > target`?**

A. The sum is too large, so we move `right--` to use a smaller value.

**Q7. Why is the optimized solution O(n)?**

A. Both pointers move through the array without nested traversal, so the total work is linear.

**Q8. Why is the space complexity O(1)?**

A. Only a fixed number of variables are used, regardless of the input size.

**Q9. Why do we return `left + 1` and `right + 1`?**

A. Java arrays use 0-based indexing, but the problem asks for 1-based indices.

**Q10. Why is Two Pointers better than brute force here?**

A. Because the array is sorted, we can eliminate unnecessary pairs instead of checking every possible pair.

---

## 📌 Tags

`Java` `DSA` `Array` `Two Pointers` `Sorted Array` `LeetCode` `Problem Solving`
