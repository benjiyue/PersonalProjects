public class Solution {
    public int maxProfit(int[] prices) {
        /*
        maximum profit can be had when we buy at the lowest and sell at the highest, we can always keep track of the lowest we've ever seen up to a certain index, and the profit we could make by selling now. So we iterate keeptrack of min so far and reuturn the max by doing a MAth.max of every index substracting the loweset value
        */
        
        if(prices==null||prices.length<2)
            return 0;
        
        int maxProfit = 0;
        int lowestEver = Integer.MAX_VALUE;
        
        for(int i=0;i<prices.length;i++){
            if(prices[i]<lowestEver)
                lowestEver = prices[i];
            maxProfit = Math.max(maxProfit, prices[i]-lowestEver);
        }
        return maxProfit;
        /*
        maxProfit = 5;
        lowestEver = 0
               i
        5,4,9,0
        
        */
    }
}