
class Solution {
    public int removeDuplicates(int[] nums) {
        // Handle an empty array
        if (nums.length == 0) {
            return 0;
        }

        // i tracks the last unique element's position
        int i = 0;

        // j scans the array from the second element
        for (int j = 1; j < nums.length; j++) {

            // Found a new unique element
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        // Number of unique elements
        return i + 1;
    }
}
