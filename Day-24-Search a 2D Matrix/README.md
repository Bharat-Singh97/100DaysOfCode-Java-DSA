# Day 24 - Search a 2D Matrix

## 📝 Problem

LeetCode 74: Search a 2D Matrix

Given an m x n matrix with the following properties:

1. Each row is sorted in ascending order.
2. The first element of each row is greater than the last element of the previous row.

Return true if the target exists in the matrix; otherwise, return false.

Example 1:

Input:
matrix = [
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 60]
]
target = 3

Output: true

Example 2:

Input:
matrix = [
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 60]
]
target = 13

Output: false

---

## 💡 Approach 1: Brute Force

Traverse every row and every element.

If an element matches the target, return true.
If the entire matrix is checked without finding the target, return false.

### Java Code

public static boolean searchMatrixBruteForce(
        int[][] matrix, int target) {

    // Traverse each row
    for (int i = 0; i < matrix.length; i++) {

        // Traverse each element in the current row
        for (int j = 0; j < matrix[i].length; j++) {

            // Check whether the current element is the target
            if (matrix[i][j] == target) {
                return true;
            }
        }
    }

    // Target was not found
    return false;
}

### Time Complexity

O(m * n)

In the worst case, every element must be checked.

### Auxiliary Space Complexity

O(1)

Only a constant amount of extra space is used.

---

## 💡 Approach 2: Optimized Binary Search

The matrix can be treated as a virtual sorted 1D array because:

1. Every row is sorted.
2. Each row starts with a value greater than the previous row's last value.

We do not need to create a new array.

### Algorithm

1. Calculate the number of rows and columns.
2. Initialize left = 0.
3. Initialize right = rows * columns - 1.
4. Calculate mid using binary search.
5. Convert the virtual index into a matrix row and column.
6. If the middle value equals the target, return true.
7. If the middle value is smaller than the target, move left to mid + 1.
8. Otherwise, move right to mid - 1.
9. If the search finishes without a match, return false.

### Java Code

public static boolean searchMatrix(
        int[][] matrix, int target) {

    // Find the number of rows and columns
    int rows = matrix.length;
    int cols = matrix[0].length;

    // Define the search boundaries of the virtual array
    int left = 0;
    int right = rows * cols - 1;

    // Perform binary search
    while (left <= right) {

        // Calculate the middle index safely
        int mid = left + (right - left) / 2;

        // Convert the virtual index into a matrix element
        int midValue = matrix[mid / cols][mid % cols];

        // Target found
        if (midValue == target) {
            return true;
        }

        // Search the right half
        if (midValue < target) {
            left = mid + 1;
        } else {
            // Search the left half
            right = mid - 1;
        }
    }

    // Target was not found
    return false;
}

### Time Complexity

O(log(m * n))

The search space is reduced by approximately half in every iteration.

### Auxiliary Space Complexity

O(1)

No additional array is created. Only a constant number of variables are used.

---

## 🔍 Dry Run

Matrix:

[
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 60]
]

Target = 16

Rows = 3
Columns = 4

Initial boundaries:
left = 0
right = 3 * 4 - 1 = 11

Iteration 1:

mid = 0 + (11 - 0) / 2 = 5

Row index = 5 / 4 = 1
Column index = 5 % 4 = 1

midValue = matrix[1][1] = 11

Since 11 < 16:
left = mid + 1 = 6

Iteration 2:

left = 6
right = 11

mid = 6 + (11 - 6) / 2 = 8

Row index = 8 / 4 = 2
Column index = 8 % 4 = 0

midValue = matrix[2][0] = 23

Since 23 > 16:
right = mid - 1 = 7

Iteration 3:

left = 6
right = 7

mid = 6 + (7 - 6) / 2 = 6

Row index = 6 / 4 = 1
Column index = 6 % 4 = 2

midValue = matrix[1][2] = 16

Target found!

Output: true

---

## ⚖️ Brute Force vs Optimized

Brute Force:
- Technique: Linear Search
- Time Complexity: O(m * n)
- Auxiliary Space: O(1)

Optimized:
- Technique: Binary Search
- Time Complexity: O(log(m * n))
- Auxiliary Space: O(1)

The optimized solution searches the matrix directly without copying its elements into a separate array.

---

## 🧠 Pattern

Binary Search
2D Matrix
Virtual 1D Array
Index Mapping

---

## 🚀 Key Learning

- A properly ordered 2D matrix can be treated as a virtual sorted 1D array.
- The virtual array has rows * columns elements.
- The first virtual index is 0.
- The last virtual index is rows * columns - 1.
- Row index = mid / cols.
- Column index = mid % cols.
- Integer division in Java discards the fractional part.
- Binary search reduces the search space by half in every iteration.
- Avoid creating an extra array when direct index mapping is possible.

---

## 🎯 Pattern Recognition

If the problem says:
"Sorted array and find a target"
Think: Binary Search

If the problem says:
"Rows and columns form one continuous sorted order"
Think: Binary Search on a Virtual 1D Array

If the problem asks for O(log(m * n))
Think: Binary Search instead of scanning all elements



---

## 📚 Java 2D Array Basics — Quick Revision

Example:

int[][] matrix = {
    {1, 3, 5, 7},
    {10, 11, 16, 20},
    {23, 30, 34, 60}
};

### 1. Understand Rows and Columns

int rows = matrix.length;
int cols = matrix[0].length;

matrix.length
Meaning: Total number of rows in the matrix.
Value: 3

matrix[0].length
Meaning: Number of elements in the first row.
Value: 4

Remember:
matrix.length = How many rows?
matrix[0].length = How many columns in the first row?

### 2. Understand Matrix Indexing

Java uses zero-based indexing.

matrix[0] = First row  = [1, 3, 5, 7]
matrix[1] = Second row = [10, 11, 16, 20]
matrix[2] = Third row  = [23, 30, 34, 60]

matrix[0][0] = 1
matrix[0][2] = 5
matrix[1][2] = 16
matrix[2][0] = 23

Remember:
matrix[row][column]

First index  = Row
Second index = Column

### 3. Calculate the Last Virtual Index

int right = rows * cols - 1;

Total elements = 3 * 4 = 12
First index = 0
Last index = 12 - 1 = 11

Why subtract 1?
Because indexing starts from 0.

### 4. Convert a Virtual Index into a Matrix Index

For Binary Search on a virtual 1D array:

Row index = mid / cols
Column index = mid % cols

Java code:

int midValue = matrix[mid / cols][mid % cols];

Example:
mid = 5
cols = 4

Row = 5 / 4 = 1
Column = 5 % 4 = 1

midValue = matrix[1][1] = 11

Another example:
mid = 8
cols = 4

Row = 8 / 4 = 2
Column = 8 % 4 = 0

midValue = matrix[2][0] = 23

### 5. Quick Memory Trick

matrix.length
= Number of rows

matrix[0].length
= Number of columns in the first row

mid / cols
= Row index

mid % cols
= Column index

matrix[row][column]
= Actual matrix element


---

## ❓ Interview Q&A

Q1. Why can this matrix be treated as a sorted 1D array?

Because each row is sorted and every next row begins with a value greater than the previous row's last value.

Q2. How many elements are in the virtual array?

m * n.

Q3. How do you calculate the row index?

mid / cols.

Q4. How do you calculate the column index?

mid % cols.

Q5. What is the optimized time complexity?

O(log(m * n)).

Q6. What is the auxiliary space complexity?

O(1).

Q7. Why not create a separate 1D array?

Direct index mapping avoids unnecessary memory allocation.

Q8. What does the algorithm return if the target is absent?

false.

---

## 📌 Tags

Java, DSA, LeetCode 74, Binary Search,
2D Matrix, Index Mapping, Interview Preparation,JavaDeveloper
