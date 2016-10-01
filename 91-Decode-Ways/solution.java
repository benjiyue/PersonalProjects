public class Solution {
    public int numDecodings(String s) {
        if(s==null||s.length()==0)
            return 0;
        dp = new int[s.length()];
        return dfs(s, 0);
    }
    int[] dp;
    public int dfs(String s, int index){
        if(index==s.length()){
            return 1;
        }
        
        if(dp[index]>0)
            return dp[index]-1;
        
        int a=0;
        int b=0;
        int one = Integer.parseInt(s.charAt(index)+"");
        if(one>0)
            a = dfs(s, index+1);
        if(index+2<=s.length()){
            int two = Integer.parseInt(s.substring(index, index+2));
            if(two>=10&&two<=26)
                b = dfs(s, index+2);
        }
        dp[index] = a+b+1;
        return a+b;
    }
}