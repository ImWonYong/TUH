class Solution {
    public int maxProfit(int[] prices) {
        int price = prices[0];
        int max = 0;
        for(int i = 1; i < prices.length; i++) {
            if (prices[i] - price < 0) {
                price = prices[i];
            } else {
                if (max < prices[i] - price) {
                    max = prices[i] - price;
                }
            }
        }
        return max;
    }
}