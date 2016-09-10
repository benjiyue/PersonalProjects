public class Solution {
    public boolean isMatch(String s, String p) {
        //you need to look forward as you iterate if the next thing is a * then you match 0 then match 1 at a time if any returns a true then reyurn true,you need two pointers to keep track of lcoation
        dp = new int[s.length()+1][p.length()+1];
        return isMatch(s, 0, p, 0);
        
    }
    int[][] dp;
    public boolean isMatch(String s, int sIndex, String p, int pIndex){
        if(sIndex==s.length()&&pIndex==p.length())
            return true;
        if(dp[sIndex][pIndex]>0)
            return dp[sIndex][pIndex]==1?false:true;
            
        //match 0 times or more times
        if(pIndex+1<p.length()&&p.charAt(pIndex+1)=='*'){
            int sOrig = sIndex;
            //match 0 times
            if(isMatch(s, sIndex, p, pIndex+2))
                return true;
            //match 1... times
            while(sIndex<s.length()&&charsMatch(s, sIndex, p, pIndex)){
                sIndex++;
                if(isMatch(s, sIndex, p, pIndex+2))
                    return true;
            }
            dp[sOrig][pIndex] = 1;
            return false;
        }else{
            //match the literal
            if(charsMatch(s, sIndex, p, pIndex))
                return isMatch(s, sIndex+1, p, pIndex+1);
            dp[sIndex][pIndex]=1;
            return false;
        }
    }
    
    public boolean charsMatch(String s, int sIndex, String p, int pIndex){
        if(sIndex>=s.length()||pIndex>=p.length())
            return false;
        char c1 = s.charAt(sIndex);
        char c2 = p.charAt(pIndex);
        if(c2=='.')
            return true;
        if(c1==c2)
            return true;
        return false;
    }
}