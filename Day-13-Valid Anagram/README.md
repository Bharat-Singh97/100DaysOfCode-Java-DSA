# Day 13 - Valid Anagram

## 📝 Problem

Determine whether two strings are anagrams by checking if they contain the same characters with the same frequencies.

---

## 💡 Approach

- Check if both strings have the same length.
- Create a Frequency Array `int[26]`.
- Increment the count for characters in the first string.
- Decrement the count for characters in the second string.
- If every frequency becomes `0`, the strings are anagrams.

---

## ⚙️ Algorithm

1. Compare the lengths of both strings.
2. If lengths are different, return `false`.
3. Create `int[] count = new int[26]`.
4. Increment the frequency for the first string.
5. Decrement the frequency for the second string.
6. Check every value in the frequency array.
7. If any value is not `0`, return `false`.
8. Otherwise, return `true`.

---

## ⏱️ Time Complexity

**O(n)**

---

## 💾 Space Complexity

**O(1)**

---

## 🧠 Pattern

Frequency Array | Hashing

---

## 🚀 Key Learning

- Frequency Array is faster than HashMap for lowercase letters.
- `int[26]` uses constant space.
- `s.charAt(i) - 'a'` maps characters to array indices.
- Increment one string and decrement the other to compare frequencies efficiently.

---

## 🎯 Pattern Recognition

| If the problem says... | Think... |
|-------------------------|----------|
| Same characters | ✅ Frequency Array |
| Character count | ✅ Hashing |
| Compare frequencies | ✅ int[26] |
| Only lowercase letters | ✅ Constant Space |

---

## ❓ Interview Q&A

### Q1. Why use a Frequency Array instead of a HashMap?

**A:** A Frequency Array is faster and uses constant space when the input has a fixed character set (e.g., `a-z`).

---

### Q2. Why is the space complexity O(1)?

**A:** Because the frequency array size is fixed (`26`) and does not depend on the input size.

---

### Q3. What does `s.charAt(i) - 'a'` do?

**A:** It converts a lowercase character into its corresponding array index (`'a' → 0`, `'b' → 1`, ..., `'z' → 25`).

---

### Q4. Why increment one string and decrement the other?

**A:** Matching character frequencies cancel each other. If every value becomes `0`, both strings are anagrams.

---

## 📌 Tags

`Java` `DSA` `String` `Hashing` `Frequency Array` `LeetCode`
