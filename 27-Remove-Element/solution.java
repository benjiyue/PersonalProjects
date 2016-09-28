public class Solution {
    public int removeElement(int[] nums, int val) {
        //two pointers we need one for the nextposition we put into and an iterator pointers which just steps through. if the iterator pointer is not equal to the val then move it to the nextPos pointer and increment the nextPos, then return nextPos at the end
        
        if(nums==null||nums.length==0)
            return 0;
        /*
        val=3
           l
           h
        [2,2,2,3]
        */
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            while(low<=high&&nums[low]!=val)
                low++;
            while(low<=high&&nums[high]==val)
                high--;
            if(low<=high){
                nums[low] = nums[high];
                low++;
                high--;
            }
        }
        return low;
    }
}