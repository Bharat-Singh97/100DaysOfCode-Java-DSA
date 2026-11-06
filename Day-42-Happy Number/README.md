## Day 42 – Happy Number (LeetCode 202)

### Problem
Given a number `n`, repeatedly calculate the sum of the squares of its digits.

If the number becomes `1`, it is a Happy Number.
If the process enters a cycle, it is not a Happy Number.

### Example
Input: `19`

Output: `true`

Explanation:
19 → 82 → 68 → 100 → 1

### Concepts Learned
- HashSet
- Digit Extraction (`% 10`)
- Digit Removal (`/ 10`)
- Sum of Squares
- Cycle Detection
- While Loop

### Java Solution
```java
import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {

            set.add(n);

            int sum = 0;

            while (n > 0) {

                int digit = n % 10;

                sum = sum + (digit * digit);

                n = n / 10;
            }

            n = sum;
        }

        return n == 1;
    }
}
```

### Complexity
- Time Complexity: O(k × d)
- Space Complexity: O(k)

Where:
- `k` = number of transformations
- `d` = number of digits processed per transformation

Completed
```
