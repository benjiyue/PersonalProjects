public class Solution {
    public int maxSubArray(int[] nums) {
        /*
        we keep track of two variables: maxever and maxTHus far including the current element. if ever the maxThusFar goes below the current element we reset the maxThusFar to the current element
        maxEver =    -2;
        maxTHusFar = -2
             i
        [-2,-1,-9]
        
        */
        
        if(nums==null||nums.length==0)
            return 0;
        
        int maxEver = nums[0];
        int maxSoFar = nums[0];
        for(int i=1;i<nums.length;i++){
            maxSoFar+=nums[i];
            if(maxSoFar<nums[i])
                maxSoFar = nums[i];
            maxEver = Math.max(maxEver, maxSoFar);
        }
        return maxEver;
    }
}