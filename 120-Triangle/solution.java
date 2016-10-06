public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        /*
        we do a dfs with memoization. we set our anchor and then recurse to the nxt legvel down and there we can schoose i or i+1, then explore both. when we return we save the best choice for this depth this idnex and memoize before we return
        */
        int[][] dp = new int[triangle.size()][triangle.size()+1];
        //fill up the last level
        for(int i=0;i<triangle.get(triangle.size()-1).size();i++){
            dp[triangle.size()-1][i] = triangle.get(triangle.size()-1).get(i);
        }
        //iterate for ecah row backwards
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[i][j] = triangle.get(i).get(j)+Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        return dp[0][0];

    }
}