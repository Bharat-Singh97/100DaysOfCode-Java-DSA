📘 Day 14 - Valid Palindrome (LeetCode 125)
📝 Problem

Check whether a string is a palindrome after ignoring non-alphanumeric characters and letter case.

💡 Approach
Use Two Pointers.
Skip non-alphanumeric characters.
Compare lowercase characters.
Move both pointers toward the center.
⚙️ Algorithm
Initialize left and right.
Skip invalid characters.
Convert both characters to lowercase.
Compare both characters.
If different → return false.
Move both pointers.
Return true.
⏱️ Time Complexity

O(n)

💾 Space Complexity

O(1)

🧠 Pattern

Two Pointers

❓ Interview Q&A

Q. Why Two Pointers?

Compare both ends in one traversal.

Q. Why Character.isLetterOrDigit()?

Ignore spaces and special characters.

Q. Why Character.toLowerCase()?

Ignore uppercase/lowercase differences.

Q. Why left < right?

Stop when all character pairs are checked.

🚀 Key Learning
Learned the Two Pointer pattern.
Solved the problem without extra space.
Used built-in Character methods effectively.
📌 Tags

Java DSA String Two Pointers LeetCode
