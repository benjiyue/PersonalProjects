public class Solution {
    public int lengthOfLIS(int[] nums) {
        /*
        longest increasing subsequence. idea is that the longest possible lis is the same size as the length of the list. so our dp array is initialized as the size of the nums.length ine each index we store the minimum number needed to extend a list to that length. Then we do a bs between the left and right walls to find the lowest position we can put this if it is equal to the right wall then expand the right wall boundary. you find the rightmost element where i am not greater than the next thing
        */
        
        if(nums==null||nums.length==0)
            return 0;
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        int left = 0;
        int right = 0;
        for(int i=0;i<nums.length;i++){
            int cur = nums[i];
            int pos = bs(dp, left, right, cur);
            dp[pos] = cur;
            if(pos==right)
                right++;
        }
        return right;
    }
    public int bs(int[] dp, int left, int right, int cur){
        while(left<right){
            int mid = (left+right)/2;
            int midVal = dp[mid];
            if(cur>midVal)
                left = mid+1;
            else
                right = mid;
        }
        return right;
    }
    
}