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
