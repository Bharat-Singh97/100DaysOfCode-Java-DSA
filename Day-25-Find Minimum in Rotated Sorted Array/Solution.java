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
    return nums[left]; // or nums[right]
}
