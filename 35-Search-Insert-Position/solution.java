public class Solution {
    public int searchInsert(int[] nums, int target) {
        /*
        idea is binary search return the loe pointer
             l
           h
             m
        [1,3,5,6]
        */
        
        if(nums==null||nums.length==0)
            return 0;
        
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target)
                return mid;
            if(target>nums[mid])
                low = mid+1;
            else
                high = mid-1;
        }
        return low;
    }
}