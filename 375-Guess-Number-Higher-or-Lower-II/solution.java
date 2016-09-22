public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        return getMoney(1, n, dp);
    }
    
    public int getMoney(int low, int high, int[][] dp){
        if(low>=high)
            return 0;
            
        if(dp[low][high]!=0)
            return dp[low][high];
            
        int thisMin = Integer.MAX_VALUE;
        for(int i=low;i<=high;i++){
            int left = getMoney(low, i-1, dp);
            int right = getMoney(i+1, high, dp);
            int max = Math.max(left, right);
            thisMin = Math.min(thisMin, max+i);
        }
        dp[low][high] = thisMin;
        return thisMin;
    }
    
}