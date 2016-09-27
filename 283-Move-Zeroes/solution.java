public class Solution {
    public void moveZeroes(int[] nums) {
        /*
        to minimuze swaps we should use two pointers one starting from the front and one from the end. The right pointer finds a non 0 element the left pointer finds a 0 element.  when this happens swap the values and move the pointers
        */
        if(nums==null||nums.length==0)
            return;
        
        int nextPos = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0)
                nums[nextPos++] = nums[i];
        }
        for(int i=nextPos;i<nums.length;i++)
            nums[i] = 0;
        
    }
}