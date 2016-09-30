public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //use a rolling set. we push into the set automatically until size k then from then on we first ask if the thing is in the set else we pop the kth to left and push in current
        
        /*
        [4,4,2,5,4]
        set:4,2,5
        when index>=size ask if current thing is in the set if so return true else pop off i-k and push current
        */
        if(nums==null||nums.length==0)
            return false;
        if(k==0)
            return false;
            
        Set<Integer> set = new HashSet();
        for(int i=0;i<nums.length;i++){
            if(i>k)
                set.remove(nums[i-k-1]);
            
            if(set.contains(nums[i]))
                    return true;

            set.add(nums[i]);
        }
        return false;
    }
}