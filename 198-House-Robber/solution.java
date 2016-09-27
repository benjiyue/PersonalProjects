public class Solution {
    public int rob(int[] nums) {
        /*
        the idea is dp we save what is the best for the current step give the best from 1 and 2 steps ago. the max of current is betweencurrent.val+2ago or 2ago. then assign 1ago to 2 ago and the curretn best to 1 ago then continue; finally return 1 ago
        1ago = 10,14
        2ago = 9,10
               i
        9,10,5,100,99
        dp[i] is the est i can get up to index i
        */
        if(nums==null||nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0], nums[1]);
        
        int twoAgo = nums[0];
        int oneAgo = nums[1];
        for(int i=2;i<nums.length;i++){
            int chooseCur = Math.max(twoAgo+nums[i], oneAgo);
            twoAgo = Math.max(twoAgo, oneAgo);
            oneAgo = chooseCur;
        }
        return oneAgo;
    }
}