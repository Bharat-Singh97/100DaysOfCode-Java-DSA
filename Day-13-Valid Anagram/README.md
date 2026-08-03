📘 Day 13 — Valid Anagram (LeetCode 242)

Pattern: 🧠 Frequency Array | Hashing

🎯 Problem Statement

Determine whether two strings are anagrams by checking if they contain the same characters with the same frequencies.

💡 Key Idea

Instead of comparing every character repeatedly, count the frequency of each character once and compare the counts.

🚀 Approach
Length Check
      │
      ▼
Create int[26]
      │
      ▼
+1 for String s
-1 for String t
      │
      ▼
All values become 0 ?
      │
   Yes │ No
      ▼
   True   False
⚡ Complexity
Complexity	Value
⏱ Time	O(n)
💾 Space	O(1)
🧠 What I Learned
🔸 Brute Force vs Optimized
❌ Brute Force → Compare repeatedly → O(n²)
✅ Optimized → Frequency Array → O(n)
🔸 When to use a Frequency Array?

✔ When the input has a fixed character set (e.g., a-z, A-Z, 0-9).

🔸 Why is int[26] → O(1)?

Because its size is always 26, regardless of the input length.

🔸 What does s.charAt(i) - 'a' do?
'a' → 0
'b' → 1
'c' → 2
...
'z' → 25

It converts a character into its corresponding array index.

🔸 Why check the lengths first?

Different lengths ⇒ Different character counts ⇒ Not an anagram.

🔸 Why increment one string and decrement the other?
String s   → +1
String t   → -1

If every frequency becomes 0, both strings have identical character counts.

🎯 Pattern Recognition
If the problem says...	Think...
Same characters	✅ Frequency Array
Character count	✅ Hashing
Compare frequencies	✅ int[26]
Only lowercase letters	✅ Constant Space

Whenever the input contains only lowercase English letters, prefer a Frequency Array over a HashMap because it is faster and uses constant extra space.

Q1. Why use a Frequency Array instead of a HashMap?

A: Use a Frequency Array when the input has a fixed character set (e.g., a-z). It is faster and uses constant space.

Q2. Why is the space complexity O(1)?

A: Because the frequency array size is fixed (26) and does not depend on the input size.

Q3. What does s.charAt(i) - 'a' do?

A: It converts a lowercase character into its array index ('a' → 0, 'b' → 1, ..., 'z' → 25).

Q4. Why increment one string and decrement the other?

A: Matching character frequencies cancel each other. If every value becomes 0, the strings are anagrams.
