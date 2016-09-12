public class Solution {
	public int numberOfPatterns(int m, int n) {
		//init a map of numbers that tell you what's between them
		//so when you encounter the two number and the value has actually been visited
		//then you CAN actually go visit the unvisited hop over location
		int[][] skips = new int[10][10];
		skips[1][3] = skips[3][1] = 2;
		skips[4][6] = skips[6][4] = 5;
		skips[7][9] = skips[9][7] = 8;
		skips[1][7] = skips[7][1] = 4;
		skips[2][8] = skips[8][2] = 5;
		skips[3][9] = skips[9][3] = 6;
		skips[1][9] = skips[9][1] = skips[7][3] = skips[3][7] = 5;
		boolean[] visited = new boolean[10];

		int totalSize = 0;

		//try each size
		for(int i=m;i<=n;i++){
			totalSize+=4*dfs(i-1, 1, visited, skips);
			totalSize+=4*dfs(i-1, 2, visited, skips);
			totalSize+=dfs(i-1, 5, visited, skips);

		}
		return totalSize;
	}

	public int dfs(int sizeLeft, int curIndex, boolean[] visited, int[][] skips){
		if(curIndex>9||curIndex<=0)
			return 0;
		if(sizeLeft<0)
			return 0;
		if(sizeLeft==0)
			return 1;
		int combosFromHere = 0;
		visited[curIndex] = true;
		for(int i=1;i<=9;i++){
			//if the spot im trying to go to is not visited AND
			//either it's adjacent to me OR the place in between us is visited already 
			//then i know the middle between us is taken and thus i can jump to empty spot
			if(!visited[i]&&(skips[curIndex][i]==0||visited[skips[curIndex][i]])){
				combosFromHere+=dfs(sizeLeft-1, i, visited, skips);
			}
		}
		visited[curIndex] = false;
		return combosFromHere;
	}

}