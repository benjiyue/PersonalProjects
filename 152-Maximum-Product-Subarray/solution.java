public class Solution {
    public int maxProduct(int[] nums) {
        /*
        maxEver  = 6
        maxSoFar = 
        //keep track of 
        highest = 6
        min = -4
        max = 48*9
        [2,3,-2,4,-9]
        */
        
        if(nums==null||nums.length==0)
            return 0;
        
        int maxEver = nums[0];
        int min = nums[0];
        int max = nums[0];
        
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                int temp = min;
                min = max;
                max = temp;
            }
            max = Math.max(nums[i], max*nums[i]);
            min = Math.min(nums[i], min*nums[i]);
            maxEver = Math.max(maxEver, max);
        }
        return maxEver;
    }
}