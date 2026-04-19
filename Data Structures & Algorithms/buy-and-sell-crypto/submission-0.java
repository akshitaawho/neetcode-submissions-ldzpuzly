class Solution {
    public int maxProfit(int[] prices) {
        int minBuyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i<prices.length; i++){
            minBuyPrice = Math.min(minBuyPrice, prices[i]);
            int sellPrice = prices[i];

            int profit = sellPrice - minBuyPrice;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}
