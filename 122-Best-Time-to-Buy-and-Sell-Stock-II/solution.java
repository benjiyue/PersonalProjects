public class Solution {
    public int maxProfit(int[] prices) {
        /*
        [3,4,5,1,5,2,9,9,9,7] basically you want to be a part of all possible transactions, so look at consequetive things and if it increases do that buy and sell
        */
        
        if(prices==null||prices.length<2)
            return 0;
        
        int max = 0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i]<prices[i+1])
                max+=prices[i+1]-prices[i];
        }
        return max;
        
    }
}