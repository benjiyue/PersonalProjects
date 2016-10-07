public class Solution {
    public int[] searchRange(int[] nums, int target) {
        //when cross return right for the minanchor
        
        //when cross return right pointer
        //min= return the left pointer->0
        //max= return the right pointer->5
        //                   l
        //                 r
        //                 m
        //[1,2,3,4,5,6,7,8,9] target = 9
        // 0,1,2,3,4,5,6,7,8
        
        int[] res = new int[2];
        int min = bsMin(nums, target);
        int max = bsMax(nums, target);
        if(min<0||max>=nums.length||max<0||min>=nums.length||nums[min]!=target||nums[max]!=target)
            Arrays.fill(res, -1);
        else{
            res[0] = min;
            res[1] = max;
        }
        return res;
    }
    
    public int bsMin(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]>=target)
                high = mid-1;
            else
                low = mid+1;
        }
        return low;
    }
    
    public int bsMax(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]<=target)
                low = mid+1;
            else
                high = mid-1;
        }
        return high;
    }
}