class Solution {
    public int[] twoSum(int[] numbers, int target) {
       int left = 0;
       int right = numbers.length-1;

       while(left <right){
        int sum = numbers[left] + numbers[right];
        if(sum == target){
             //return 1-based indices
            return new int[]{left+1, right+1};
        }else if( sum < target){
            // move left
            left++;
        }else {
            // move right
            right--;
        }
       }
         return new int[]{-1,-1}; // for not getting target 
    }
}
