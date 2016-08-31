public class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for(int i=0;i<nums.length;i++){
            if(farthest>=nums.length-1)
                return true;
            if(farthest>=i){
                farthest = Math.max(farthest,i+nums[i]);
            }else
                return false;
        }
        return true;
    }
}