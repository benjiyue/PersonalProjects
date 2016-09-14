public class Solution {
    public int jump(int[] nums) {
        if(nums.length<2)
            return 0;
        //idea is to jump as for as possible for your range thus far, so you always have to take the first jump then anchor the right position, the iterate for each position in the range and see where is the farthest i can get from things in this range and then iterate over things in the range from my end to the new longest range
        
        //so idea is that each time i have two anchors for where i can be.
        //inclusive
        int lowRange = 1;
        int highRange = nums[0];
        int steps = 1;
        while(highRange<nums.length-1){
            int newMax = 0;
            for(int i=lowRange;i<=highRange;i++){
                newMax = Math.max(newMax, nums[i]+i);
            }
            lowRange = highRange+1;
            highRange = newMax;
            steps++;
        }
        return steps;
    }
}