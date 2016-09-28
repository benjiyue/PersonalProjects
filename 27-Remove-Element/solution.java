public class Solution {
    public int removeElement(int[] nums, int val) {
        //two pointers we need one for the nextposition we put into and an iterator pointers which just steps through. if the iterator pointer is not equal to the val then move it to the nextPos pointer and increment the nextPos, then return nextPos at the end
        
        if(nums==null||nums.length==0)
            return 0;
        
        int nextPos = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val)
                nums[nextPos++] = nums[i];
        }
        return nextPos;
    }
}