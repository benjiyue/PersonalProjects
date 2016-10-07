public class Solution {
    public boolean isMatch(String s, String p) {
        dp = new boolean[s.length()+1][p.length()+1];
        return dfs(s, 0, p, 0);
    }
    
    boolean[][] dp;
    
    public boolean dfs(String s, int sIndex, String p, int pIndex){
        if(sIndex==s.length()&&pIndex==p.length()){
            return true;
        }
        if(pIndex>=p.length())
            return false;
            
        if(dp[sIndex][pIndex])
            return false;
            
        int sOrig = sIndex;
        char pChar = p.charAt(pIndex);
        if(pChar=='*'){
            if(dfs(s, sIndex++, p, pIndex+1))
                return true;
            while(sIndex<=s.length()){
                if(dfs(s, sIndex++, p, pIndex+1))
                    return true;
            }
            dp[sOrig][pIndex] = true;
            return false;
        }else{
            if(pIndex>=p.length()||sIndex>=s.length())
                return false;
            if(pChar=='?'||s.charAt(sIndex)==pChar){
                if(dfs(s, sIndex+1, p, pIndex+1))
                    return true;
            }
            dp[sIndex][pIndex] = true;
            return false;
            
        }
        
    }
}