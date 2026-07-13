class Solution {
    public int maxProfit(int[] prices) {
        int minBuyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i<prices.length; i++){
            minBuyPrice = Math.min(minBuyPrice, prices[i]);
            int sellprice = prices[i];

            int profit = sellprice - minBuyPrice;
            maxProfit = Math.max(profit, maxProfit);
        }

        return maxProfit;
    }
}
