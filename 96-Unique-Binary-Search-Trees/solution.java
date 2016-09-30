public class Solution {
    public int numTrees(int n) {
        /*
        dp solution we build up with 
        0->1
        1->1
        2->2 = 1+1
        3->2 = 2*1+1*1+1*2 = 5
        */
        if(n<=1)
            return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
            
        for(int i=3;i<=n;i++){
            int sum = 0;
            for(int a=0;a<i;a++){
                sum+=dp[0+a]*dp[i-1-a];
            }
            dp[i] = sum;
            //if i is odd then add the i/2 dp after you multiply by 2
        }
        return dp[n];
    }
}