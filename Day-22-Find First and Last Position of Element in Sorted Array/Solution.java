class Solution {

    // Find the first occurrence of the target
    public int firstRange(int[] nums, int target) {

        int first = -1;                 // Store first matching index
        int left = 0;                   // Start of search range
        int right = nums.length - 1;    // End of search range

        // Continue while the search range is valid
        while (left <= right) {

            // Calculate middle index safely
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {

                first = mid;            // Save current match
                right = mid - 1;        // Search the left half

            } else if (nums[mid] < target) {

                left = mid + 1;         // Target may be on the right

            } else {

                right = mid - 1;        // Target may be on the left
            }
        }

        // Return first index, or -1 if not found
        return first;
    }

    // Find the last occurrence of the target
    public int lastRange(int[] nums, int target) {

        int last = -1;                  // Store last matching index
        int left = 0;                   // Start of search range
        int right = nums.length - 1;    // End of search range

        // Continue while the search range is valid
        while (left <= right) {

            // Calculate middle index safely
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {

                last = mid;             // Save current match
                left = mid + 1;         // Search the right half

            } else if (nums[mid] < target) {

                left = mid + 1;         // Target may be on the right

            } else {

                right = mid - 1;        // Target may be on the left
            }
        }

        // Return last index, or -1 if not found
        return last;
    }

    // Combine both searches and return the target's range
    public int[] searchRange(int[] nums, int target) {

        // Find the starting and ending indices
        return new int[] {
            firstRange(nums, target),
            lastRange(nums, target)
        };
    }
}
