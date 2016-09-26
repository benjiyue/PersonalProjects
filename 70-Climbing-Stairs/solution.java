public class Solution {
    public int climbStairs(int n) {
        /*
        create an int[] of size n+1
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2+1 = 3
        dp[i] = dp[i-1]+dp[i-2];
        save the last 2 dp positions
        */
        
        if(n<2)
            return 1;
        int twoBefore = 1;//0
        int oneBefore = 1;//1
        int cur;
        for(int i=2;i<=n;i++){
            cur = twoBefore+oneBefore;
            twoBefore = oneBefore;
            oneBefore = cur;
        }
        return oneBefore;
        
    }
}