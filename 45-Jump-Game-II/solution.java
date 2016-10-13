public class Solution {
    public int jump(int[] nums) {
        /*
        bfs idea you first start at the 0th index and you can jump nums[0] steps so that's the farthest you can go, then iterate up one at a time up to that maxLength and see if anything along the way i+nums[i] can jump even farther than where you initially could jump to if so continue the while loop else you cannot jump farther and you're stuck so return 
        */
        if(nums.length==1)
            return 0;
        int iter = 1;
        int curMax = nums[0];
        int steps = 1;
        while(true){
            if(curMax>=nums.length-1)
                return steps;
            int nextMax = curMax;
            while(iter<=curMax){
                nextMax = Math.max(nextMax, iter+nums[iter]);
                iter++;
            }
            curMax = nextMax;
            steps++;
        }
    }
}