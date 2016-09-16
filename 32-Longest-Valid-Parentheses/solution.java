public class Solution {
    public int longestValidParentheses(String s) {
        /*we can use dp where each index represents in dp represents the longest valid sequence that ends at index i.
        so for it to end on i, we need the ith char to be ), else it's 0
        if it is ), then ask what it is going to be paired with:
            if the thing immediately to the left i-1 is a ( then dp[i] is simply dp[i-2]+2, because we match the ) with the i-1 ( which gives two more chars and then we match with the longest ending at i-2
            else if the i-1 beore is not a ( then that means it's a ) so we have )), well then we ned to know the longest formed using the  left ) and get the start ( position if it exists, and that's i-1-dp[i-1]. and if position   i-1-dp[i-1] -1 has a ( then i can mtch it with the ith )
        
        */
        if(s.length()<2)
            return 0;
        
        int[] dp = new int[s.length()];
        int max = 0;
        for(int i=1;i<s.length();i++){
            char c = s.charAt(i);
            if(c==')'){
                if(s.charAt(i-1)=='('){
                    dp[i] = i-2>=0?dp[i-2]+2:2;
                }else{
                    //i-1 is a ')'
                    if(i-1-dp[i-1]>=0&&s.charAt(i-1-dp[i-1])=='('){
                        dp[i] = i-2-dp[i-1]>=0?dp[i-1]+2+dp[i-2-dp[i-1]]:dp[i-1]+2;
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}