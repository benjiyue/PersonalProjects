public class Solution {
    public int maxSubArray(int[] nums) {
        /*Kaden's algo: start from beginning. maxEndHere, maxSoFar
        As go, if this individual number beats accumulated sum, then restart maxEndHere
        otherwise, continue maxEndHere
        At any point if beat max, repalce it
        */
        if(nums==null||nums.length==0)
            return 0;
            
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndHere = 0;
        
        for(int i=0;i<nums.length;i++){
            maxEndHere+=nums[i];
            if(nums[i]>maxEndHere)
                maxEndHere = nums[i];
            maxSoFar = Integer.max(maxSoFar, maxEndHere);
            
        }
        
        return maxSoFar;
        
    }
}