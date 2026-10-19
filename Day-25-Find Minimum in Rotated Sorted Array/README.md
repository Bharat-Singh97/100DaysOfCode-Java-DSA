
# Day 25 - Find Minimum in Rotated Sorted Array

## 📝 Problem

**LeetCode 153: Find Minimum in Rotated Sorted Array**

Given an array of unique elements that was originally sorted in ascending order and then rotated between `1` and `n` times, return the minimum element of this array.

You must write an algorithm that runs in `O(log n)` time.

### Example 1

**Input:**
```text
nums = [3, 4, 5, 1, 2]
```

**Output:**
```text
1
```

**Explanation:** The original sorted array was `[1, 2, 3, 4, 5]`. The minimum element is `1`.

### Example 2

**Input:**
```text
nums = [4, 5, 6, 7, 0, 1, 2]
```

**Output:**
```text
0
```

### Example 3

**Input:**
```text
nums = [11, 13, 15, 17]
```

**Output:**
```text
11
```

---

## 💡 Approach 1: Brute Force

### Idea

Traverse the entire array and maintain the smallest element found so far.

### Algorithm

1. Assume the first element is the minimum.
2. Traverse the remaining elements.
3. Compare each element with the current minimum.
4. If the current element is smaller, update the minimum.
5. Return the minimum element.

### Java Code

```java
public static int minElementBruteForce(int[] nums) {
    // Assume the first element is the minimum
    int min = nums[0];

    // Traverse the remaining elements
    for (int i = 1; i < nums.length; i++) {

        // Check if the current element is smaller
        if (nums[i] < min) {

            // Update the minimum element
            min = nums[i];
        }
    }

    // Return the smallest element found
    return min;
}
```

### Dry Run

**Input:** `nums = [4, 5, 6, 7, 0, 1, 2]`

| Index | Current Element | Minimum So Far |
|---:|---:|---:|
| 0 | 4 | 4 |
| 1 | 5 | 4 |
| 2 | 6 | 4 |
| 3 | 7 | 4 |
| 4 | 0 | 0 |
| 5 | 1 | 0 |
| 6 | 2 | 0 |

**Output:** `0`

### ⏱️ Time Complexity

**O(n)** — In the worst case, every element must be checked.

### 💾 Auxiliary Space Complexity

**O(1)** — Only one variable is used to store the minimum.

---

## 🚀 Approach 2: Optimized Binary Search

### Idea

The array was originally sorted, so we can use Binary Search to reduce the search range in every iteration.

Compare `nums[mid]` with `nums[right]`:

- If `nums[mid] > nums[right]`, the minimum lies strictly to the right of `mid`.
- Otherwise, the minimum lies at `mid` or to its left.

### Algorithm

1. Initialize `left = 0`.
2. Initialize `right = nums.length - 1`.
3. Run the loop while `left < right`.
4. Calculate the middle index.
5. If `nums[mid] > nums[right]`, update `left = mid + 1`.
6. Otherwise, update `right = mid`.
7. When both pointers meet, return `nums[left]`.

### Java Code

```java
public static int minElement(int[] nums) {
    // Initialize pointers at the first and last indices
    int left = 0;
    int right = nums.length - 1;

    // Continue until both pointers meet
    while (left < right) {

        // Calculate the middle index safely
        int mid = left + (right - left) / 2;

        // The minimum lies strictly to the right of mid
        if (nums[mid] > nums[right]) {
            left = mid + 1;
        } else {
            // The minimum may be mid itself or to its left
            right = mid;
        }
    }

    // Both pointers point to the minimum element
    return nums[left];
}
```

**Note:** Both implementations assume that the input array is non-empty, as guaranteed by the problem constraints.

### 🔍 Dry Run

**Input:** `nums = [4, 5, 6, 7, 0, 1, 2]`

| left | right | mid | nums[mid] | nums[right] | Action |
|---:|---:|---:|---:|---:|---|
| 0 | 6 | 3 | 7 | 2 | `left = mid + 1` |
| 4 | 6 | 5 | 1 | 2 | `right = mid` |
| 4 | 5 | 4 | 0 | 1 | `right = mid` |

Now `left = 4` and `right = 4`.

The loop terminates because `left < right` is false.

**Output:** `nums[4] = 0`

### ⏱️ Time Complexity

**O(log n)** — The search range is approximately halved in each iteration.

### 💾 Auxiliary Space Complexity

**O(1)** — Only a constant number of variables are used.

---

## 📊 Approach Comparison

| Feature | Brute Force | Binary Search |
|---|---|---|
| Technique | Linear Traversal | Modified Binary Search |
| Time Complexity | O(n) | O(log n) |
| Auxiliary Space | O(1) | O(1) |
| Checks Every Element | Yes, in the worst case | No |
| Efficiency | Less efficient | More efficient |

---

## 🧠 Pattern

**Modified Binary Search on a Rotated Sorted Array**

### Why This Pattern Works

The comparison between `nums[mid]` and `nums[right]` tells us which part of the search range can contain the minimum.

- `nums[mid] > nums[right]`: eliminate the left portion through `mid`.
- `nums[mid] <= nums[right]`: keep `mid` and eliminate the portion to its right.

Keeping `mid` in the second case is important because `mid` itself may be the minimum.

---

## 🚀 Key Learning

- Start with the brute-force approach to understand the problem.
- Use Binary Search to improve the time complexity from `O(n)` to `O(log n)`.
- Use `left = mid + 1` when the minimum is strictly to the right.
- Use `right = mid` when `mid` could be the minimum.
- Use `while (left < right)` to stop when both pointers meet.
- Return `nums[left]` after the loop.
- The algorithm also works when the array is already sorted and not rotated.

---

## 🎯 Pattern Recognition

| If the problem says... | Think... |
|---|---|
| Find the minimum by checking all elements | Linear Traversal |
| Sorted array | Binary Search may apply |
| Rotated sorted array | Modified Binary Search |
| Find the minimum in a rotated array | Compare `nums[mid]` with `nums[right]` |
| Reduce the search range by half | O(log n) time |

---

## ❓ Interview Q&A

**Q1. What is the brute-force approach?**

Traverse every element and maintain the minimum found so far.

**Q2. What is the brute-force time complexity?**

O(n), because every element may need to be checked.

**Q3. Why use Binary Search?**

It reduces the search range by approximately half in every iteration, achieving O(log n) time.

**Q4. Why compare `nums[mid]` with `nums[right]`?**

This comparison helps determine which part of the rotated array contains the minimum.

**Q5. Why use `right = mid` instead of `right = mid - 1`?**

The middle element may itself be the minimum, so it must remain in the search range.

**Q6. Why use `while (left < right)`?**

The loop terminates when both pointers meet at the minimum element's index.

**Q7. What is the optimized time complexity?**

O(log n).

**Q8. What is the auxiliary space complexity?**

O(1), because only a constant number of variables are used.

**Q9. Does this algorithm work for an unrotated sorted array?**

Yes. It returns the first element, which is the minimum.

**Q10. Why calculate `mid` as `left + (right - left) / 2`?**

This avoids the potential integer overflow associated with `(left + right) / 2` for sufficiently large indices.

---

## 📌 Tags

`Java` `DSA` `Arrays` `Binary Search` `LeetCode` `Problem Solving`

---
