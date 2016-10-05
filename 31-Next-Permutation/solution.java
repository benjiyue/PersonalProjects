public class Solution {
    public void nextPermutation(int[] nums) {
        /*
        we want to replace the rightmost index that has a higher number on its right. 
        we iterate from the right to the left looking for the correct position if the curent value is<i-1 value then it means there is soemthing on the right that's greater. 8761432->can replace. this finds the index tthat we wanna swap. We iterate again from the right to the left looking for the index to swap with . and it is the first one that is > the index i stopped on.
            77665544
           i
              j
        8762134
        */
        
        if(nums==null||nums.length==1)
            return;
        
        int left = nums.length-2;
        while(left>=0&&nums[left]>=nums[left+1])
            left--;
        
        if(left==-1){
            Arrays.sort(nums);
            return;
        }
        
        int right = nums.length-1;
        while(right>left&&nums[right]<=nums[left])
            right--;
            
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        
        Arrays.sort(nums,left+1, nums.length);
    }
}