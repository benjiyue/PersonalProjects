public class Solution {
    public void nextPermutation(int[] nums) {
        //idea is to iterate from right to left looking for the first time the number decreases once thats found then we know for sure that at worst this would be the position we swap with, so the fact that we stop as soon as we find the higher number mean that this is the best place to make the number a higher number. And we also have something ti swap it with, then iterate again starting from the right side and swap it with the first number that's higher than where you ended. Why does this work? Well we know that basically the entire right side was icnreasing up until the point we decreased because we stopped as soon as it decreased therefore it follows that everything to the right is necessairily increasing until we get to the point. So that's why because the first number that's higher must be the lowest number thats greater since anything ever larger will even be greater than this so just stop now to swap. 
        
        //otherwise you never coud find something to swap so just sort the array.
        /*
        s
          r
        2311
        
        */
        
        if(nums==null||nums.length<2)
            return;
        
        int swapIndex;
        for(swapIndex = nums.length-2;swapIndex>=0;swapIndex--){
            if(nums[swapIndex]<nums[swapIndex+1])
                break;
        }
        if(swapIndex==-1){
            Arrays.sort(nums);
        }else{
            int right = nums.length-1;
            while(nums[right]<=nums[swapIndex])
                right--;
            int temp = nums[swapIndex];
            nums[swapIndex] = nums[right];
            nums[right] = temp;
            Arrays.sort(nums, swapIndex+1, nums.length);
        }
    }
}