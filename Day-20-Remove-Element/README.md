# Day 20 - Remove Element

## 📝 Problem

Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in-place and return the number of remaining elements.

The relative order of the remaining elements does not need to be maintained.

Example:

Input: `nums = [3,2,2,3]`, `val = 3`

Output: `k = 2`, `nums = [2,2,...]`

Explanation:

The value `3` appears twice. After removing all occurrences of `3`, the first `k = 2` elements must be `[2,2]`.

---

## 💡 Approach 1: Brute Force

Used a Temporary Array.

First, create a temporary array of size `nums.length`.

Traverse the original array and store only elements that are not equal to `val`.

Finally, copy the valid elements back into the original array and return their count.

### Java Code

class Solution {
    public int removeElement(int[] nums, int val) {

        // Create a temporary array to store valid elements
        int[] temp = new int[nums.length];

        // Count of elements that are not equal to val
        int k = 0;

        // Traverse the original array
        for (int i = 0; i < nums.length; i++) {

            // Check whether the current element is valid
            if (nums[i] != val) {

                // Store the valid element in the temporary array
                temp[k] = nums[i];

                // Move to the next available position
                k++;
            }
        }

        // Copy valid elements back to the original array
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }

        // Return the count of valid elements
        return k;
    }
}

---

## ⚙️ Brute Force Algorithm

1. Create a temporary array of size `nums.length`.
2. Initialize `k = 0`.
3. Traverse the original array.
4. Check whether `nums[i] != val`.
5. If true, store `nums[i]` at `temp[k]`.
6. Increment `k`.
7. Copy the first `k` elements from `temp` to `nums`.
8. Return `k`.

---

## ⏱️ Brute Force Time Complexity

**O(n)**

The first loop traverses the array in O(n) time.

The second loop copies at most n valid elements in O(n) time.

Total: O(n) + O(n) = O(n).

---

## 💾 Brute Force Space Complexity

**O(n) auxiliary space**

The temporary array is created with size `nums.length`.

If the input array contains n elements, the temporary array allocates space for n elements.

Therefore, auxiliary space complexity is O(n).

Note: The original input array `nums` is not counted as auxiliary space.

---

## ⚡ Approach 2: Optimized

Used Two Pointers with In-Place Modification.

The `i` pointer traverses the array.

The `cnt` pointer tracks the next position for a valid element.

Whenever `nums[i] != val`, store the current element at `nums[cnt]` and increment `cnt`.

No temporary array is required.

### Java Code

class Solution {
    public int removeElement(int[] nums, int val) {

        // Count of valid elements and next available position
        int cnt = 0;

        // Traverse the entire array
        for (int i = 0; i < nums.length; i++) {

            // Process only elements that are not equal to val
            if (nums[i] != val) {

                // Place the valid element at the next available position
                nums[cnt] = nums[i];

                // Move to the next available position
                cnt++;
            }
        }

        // Return the count of valid elements
        return cnt;
    }
}

---

## ⚙️ Optimized Algorithm

1. Initialize `cnt = 0`.
2. Traverse the array using `i`.
3. Check whether `nums[i] != val`.
4. If true, store `nums[i]` at `nums[cnt]`.
5. Increment `cnt`.
6. Continue until all elements are checked.
7. Return `cnt`.

---

## ⏱️ Optimized Time Complexity

**O(n)**

The array is traversed once, so the time complexity is linear.

---

## 💾 Optimized Space Complexity

**O(1) auxiliary space**

The optimized approach does not create an additional array.

It uses only a constant number of variables, such as `i` and `cnt`.

Therefore, auxiliary space complexity is O(1).

---

## 🔍 Dry Run

Input: `nums = [3,2,2,3]`, `val = 3`

| i | nums[i] | Action | cnt |
|---|---|---|---|
| 0 | 3 | Skip | 0 |
| 1 | 2 | nums[0] = 2 | 1 |
| 2 | 2 | nums[1] = 2 | 2 |
| 3 | 3 | Skip | 2 |

Output: `k = 2`

First k elements: `[2,2]`

Note: The array length remains unchanged. Only the first k elements are considered valid.

---

## 📊 Brute Force vs Optimized

| Feature | Brute Force | Optimized |
|---|---|---|
| Technique | Temporary Array | Two Pointers |
| Time Complexity | O(n) | O(n) |
| Auxiliary Space | O(n) | O(1) |
| Extra Array | Yes | No |
| In-Place Modification | No | Yes |

The optimized approach reduces auxiliary space from O(n) to O(1) while maintaining O(n) time complexity.

---

## 🧠 Pattern

Two Pointers | In-Place Modification

---

## 🚀 Key Learning

- `i` traverses the complete array.
- `cnt` tracks the next position for a valid element.
- `nums[cnt] = nums[i]` overwrites an existing array position.
- `return cnt` gives the count of elements not equal to `val`.
- The array length does not change.
- Only the first `cnt` elements are considered valid.
- Brute force uses an extra temporary array.
- Two Pointers eliminates the need for an extra array.
- Brute force requires O(n) auxiliary space.
- The optimized approach requires O(1) auxiliary space.
- Both approaches have O(n) time complexity.

---

## 🎯 Pattern Recognition

| If the problem says...Think... | |
|---|---|
| Remove specific values | Conditional Filtering |
| Modify the original array | In-Place Modification |
| Avoid extra arrays | Two Pointers |
| Return the valid element count | Count Pointer |
| Reduce auxiliary space | In-Place Algorithm |

---

## ❓ Interview Q&A

**Q1. What is the role of `i`?**

It traverses the entire array.

**Q2. What is the role of `cnt`?**

It tracks the next position for a valid element and the total count.

**Q3. Does the array length decrease?**

No. The array length remains unchanged.

**Q4. Why is brute force space complexity O(n)?**

Because it creates a temporary array of size n.

**Q5. Why is optimized space complexity O(1)?**

Because no additional array or collection is used.

**Q6. Why do both approaches have O(n) time complexity?**

Both traverse the input array linearly. The brute force approach also copies valid elements in a second loop, which is still linear.

**Q7. What is the main advantage of the optimized approach?**

It reduces auxiliary space from O(n) to O(1).

**Q8. Does the optimized approach preserve the relative order of valid elements?**

Yes. The valid elements are copied in their original traversal order.

**Q9. Why do we return `cnt` instead of the modified array?**

The problem requires the count of valid elements. The first `cnt` positions contain the valid output.

---

## 📌 Tags

`Java` `DSA` `Array` `Two Pointers` `In-Place Algorithm` `Brute Force` `Time Complexity` `Space Complexity` `LeetCode` `Problem Solving`

---

## 🔗 Problem Link

https://leetcode.com/problems/remove-element/
