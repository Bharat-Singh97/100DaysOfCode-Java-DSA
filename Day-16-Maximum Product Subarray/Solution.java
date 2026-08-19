class Solution {
    public int maxProduct(int[] nums) {
        int currentMax = nums[0];
        int currentMin = nums[0];
        int maxProduct = nums[0];

        for(int i = 1 ; i < nums.length; i++){
            int current = nums[i];
            int newMax = Math.max(current, Math.max(currentMax * current , currentMin * current));
            int newMin = Math.min(current, Math.min(currentMax * current , currentMin * current));

            currentMax = newMax;
            currentMin = newMin;
             maxProduct = Math.max(currentMax ,maxProduct);
        }
        return maxProduct;
    }
}
