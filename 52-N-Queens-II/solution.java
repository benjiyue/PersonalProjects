public class Solution {
	int count;
	boolean[] col;
	boolean[] upLeft;
	boolean[] upRight;

	public int totalNQueens(int n) {
		if(n<2)
			return n;

		col = new boolean[n];
		upLeft = new boolean[2*n];
		upRight = new boolean[2*n];
		count = 0;

		dfs(0,n, n);
		return count;
	}

	public void dfs(int row, int left, int n){
		if(left==0){
			count++;
			return;
		}
		if(row==n)
			return;

		for(int i=0;i<n;i++){
			if(col[i]||upLeft[n+row-i]||upRight[row+i])
				continue;
			col[i]=upLeft[n+row-i]=upRight[row+i]=true;
			dfs(row+1, left-1, n);
			col[i]=upLeft[n+row-i]=upRight[row+i]=false;
		}

	}
}