public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null||nums.length<3)
            return Integer.MAX_VALUE;
        
        Arrays.sort(nums);
        /*
             i
                 l
                 r
        {-4,-1,1,2} target =1 
        closest = 2
        minDiff = 1
        */
        int minDiff = Integer.MAX_VALUE;
        int closest = -3;
        
        for(int i=0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(Math.abs(sum-target)<minDiff){
                    if(sum==target)
                        return target;
                    closest = nums[i]+nums[left]+nums[right];
                    minDiff = Math.abs(sum-target);
                }
                
                if(sum<target)
                    left++;
                else
                    right--;
            }
            
        }
        return closest;
    }
}