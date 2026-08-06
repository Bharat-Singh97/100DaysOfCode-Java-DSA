# Day 14 - Valid Palindrome

## 📝 Problem

Check whether a string is a palindrome after ignoring non-alphanumeric characters and letter case.

---

## 💡 Approach

- Use Two Pointers (`left` and `right`).
- Skip non-alphanumeric characters.
- Convert both characters to lowercase.
- Compare the characters.
- Move both pointers toward the center.
- If any pair doesn't match, return `false`.

---

## ⚙️ Algorithm

1. Initialize `left = 0` and `right = s.length() - 1`.
2. Skip non-alphanumeric characters from both ends.
3. Convert both characters to lowercase.
4. Compare the characters.
5. If they are different, return `false`.
6. Move `left++` and `right--`.
7. Repeat until `left >= right`.
8. Return `true`.

---

## ⏱️ Time Complexity

**O(n)**

---

## 💾 Space Complexity

**O(1)**

---

## 🧠 Pattern

Two Pointers

---

## 🚀 Key Learning

- Two Pointers compare characters from both ends efficiently.
- Skip spaces and special characters using `Character.isLetterOrDigit()`.
- Use `Character.toLowerCase()` for case-insensitive comparison.
- No extra string is required, reducing space complexity to **O(1)**.

---

## 🎯 Pattern Recognition

| If the problem says... | Think... |
|-------------------------|----------|
| Compare both ends | ✅ Two Pointers |
| Ignore spaces/symbols | ✅ Skip invalid characters |
| Ignore uppercase/lowercase | ✅ Character.toLowerCase() |
| Check palindrome | ✅ Left & Right Pointers |

---

## ❓ Interview Q&A

### Q1. Why use Two Pointers?

**A:** It compares characters from both ends in a single traversal, making the solution efficient.

---

### Q2. Why use `Character.isLetterOrDigit()`?

**A:** To ignore spaces and special characters while checking the palindrome.

---

### Q3. Why use `Character.toLowerCase()`?

**A:** To ignore uppercase and lowercase differences during comparison.

---

### Q4. Why do we use `left < right` instead of `left <= right`?

**A:** When `left >= right`, all required character pairs have already been checked.

---

## 📌 Tags

`Java` `DSA` `String` `Two Pointers` `Palindrome` `LeetCode`
