class Solution {
    public int removeElement(int[] nums, int val) {
        // Count of elements that are not equal to value
        int cnt = 0;
        // Traverse the entire array
        for(int i = 0; i < nums.length; i++){
            //Check whether the current element is valid
            if(nums[i] != val){
                // place the valid element at the next available position 
                nums[cnt] = nums[i];
                //Move to the next position
                cnt++;
            }
        }
        // Return the count of valid elements
        return cnt;
    }
}
