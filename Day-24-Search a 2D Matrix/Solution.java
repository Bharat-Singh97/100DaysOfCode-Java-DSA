public static boolean searchMatrix(
        int[][] matrix, int target) {

    // Find the number of rows and columns
    int rows = matrix.length;
    int cols = matrix[0].length;

    // Define the search boundaries of the virtual array
    int left = 0;
    int right = rows * cols - 1;

    // Perform binary search
    while (left <= right) {

        // Calculate the middle index safely
        int mid = left + (right - left) / 2;

        // Convert the virtual index into a matrix element
        int midValue = matrix[mid / cols][mid % cols];

        // Target found
        if (midValue == target) {
            return true;
        }

        // Search the right half
        if (midValue < target) {
            left = mid + 1;
        } else {
            // Search the left half
            right = mid - 1;
        }
    }

    // Target was not found
    return false;
}
