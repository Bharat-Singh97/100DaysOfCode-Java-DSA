public static int searchInRotatedSortedArray(int[] arr, int target) {

    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {

        // Calculate the middle index safely
        int mid = left + (right - left) / 2;

        // Target found
        if (arr[mid] == target) {
            return mid;
        }

        // Check whether the left half is sorted
        if (arr[left] <= arr[mid]) {

            // Check whether target lies in the sorted left half
            if (arr[left] <= target && target < arr[mid]) {
                right = mid - 1;
            } else {
                // Search the right half
                left = mid + 1;
            }

        } else {

            // The right half is sorted

            // Check whether target lies in the sorted right half
            if (arr[mid] < target && target <= arr[right]) {
                left = mid + 1;
            } else {
                // Search the left half
                right = mid - 1;
            }
        }
    }

    // Target was not found
    return -1;
}
