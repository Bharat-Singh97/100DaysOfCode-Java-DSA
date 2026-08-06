📘 Day 14 - Valid Palindrome
📝 Problem

Check whether a string is a palindrome after ignoring non-alphanumeric characters and letter case.

💡 Approach
Use two pointers (left and right).
Skip non-alphanumeric characters.
Convert both characters to lowercase.
Compare the characters.
Move both pointers toward the center.
⚙️ Algorithm
Initialize left = 0 and right = s.length() - 1.
Skip non-alphanumeric characters from both ends.
Convert both characters to lowercase.
Compare the characters.
If they are different, return false.
Move left++ and right--.
Repeat until left >= right.
Return true.
⏱️ Time Complexity

O(n)

💾 Space Complexity

O(1)

🧠 Pattern

Two Pointers

❓ Interview Q&A

Q. Why use Two Pointers?
A. To compare characters from both ends in a single traversal.

Q. Why use Character.isLetterOrDigit()?
A. To skip spaces and special characters.

Q. Why use Character.toLowerCase()?
A. To ignore uppercase and lowercase differences.

Q. Why do we use left < right?
A. When left >= right, all required character pairs have already been checked.

🚀 Key Learning
Learned the Two Pointer pattern.
Skipped invalid characters without creating a new string.
Solved the problem in O(n) time and O(1) space.
📌 Tags

Java DSA String Two Pointers LeetCode Problem Solving
