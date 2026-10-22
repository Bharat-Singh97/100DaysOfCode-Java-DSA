# Day 28 - Koko Eating Bananas

## 📝 Problem

LeetCode 875 - Koko Eating Bananas

Given an array of piles where piles[i] represents the number of bananas in each pile, and an integer h representing the available hours, find the minimum integer eating speed k required to finish all bananas within h hours.

Example:

Input:
piles = [3, 6, 7, 11]
h = 8

Output:
4

Explanation:
At speed k = 4:
Pile 3 requires 1 hour.
Pile 6 requires 2 hours.
Pile 7 requires 2 hours.
Pile 11 requires 3 hours.

Total hours = 1 + 2 + 2 + 3 = 8.

Therefore, the minimum eating speed is 4.

---

## 💡 Approach 1: Brute Force

### Idea

Try every possible eating speed from 1 to the maximum pile size.

For each speed, calculate the total hours required to finish all piles. Return the first speed for which totalHours <= h.

### Algorithm

1. Find the maximum pile size.
2. Check every possible speed from 1 to maxPile.
3. Calculate the hours required for each pile.
4. Add all required hours.
5. If totalHours <= h, return the current speed.

### Java Code with Comments

class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        // Find the maximum pile size
        int maxPile = piles[0];

        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > maxPile) {
                maxPile = piles[i];
            }
        }

        // Try every possible eating speed
        for (int k = 1; k <= maxPile; k++) {

            // Reset hours for every new speed
            long totalHours = 0;

            // Calculate hours required for each pile
            for (int i = 0; i < piles.length; i++) {
                int hours = (piles[i] - 1) / k + 1;
                totalHours += hours;
            }

            // Return the first valid speed
            if (totalHours <= h) {
                return k;
            }
        }

        return maxPile;
    }
}

### Dry Run

Input:
piles = [3, 6, 7, 11]
h = 8

Speed 1: Total hours = 27, Invalid
Speed 2: Total hours = 15, Invalid
Speed 3: Total hours = 10, Invalid
Speed 4: Total hours = 8, Valid

Answer = 4

### Time Complexity

O(n * m)

n = Number of piles
m = Maximum pile size

### Auxiliary Space Complexity

O(1)

---

## 🚀 Approach 2: Optimized - Binary Search on Answer

### Idea

Instead of checking every speed, use Binary Search to find the minimum valid speed.

Search range:
left = 1
right = maxPile

For every middle speed mid, calculate the total hours required.

If totalHours <= h:
The speed is valid, so search for a smaller valid speed.
right = mid

If totalHours > h:
The speed is too slow, so search higher speeds.
left = mid + 1

Continue until left == right.

### Java Code with Comments

class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        // Step 1: Find the maximum pile size
        int maxPile = piles[0];

        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > maxPile) {
                maxPile = piles[i];
            }
        }

        // Step 2: Define the search range
        int left = 1;
        int right = maxPile;

        // Step 3: Apply Binary Search
        while (left < right) {

            // Calculate the middle eating speed
            int mid = left + (right - left) / 2;

            // Use long to prevent overflow in total hours
            long totalHours = 0;

            // Calculate total hours at speed mid
            for (int i = 0; i < piles.length; i++) {

                // Ceiling division to calculate required hours
                totalHours += (piles[i] - 1) / mid + 1;
            }

            if (totalHours <= h) {

                // Speed is valid; try a smaller speed
                right = mid;

            } else {

                // Speed is too slow; increase the speed
                left = mid + 1;
            }
        }

        // The minimum valid speed
        return left;
    }
}

### Dry Run

Input:
piles = [3, 6, 7, 11]
h = 8

Iteration 1:
left = 1
right = 11
mid = 6
totalHours = 6
Action: right = mid = 6

Iteration 2:
left = 1
right = 6
mid = 3
totalHours = 10
Action: left = mid + 1 = 4

Iteration 3:
left = 4
right = 6
mid = 5
totalHours = 8
Action: right = mid = 5

Iteration 4:
left = 4
right = 5
mid = 4
totalHours = 8
Action: right = mid = 4

Now left = right = 4.

Answer = 4

### Time Complexity

O(n * log m)

n = Number of piles
m = Maximum pile size

Binary Search takes O(log m) iterations.
Each iteration processes all n piles.

### Auxiliary Space Complexity

O(1)

---

## 📊 Approach Comparison

Brute Force:
Technique: Linear search over possible speeds
Time Complexity: O(n * m)
Auxiliary Space: O(1)

Optimized:
Technique: Binary Search on Answer
Time Complexity: O(n * log m)
Auxiliary Space: O(1)

Binary Search is more efficient for large inputs.

---

## 🧠 Pattern Recognition

Pattern: Binary Search on Answer

Use this pattern when:

1. The answer lies within a known range.
2. You can check whether a candidate answer is valid.
3. The validity condition is monotonic.
4. You need the minimum valid or maximum feasible answer.

In this problem, if an eating speed is valid, every higher speed is also valid. This property allows Binary Search.

### Similar Problems

- LeetCode 1011 - Capacity To Ship Packages Within D Days
- LeetCode 1482 - Minimum Number of Days to Make m Bouquets
- LeetCode 410 - Split Array Largest Sum

---

## 🚀 Key Learning

1. Find the search range before applying Binary Search.
2. Use a feasibility check for each candidate speed.
3. If the speed is valid, use right = mid.
4. If the speed is invalid, use left = mid + 1.
5. Use ceiling division to calculate required hours.
6. Use long when total hours may exceed the int range.

### Ceiling Division

Formula:
(pile - 1) / k + 1

This calculates the hours required for a pile without using floating-point arithmetic.

---

## 🎯 Pattern Recognition

When you see a problem asking for the minimum possible speed, capacity, or time, consider Binary Search on Answer if the feasibility condition is monotonic.

---

## ❓ Interview Q&A

Q1. Why use Binary Search instead of brute force?

Answer:
Brute force checks every speed. Binary Search eliminates half of the search range in each iteration.

Q2. Why use right = mid when the speed is valid?

Answer:
Because mid itself might be the minimum valid speed, so we must keep it in the search range.

Q3. Why use left = mid + 1 when the speed is invalid?

Answer:
If the current speed is too slow, every smaller speed will also be too slow.

Q4. Why calculate mid using left + (right - left) / 2?

Answer:
It helps prevent integer overflow that could occur with (left + right) / 2.

Q5. Why is the time complexity O(n * log m)?

Answer:
Binary Search takes O(log m) iterations, and each iteration processes n piles.

Q6. Why use long for totalHours?

Answer:
The sum of required hours may exceed the maximum value of an int.

Q7. What is the monotonic property in this problem?

Answer:
If one eating speed is valid, every higher speed is also valid.

---

## 📌 Tags

Java, DSA, LeetCode, Binary Search, Binary Search on Answer, Problem Solving, 100 Days of Code

---
