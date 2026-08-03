📘 Day 13 - Valid Anagram
Problem

Given two strings s and t, return true if t is an anagram of s, otherwise return false.

An anagram is a word or phrase formed by rearranging the letters of another word, using all the original letters exactly once.

Examples

Input:

s = "anagram"
t = "nagaram"

Output:

true

Input:

s = "rat"
t = "car"

Output:

false
Approach
Check if both strings have the same length.
Create a frequency array of size 26.
Traverse both strings together.
Increment the count for characters in the first string.
Decrement the count for characters in the second string.
Check whether every value in the frequency array is 0.
If yes, return true; otherwise, return false.
Algorithm
Compare the lengths of both strings.
If lengths are different, return false.
Create an integer array count[26].
Traverse both strings simultaneously.
Increment the frequency of characters from the first string.
Decrement the frequency of characters from the second string.
Traverse the frequency array.
If any value is not 0, return false.
Otherwise, return true.
Time Complexity

O(n)

First loop → O(n)
Second loop → O(26) = O(1)

Overall:

O(n + 26) = O(n)
Space Complexity

O(1)

The frequency array size is always 26, which is constant and does not depend on the input size.

Concepts Learned
Brute Force vs Optimized: Brute force compares repeatedly (O(n²)), while the optimized approach uses a frequency array (O(n)).
When to use a Frequency Array: Use it when the input has a fixed character set (e.g., a-z).
Why int[26] is O(1): The array size is fixed (26) and does not depend on the input size.
s.charAt(i) - 'a': Converts a character into an array index ('a' → 0, 'b' → 1, ..., 'z' → 25).
Why check string lengths first: Strings with different lengths cannot be anagrams.
Why increment and decrement: Increment for the first string and decrement for the second. If all frequencies become 0, the strings are anagrams.

String | Frequency Array | Hashing

LeetCode

242. Valid Anagram
