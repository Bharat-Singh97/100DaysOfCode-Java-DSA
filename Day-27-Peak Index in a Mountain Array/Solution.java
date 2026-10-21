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
