public class Solution {
    public int search(int[] nums, int target) {
        //we know one side is sorted. if the target is within thay range we bs into that range, else bs in to other side
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target)
                return mid;
            //left sorted
            if(nums[left]<=nums[mid]){
                if(target>=nums[left]&&target<=nums[mid])
                    right = mid-1;
                else
                    left = mid+1;
            }
            //right sorted
            else{
                if(target>=nums[mid]&&target<=nums[right])
                    left = mid+1;
                else
                    right = mid-1;
            }
            
        }
        return -1;
    }
    //l
    //r
    //  m
    //5,1,3
    //look for 5
}