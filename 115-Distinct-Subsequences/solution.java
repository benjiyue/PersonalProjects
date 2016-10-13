public class Solution {
	public int numDistinct(String s, String t) {
		/*
        idea is dp.
        dp[i][j] = how many times does S(0,i] match into T(0,j]
        the rows rep the string t and the cols rep the string s the size is +1 of the string size to acount for 
        the empty string. empty string matches rything once: first row=0, for col = 0 except for 0th index

        general case dp[i][j]
            if the characters match then it's dp[i-1][j-1]+dp[i-1][j] because you can extend whatever combos you had in
            i-1,j-1 AND on top of that you also get what you've matched with the new charcter at the current row

            if they dont match then it's only dp[i-1][j] because you cannot extend what you had in i-1,j-1 because the character dont ,atch you you'd be breaking everything. but you do get to keep whatever you've matched with this character
		 */

		int[][] dp = new int[t.length()+1][s.length()+1];
		Arrays.fill(dp[0], 1);
		for(int i=1;i<dp.length;i++){
			for(int j=1;j<dp[0].length;j++){
				if(s.charAt(j-1)==t.charAt(i-1)){
					dp[i][j] = dp[i-1][j-1]+dp[i][j-1];
				}else
					dp[i][j] = dp[i][j-1];
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}
}