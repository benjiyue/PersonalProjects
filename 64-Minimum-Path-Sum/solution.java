public class Solution {
    public int minPathSum(int[][] grid) {
        /*
        first row is the cumulative sum
        we always set the current dp[j] j->0->m to be grid[i][j]+min(prev[j],dp[j-1])
        
        [0,1,2,3,4]
        [0,1,2,3,4]
        
        prev     [0,1,3,6,10]
        thisLevel[0,1,3,6,10]
        
        */
        if(grid.length==0||grid[0].length==0)
            return 0;
        int[] prev = new int[grid[0].length];
        prev[0] = grid[0][0];
        
        for(int i=1;i<grid[0].length;i++)
            prev[i] = grid[0][i]+prev[i-1];
        
        for(int i=1;i<grid.length;i++){
            int[] thisLevel = new int[grid[0].length];
            thisLevel[0] = prev[0]+grid[i][0];
            for(int j=1;j<grid[0].length;j++){
                thisLevel[j] = grid[i][j]+Math.min(prev[j], thisLevel[j-1]);
            }
            prev = thisLevel;
        }
        
        return prev[prev.length-1];
    }
}