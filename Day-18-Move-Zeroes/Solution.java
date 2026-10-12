
class Solution {

    public void moveZeroes(int[] nums) {

        // Pointer j tracks the position for the next non-zero element
        int j = 0;

        // First pass: Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {

            // Check if the current element is non-zero
            if (nums[i] != 0) {

                // Place the non-zero element at position j
                nums[j] = nums[i];

                // Move j to the next available position
                j++;
            }
        }

        // Second pass: Fill all remaining positions with zeros
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
