public class Solution {
    public int maxProfit(int prices[]) {
        int K = 2;
        if (K == 0 || prices.length == 0) {
            return 0;
        }
        int T[][] = new int[K+1][prices.length];

        for (int i = 1; i < T.length; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < T[0].length; j++) {
                T[i][j] = Math.max(T[i][j-1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, T[i-1][j] - prices[j]);
            }
        }
        return T[K][prices.length-1];
    }
}