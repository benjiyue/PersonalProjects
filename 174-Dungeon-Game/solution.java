public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null||dungeon.length==0||dungeon[0].length==0)
            return 1;
            
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int[][] dp = new int[rows][cols];
        dp[rows-1][cols-1] = 1- dungeon[rows-1][cols-1]<=0?1:1- dungeon[rows-1][cols-1];
        for(int i=cols-2;i>=0;i--)
            dp[rows-1][i] = dp[rows-1][i+1]-dungeon[rows-1][i]<=0?1:dp[rows-1][i+1]-dungeon[rows-1][i];
        for(int i=rows-2;i>=0;i--)
            dp[i][cols-1] = dp[i+1][cols-1]-dungeon[i][cols-1]<=0?1:dp[i+1][cols-1]-dungeon[i][cols-1];
        
        for(int i=rows-2;i>=0;i--){
            for(int j=cols-2;j>=0;j--){
                int possible = Math.min(dp[i+1][j], dp[i][j+1])-dungeon[i][j];
                dp[i][j] = possible<=0?1:possible;
            }
        }
        return dp[0][0];
    }
}

/*
-2	-3	3
-5	-10	1
10	30	-5

7   5   2
6   11  5
1   1   6

for each index iterate to left then go up, bootom right = 1-num[i][j]. each index look at right and look at bottom except for last row and last column 
if it's <0 then the answer is 1
dp[i][j] = min(right, bottom)-nums[i][j]

*/