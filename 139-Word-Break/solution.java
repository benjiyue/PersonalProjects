public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        /*
        idea is backtracking with memoization. we continue the build the string until we have a match in the set then we move the pointer to the next position and recurse from them building from scratch. If we reach the end then return true, else return false and the previous call continues the building else if at anytime a true is found then return true all the way back
        */
        
        if(s==null||wordDict==null||wordDict.size()==0||s.length()==0)
            return false;
        
        return dfs(s, 0, wordDict, new int[s.length()]);
    }
    
    public boolean dfs(String s, int index, Set<String> wordDict, int[] dp){
        if(index==s.length())
            return true;
        
        if(dp[index]>0)
            return false;
        
        StringBuilder building = new StringBuilder();
        for(int i=index;i<s.length();i++){
            building.append(s.charAt(i));
            if(wordDict.contains(building.toString())){
                if(dfs(s, i+1, wordDict, dp))
                    return true;
            }
        }
        dp[index] = 1;
        return false;
    }
    
}