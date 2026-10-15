class Solution {
    public int searchInsert(int[] nums, int target) {
        // Search range set
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            // Find the middle index
            int mid = left + (right -left)/2;
            // Target is found
            if(nums[mid] == target){
                return mid;
            }
            // Target belongs to the right half
            if(nums[mid] < target){
                left = mid+1;
            }
            else{
                // Target belongs to the left half
                right  = mid -1;
            }
        }
        // Left is the correct insertion position
        return left;
        
    }
}



