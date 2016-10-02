public class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
        the idea is that we multiply the numbers to the right of te number then multiply by the number to the left od the number by accumulatinf the product
         
        [1,2,3,4]
        product=24
        [24,12,8,6]
        */
        
        if(nums==null||nums.length<2)
            return nums;
        
        int[] res = new int[nums.length];
        int product = 1;
        for(int i=0;i<nums.length;i++){
            res[i] = product;
            product*=nums[i];
        }
        product = 1;
        for(int i=nums.length-1;i>=0;i--){
            res[i]*=product;
            product *= nums[i];
        }
        return res;
    }
}