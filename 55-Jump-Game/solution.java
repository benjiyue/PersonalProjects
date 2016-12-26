public class Solution {
    public boolean canJump(int[] nums) {
        /*
        we keep track of the farthest index we can get to based on the things we've seen then we keep going one by one while the index is less than the maxPos, it we reach maxPos and are not able to go any more then return false by breaking else if any jump can lead me to go beyond the last index return true
        
        max = 3
        3
        
        */
        if(nums==null||nums.length==0)
            return true;
            
        int maxPos = nums[0];
        for(int i=1;i<=maxPos&&i<nums.length;i++){
            maxPos = Math.max(maxPos, i+nums[i]);
            if(maxPos>=nums.length-1)
                return true;
        }
        return maxPos>=nums.length-1;
        
    }
}//IM EDITING VIA THE FIRSTBRANCH
