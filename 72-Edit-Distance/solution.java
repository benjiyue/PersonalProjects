public class Solution {
    /*
    Idea is at each end point ask if same if so then it's free and just recurse.
    Else if different delete from a or delete from b or replace and -1 index for both
    */
    public int minDistance(String word1, String word2) {
        if(word1.equals(word2))
            return 0;
        dp = new int[word1.length()][word2.length()];
        return minDistance(word1, word1.length()-1, word2, word2.length()-1);
    }
    int[][] dp;
    public int minDistance(String a, int aIndex, String b, int bIndex){
        if(aIndex==-1&&bIndex==-1)
            return 0;
        if(aIndex==-1||bIndex==-1)
            return aIndex==-1?bIndex+1:aIndex+1;
        
        if(dp[aIndex][bIndex]>0)
            return dp[aIndex][bIndex]-1;
        int min;
        if(a.charAt(aIndex)==b.charAt(bIndex))
            min = minDistance(a, aIndex-1, b, bIndex-1);
        else{
            min = Math.min(minDistance(a, aIndex-1, b, bIndex-1), 
                Math.min(minDistance(a, aIndex-1, b, bIndex),minDistance(a, aIndex, b, bIndex-1)))+1;
        }
        dp[aIndex][bIndex] = min+1;
        return min;
    }
}