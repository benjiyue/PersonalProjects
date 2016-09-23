public class Solution {
    int[][] dp;
    int[][] directions;
    int maxEver;
    public int longestIncreasingPath(int[][] matrix) {
        //it's a dfs with memoization on places we've visited before. dp[i][j] is the longest we can go assuming cnchoring here
        if(matrix.length==0||matrix[0].length==0)
            return 0;
        maxEver = 0;
        directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                dfs(i,j, matrix);
            }
        }
        return maxEver;
    }
    
    public int dfs(int row, int col, int[][] matrix){
        
        if(dp[row][col]>0)
            return dp[row][col];
        
        int maxDistance = 1;
        for(int i=0;i<directions.length;i++){
            int nextRow = row+directions[i][0];
            int nextCol = col+directions[i][1];
            if(nextRow>=0&&nextRow<dp.length&&nextCol>=0&&nextCol<dp[0].length&&matrix[nextRow][nextCol]>matrix[row][col]){
                maxDistance = Math.max(maxDistance, dfs(nextRow, nextCol, matrix)+1);
            }
        }
        dp[row][col] = maxDistance;
        maxEver = Math.max(maxEver, maxDistance);
        return maxDistance;
    }
}