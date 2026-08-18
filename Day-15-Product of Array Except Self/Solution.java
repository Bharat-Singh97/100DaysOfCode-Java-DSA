class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] product = new int[nums.length];

        int leftProduct = 1;
        for(int i = 0; i < nums.length; i++){
            product[i]= leftProduct;
            leftProduct = leftProduct * nums[i];
        }
        int rightProduct = 1;
        for(int i = nums.length-1; i >= 0; i--){
            product[i] = product[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }
        return product;
    }
}
