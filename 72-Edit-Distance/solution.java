public class Solution {
    public int minDistance(String word1, String word2) {
        /*
        dp question: we create a 2d int array with rows of word1 length and cols of word2 length  then we look at the end of both words: if they're the same then i can get rid of both for free so just take i-1,j-1 else i have to try to get rid of each i-1,j and i, j-1. and return the min. top down
        */
        
        if(word1==null||word2==null)
            return 0;
        
        int[][] dp = new int[word1.length()][word2.length()];
        return minEdit(word1, word1.length()-1, word2, word2.length()-1, dp);
    }
    
    
    public int minEdit(String a, int aIndex, String b, int bIndex, int[][] dp){
        if(aIndex==-1)
            return bIndex+1;
        if(bIndex==-1)
            return aIndex+1;
        
        if(dp[aIndex][bIndex]>0)
            return dp[aIndex][bIndex]-1;
        
        int res;
        if(a.charAt(aIndex)==b.charAt(bIndex)){
            res = minEdit(a, aIndex-1, b, bIndex-1, dp);
        }else{
            res = Math.min(minEdit(a, aIndex, b, bIndex-1, dp),
            Math.min(minEdit(a, aIndex-1, b, bIndex, dp), minEdit(a, aIndex-1, b, bIndex-1, dp)))+1;
        }
        dp[aIndex][bIndex] = res+1;
        return res;
    }
}