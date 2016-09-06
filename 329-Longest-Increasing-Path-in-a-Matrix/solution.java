public class Solution {
	public int longestIncreasingPath(int[][] matrix) {
		if(matrix.length==0||matrix[0].length==0)
			return 0;
		int[][] dp =  new int[matrix.length][matrix[0].length];
		maxEver = 1;
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(dp[i][j]==0)
					dfs(matrix, dp, i, j);
			}
		}
		return maxEver;
	}
	int maxEver;
	int[][] directions = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
	public int dfs(int[][] matrix, int[][] dp, int i, int j){
		if(i<0||i>=matrix.length||j<0||j>=matrix[0].length)
			return 0;
		if(dp[i][j]!=0)
			return dp[i][j];
		int max = 1;
		for(int a = 0;a<directions.length;a++){
			int row = i+directions[a][0];
			int col = j+directions[a][1];
			if(row>=0&&row<matrix.length&&col>=0&&col<matrix[0].length&&matrix[row][col]>matrix[i][j])
				max = Math.max(dfs(matrix, dp, row, col)+1, max);
		}
		dp[i][j] = max;
		maxEver = Math.max(maxEver, max);
		return max;
	}
}