public class Solution {
    public void sortColors(int[] nums) {
        /*
            idea is to havea a left pointer pointing to the next position to put the 0, an iterator index and a right index pointing to the next position to put the 2, not that when we move the 0 to the left pointer we increment both the iterator and the left because we will now have a 0 in the left pointer and a 1 in the iterator position but the next position to put the next 0 will be left+1 and also since the iterator skips 1's we can skip it too sonce for sure it's a 1. But when swapping the 2 we dont actually know what we get it could be a 0,1, or 2 so we dont move the iterator only the right position since it now holds a 2 and the next position to put the 2 is right-1
        */
        
        if(nums==null||nums.length<2)
            return;
        
        int left = 0;
        int iter = 0;
        int right = nums.length-1;
        while(iter<=right){
            if(nums[iter]==0){
                int temp = nums[left];
                nums[left] = nums[iter];
                nums[iter] = temp;
                left++;iter++;
            }else if(nums[iter]==2){
                nums[iter] = nums[right];
                nums[right] = 2;
                right--;
            }else
                iter++;
        }
        
    }
}