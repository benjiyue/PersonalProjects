public class Solution {
    public int findPeakElement(int[] nums) {
        /*
        
        we will not have a solution if the entire thing is strictly increasing or strictly decreasing
        12345
        54321
        
        ifnums[m]<nums[m+1] then at worst everything will be increasing to the right and the r will be the final answer go right
        elsenums[m]>nums[m+1] then at worst everything will be increasing to the left and the l will be the final answer go left
         l
             r
           m
        [3,2,1]
         0,1,2,3,4,5,6,7
        */
        
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = (left+right)/2;
            int l = mid-1<0?Integer.MIN_VALUE:nums[mid-1];
            int r = mid+1>=nums.length?Integer.MIN_VALUE:nums[mid+1];
            if(nums[mid]>l&&nums[mid]>r)
                return mid;
            
            //if the midVal<the right val then at some time the values started decreasing as it increases to the right
            if(nums[mid]<nums[mid+1])
                left = mid+1;
            //if the midVal<the left then at some time it stop increasing when going to the left
            else
                right = mid-1;
            
        }
        return left;
    }
}