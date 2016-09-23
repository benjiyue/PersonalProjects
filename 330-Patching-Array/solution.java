public class Solution {
    public int minPatches(int[] nums, int n) {
        long nextPotentiallyMissing = 1;
        int iter = 0;
        int added = 0;
        while(nextPotentiallyMissing<=n){
            if(iter<nums.length&&nums[iter]<=nextPotentiallyMissing)
                nextPotentiallyMissing+=nums[iter++];
            else{
                nextPotentiallyMissing+=nextPotentiallyMissing;
                added++;
            }
        }
        return added;
    }
}