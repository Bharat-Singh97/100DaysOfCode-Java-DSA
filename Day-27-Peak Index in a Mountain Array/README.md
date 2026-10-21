
# Day 27 - Peak Index in a Mountain Array

## 📝 Problem

**LeetCode 852: Peak Index in a Mountain Array**

An array `arr` is a mountain array if:

- `arr.length >= 3`
- There exists an index `i` such that `arr[0] < arr[1] < ... < arr[i]`
- After the peak, elements strictly decrease: `arr[i] > arr[i+1] > ... > arr[arr.length-1]`

Return the index of the peak element.

### Example 1

**Input:**
```text
arr = [0, 2, 5, 3, 1]
```

**Output:**
```text
2
```

**Explanation:** The peak element is `5`, located at index `2`.

### Example 2

**Input:**
```text
arr = [0, 10, 5, 2]
```

**Output:**
```text
1
```

**Explanation:** The peak element is `10`, located at index `1`.

---

## 💡 Approach 1: Brute Force

### Idea

Traverse the array from left to right. The first index where the current element is greater than the next element is the peak index.

Because the array first increases and then decreases, this condition identifies the peak.

### Algorithm

1. Start a loop from index `0`.
2. Compare `arr[i]` with `arr[i + 1]`.
3. If `arr[i] > arr[i + 1]`, return `i`.
4. Otherwise, continue to the next index.
5. Return `-1` as a defensive fallback. A valid mountain array guarantees a peak.

### Java Code with Comments

```java
public int peakIndexInMountainArrayBruteForce(int[] arr) {

    // Traverse the array, stopping before the last index
    for (int i = 0; i < arr.length - 1; i++) {

        // The first decreasing step identifies the peak
        if (arr[i] > arr[i + 1]) {

            // Return the peak index
            return i;
        }
    }

    // Defensive fallback; valid input guarantees a peak
    return -1;
}
```

### 🔍 Dry Run

**Input:** `arr = [0, 2, 5, 3, 1]`

| Index `i` | `arr[i]` | `arr[i+1]` | Condition | Action |
|---:|---:|---:|---|---|
| 0 | 0 | 2 | `0 > 2` → false | Continue |
| 1 | 2 | 5 | `2 > 5` → false | Continue |
| 2 | 5 | 3 | `5 > 3` → true | Return `2` |

**Output:** `2`

### ⏱️ Time Complexity

**O(n)** — In the worst case, the loop may inspect every adjacent pair.

### 💾 Auxiliary Space Complexity

**O(1)** — Only the loop variable is used.

---

## 🚀 Approach 2: Optimized Binary Search

### Idea

A mountain array has two parts:

- Increasing slope before the peak.
- Decreasing slope after the peak.

Compare `arr[mid]` with `arr[mid + 1]` to determine which part contains the peak.

- If `arr[mid] < arr[mid + 1]`, we are on the increasing slope. The peak must be to the right, so set `left = mid + 1`.
- Otherwise, we are on the decreasing slope or at the peak. The peak is at `mid` or to its left, so set `right = mid`.

Repeat until `left == right`.

### Algorithm

1. Initialize `left = 0`.
2. Initialize `right = arr.length - 1`.
3. While `left < right`:
   - Calculate `mid = left + (right - left) / 2`.
   - If `arr[mid] < arr[mid + 1]`, set `left = mid + 1`.
   - Otherwise, set `right = mid`.
4. Return `left`, the peak index.

### Java Code with Comments

```java
class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        // Initialize pointers at the first and last indices
        int left = 0;
        int right = arr.length - 1;

        // Continue until both pointers meet
        while (left < right) {

            // Calculate the middle index safely
            int mid = left + (right - left) / 2;

            // If the next element is greater,
            // the peak must lie to the right of mid
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {

                // The peak may be at mid or to its left
                right = mid;
            }
        }

        // Both pointers now identify the peak index
        return left;
    }
}
```

### 🔍 Dry Run

**Input:** `arr = [0, 2, 5, 3, 1]`

| left | right | mid | `arr[mid]` | `arr[mid+1]` | Action |
|---:|---:|---:|---:|---:|---|
| 0 | 4 | 2 | 5 | 3 | `right = mid` |
| 0 | 2 | 1 | 2 | 5 | `left = mid + 1` |

Now `left = 2` and `right = 2`.

The loop stops because `left < right` is false.

**Output:** `2`

The peak element is `arr[2] = 5`.

### ⏱️ Time Complexity

**O(log n)** — The search range is approximately halved in every iteration.

### 💾 Auxiliary Space Complexity

**O(1)** — Only a constant number of variables are used.

---

## 📊 Approach Comparison

| Feature | Brute Force | Binary Search |
|---|---|---|
| Technique | Linear traversal | Binary Search |
| Time complexity | O(n) | O(log n) |
| Auxiliary space | O(1) | O(1) |
| Checks elements sequentially | Yes | No |
| Efficiency | Less efficient | More efficient |

---

## 🧠 Pattern

**Binary Search on a Mountain Array**

### Pattern Recognition

| If the problem says... | Think... |
|---|---|
| Array first increases and then decreases | Mountain Array |
| Find the peak index | Compare adjacent elements |
| `arr[mid] < arr[mid+1]` | Search right |
| `arr[mid] > arr[mid+1]` | Search left or keep `mid` |
| Search range halves each iteration | O(log n) |

---

## 🚀 Key Learning

- Brute force finds the first decreasing adjacent pair.
- Binary Search improves time complexity from O(n) to O(log n).
- If `arr[mid] < arr[mid + 1]`, update `left = mid + 1`.
- Otherwise, update `right = mid`.
- Use `while (left < right)` to avoid an infinite loop.
- Keep `mid` in the search range because it may be the peak.
- Return `left` or `right` after the pointers meet; both are equal.
- A valid mountain array guarantees that a peak exists.

---

## ❓ Interview Q&A

**Q1. What is a mountain array?**

An array that strictly increases to a peak and then strictly decreases.

**Q2. What is the brute-force approach?**

Traverse adjacent elements and return the index where `arr[i] > arr[i + 1]` for the first time.

**Q3. What is the brute-force time complexity?**

O(n), because the algorithm may inspect all adjacent pairs.

**Q4. What is the optimized time complexity?**

O(log n), because Binary Search halves the search range each iteration.

**Q5. Why compare `arr[mid]` with `arr[mid + 1]`?**

The comparison tells us whether we are on the increasing or decreasing slope.

**Q6. Why use `left = mid + 1` on an increasing slope?**

If `arr[mid] < arr[mid + 1]`, the peak must be to the right of `mid`.

**Q7. Why use `right = mid` instead of `right = mid - 1`?**

The element at `mid` may itself be the peak, so it must remain in the search range.

**Q8. Why use `while (left < right)`?**

The loop stops when both pointers meet at the peak index.

**Q9. What is the auxiliary space complexity?**

O(1), because only a constant number of variables are used.

**Q10. Is a peak guaranteed to exist in LeetCode 852?**

Yes. The problem guarantees that the input is a valid mountain array.

---

## 📌 Tags

`Java` `DSA` `Arrays` `Binary Search` `Mountain Array` `LeetCode`

---
