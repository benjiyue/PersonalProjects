public class Solution {
    public void rotate(int[] nums, int k) {
        //reverse the whole thing, then reverse [0,k) then [k, n]
        /*
         
        [5,6,7,1,2,3,4]
         0,1,2,3,4,5,6
        */
        
        k%=nums.length;
        if(k==0)
            return;
        reverse(nums, 0, nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k, nums.length-1);
    }
    
    public void reverse(int[] nums, int left, int right){
        for(int i=0;i<=(right-left)/2;i++){
            int temp = nums[right-i];
            nums[right-i] = nums[left+i];
            nums[left+i] = temp;
        }
    }
}