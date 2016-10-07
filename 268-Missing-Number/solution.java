public class Solution {
    public int missingNumber(int[] nums) {
        /*
        if all the numbers were actually there i would know what the sum should be, however one number is missing
        */
        
        long sum = (nums.length+1)*(nums.length)/2;
        for(int i=0;i<nums.length;i++)
            sum-=nums[i];
        
        return (int)sum;
        
    }
}