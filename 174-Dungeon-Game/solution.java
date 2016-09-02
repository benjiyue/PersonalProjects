public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        //find a dfs path from top left to bottom right such that the minimum is highest along the path
        
        //start from bottom right and work backwards across row,
        //dp[i][j] = minimum i need here get influenced by in[i][j] and still mke it to the bottom right all while haveing>0
        //so if in[i][j] >0, then i can have less and still make it so subtrack from min(i+1, j+1);
        //if in[i][j]<0, then i have to strt with more so add to min (i+1, j+1)
        
        //if dp[i][j]<0 then 
        
        int row = dungeon.length;
        int col = dungeon[0].length;
        
        if(dungeon==null||row==0||col==0)
            return 1;
        
        int[][] dp = new int[row][col];
        //init last column
        dp[row-1][col-1] = (-1*dungeon[row-1][col-1])+1<=0?1:(-1*dungeon[row-1][col-1])+1;
        for(int i=row-2;i>=0;i--){
            int possible = (dungeon[i][col-1]*-1)+dp[i+1][col-1];
            dp[i][col-1] = possible<=0?1:possible;
        }
        //init last row
        for(int i=col-2;i>=0;i--){
            int possible = (dungeon[row-1][i]*-1)+dp[row-1][i+1];
            dp[row-1][i] = possible<=0?1:possible;
        }
        
        for(int i=row-2;i>=0;i--){
            for(int j=col-2;j>=0;j--){
                int possible = (-1*dungeon[i][j])+Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = possible<=0?1:possible;
            }
        }
        return dp[0][0];
            
   
    }
}