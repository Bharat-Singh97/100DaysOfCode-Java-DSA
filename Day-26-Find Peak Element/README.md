
# Day 26 - Find Peak Element

## 📝 Problem

**LeetCode 162: Find Peak Element**

Given an integer array `nums`, find a peak element and return its index.

A peak element is an element that is strictly greater than its neighbors.

Assume `nums[-1] = nums[n] = -∞`. This means the first or last element can also be a peak.

You must write an algorithm that runs in `O(log n)` time.

### Example 1

**Input:**
```text
nums = [1, 2, 3, 1]
```

**Output:**
```text
2
```

**Explanation:** `nums[2] = 3` is greater than its neighbors `2` and `1`.

### Example 2

**Input:**
```text
nums = [1, 2, 1, 3, 5, 6, 4]
```

**Output:**
```text
5
```

**Explanation:** `nums[5] = 6` is greater than its neighbors `5` and `4`.

**Note:** If multiple peaks exist, returning the index of any one of them is valid.

---

## 💡 Approach 1: Brute Force

### Idea

Traverse the array from left to right and check whether each element is greater than its neighbors.

If an element is a peak, return its index immediately.

### Algorithm

1. Start a loop from index `0`.
2. Check whether the current element is greater than its left neighbor, unless it is the first element.
3. Check whether it is greater than its right neighbor, unless it is the last element.
4. If both conditions are satisfied, return the current index.
5. If no peak is found, return `-1` as a fallback.

### Java Code with Comments

```java
public static int findPeakElementBruteForce(int[] nums) {

    // Traverse every index in the array
    for (int i = 0; i < nums.length; i++) {

        // Check the left side:
        // The first element has no left neighbor
        boolean leftCondition =
                (i == 0 || nums[i] > nums[i - 1]);

        // Check the right side:
        // The last element has no right neighbor
        boolean rightCondition =
                (i == nums.length - 1 || nums[i] > nums[i + 1]);

        // If the current element is greater than both neighbors
        if (leftCondition && rightCondition) {

            // Return the index of the peak
            return i;
        }
    }

    // A peak is guaranteed to exist under the problem constraints
    return -1;
}
```

### 🔍 Dry Run

**Input:** `nums = [1, 3, 2, 4, 1]`

| Index `i` | Current | Left condition | Right condition | Result |
|---:|---:|---|---|---|
| 0 | 1 | True (boundary) | False (`1 > 3`) | Continue |
| 1 | 3 | True (`3 > 1`) | True (`3 > 2`) | Return `1` |

**Output:** `1`

The element `3` at index `1` is a peak.

The element `4` at index `3` is also a peak, but the loop returns the first peak it finds.

### ⏱️ Time Complexity

**O(n)**

In the worst case, the algorithm may inspect every element.

### 💾 Auxiliary Space Complexity

**O(1)**

Only a constant number of variables are used.

---

## 🚀 Approach 2: Optimized Binary Search

### Idea

Instead of checking every element, use Binary Search to eliminate approximately half of the search range in each iteration.

Compare `nums[mid]` with `nums[mid + 1]`.

- If `nums[mid] < nums[mid + 1]`, the array is increasing toward the right. A peak must exist on the right side, so set `left = mid + 1`.
- Otherwise, `nums[mid] > nums[mid + 1]`. A peak exists at `mid` or to its left, so set `right = mid`.

Continue until `left == right`.

### Algorithm

1. Initialize `left = 0`.
2. Initialize `right = nums.length - 1`.
3. Continue while `left < right`.
4. Calculate the middle index.
5. Compare `nums[mid]` with `nums[mid + 1]`.
6. If the middle element is smaller, move `left` to `mid + 1`.
7. Otherwise, move `right` to `mid`.
8. Return `left` when the pointers meet.

### Java Code with Comments

```java
class Solution {
    public int findPeakElement(int[] nums) {

        // Initialize pointers to the first and last indices
        int left = 0;
        int right = nums.length - 1;

        // Continue until both pointers meet
        while (left < right) {

            // Calculate the middle index safely
            int mid = left + (right - left) / 2;

            // If the next element is greater,
            // a peak must exist to the right of mid
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {

                // The peak may be at mid or to its left
                right = mid;
            }
        }

        // Both pointers now identify a peak index
        return left;
    }
}
```

### 🔍 Dry Run

**Input:** `nums = [1, 2, 3, 4, 5, 6, 4]`

| left | right | mid | nums[mid] | nums[mid+1] | Action |
|---:|---:|---:|---:|---:|---|
| 0 | 6 | 3 | 4 | 5 | `left = mid + 1` |
| 4 | 6 | 5 | 6 | 4 | `right = mid` |
| 4 | 5 | 4 | 5 | 6 | `left = mid + 1` |

Now `left = 5` and `right = 5`.

The loop terminates because `left < right` is false.

**Output:** `5`

`nums[5] = 6` is a peak because it is greater than both neighbors, `5` and `4`.

### Why Does Binary Search Work?

If `nums[mid] < nums[mid + 1]`, the sequence rises toward the right. Because the array ends at a boundary that can be a peak, a peak must occur on that side.

If `nums[mid] > nums[mid + 1]`, the sequence falls at that point. A peak must exist at `mid` or somewhere to its left.

Therefore, we can safely eliminate half of the search range in every iteration.

### ⏱️ Time Complexity

**O(log n)**

The search range is approximately halved in every iteration.

### 💾 Auxiliary Space Complexity

**O(1)**

The algorithm uses only a constant number of variables and no extra array.

---

## 📊 Approach Comparison

| Feature | Brute Force | Binary Search |
|---|---|---|
| Technique | Linear traversal | Binary Search |
| Time complexity | O(n) | O(log n) |
| Auxiliary space | O(1) | O(1) |
| Checks elements sequentially | Yes | No |
| Best use | Simple baseline | Efficient solution |

---

## 🧠 Pattern

**Binary Search on a Peak / Mountain Shape**

### Pattern Recognition

| If the problem says... | Think... |
|---|---|
| Find any peak element | Binary Search on neighboring elements |
| Array rises at `mid` | Search right |
| Array falls at `mid` | Search left or keep `mid` |
| Reduce search range by half | Binary Search |
| Return an index, not the value | Return `left` after convergence |

---

## 🚀 Key Learning

- Brute force checks each element and its neighbors.
- Binary Search improves time complexity from `O(n)` to `O(log n)`.
- If `nums[mid] < nums[mid + 1]`, update `left = mid + 1`.
- Otherwise, update `right = mid`.
- Use `while (left < right)` so the loop stops when pointers meet.
- Return `left`, because it identifies a peak index after the loop.
- Multiple peaks may exist; returning any valid peak is acceptable.
- `mid + 1` remains within bounds because the loop runs only while `left < right`.

---

## ❓ Interview Q&A

**Q1. What is a peak element?**

An element that is strictly greater than its adjacent elements.

**Q2. Can an array contain multiple peak elements?**

Yes. The algorithm only needs to return the index of one valid peak.

**Q3. What is the brute-force approach?**

Traverse the array and check whether each element is greater than its existing neighbors.

**Q4. What is the brute-force time complexity?**

O(n), because the algorithm may check every element.

**Q5. What is the optimized time complexity?**

O(log n), because Binary Search reduces the search range in each iteration.

**Q6. Why do we compare `nums[mid]` with `nums[mid + 1]`?**

The comparison tells us whether the sequence is rising or falling, helping us choose which half to search.

**Q7. Why set `left = mid + 1` when `nums[mid] < nums[mid + 1]`?**

The sequence rises toward the right, so at least one peak must exist on the right side.

**Q8. Why set `right = mid` instead of `right = mid - 1`?**

The middle element itself could be a peak, so we must keep it in the search range.

**Q9. Why use `while (left < right)`?**

The loop stops when both pointers meet at a peak index.

**Q10. Why return `left` instead of `mid`?**

`mid` is declared inside the loop and is not accessible outside it. After the loop, `left == right`, and their index identifies a peak.

**Q11. What is the auxiliary space complexity?**

O(1), because only a constant number of variables are used.

**Q12. Does the algorithm work when the array is strictly increasing?**

Yes. It moves right until it reaches the last element, which is a peak under the problem's boundary rule.

---

## 📌 Tags

`Java` `DSA` `Arrays` `Binary Search` `LeetCode` `Problem Solving`

---
