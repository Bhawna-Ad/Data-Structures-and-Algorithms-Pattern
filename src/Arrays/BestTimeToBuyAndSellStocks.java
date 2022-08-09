package Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//Time Complexity: O(N)
//Space Complexity: O(1)
public class BestTimeToBuyAndSellStocks {
    class Solution {
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            int minPrice = Integer.MAX_VALUE;

            for(int i=0; i<prices.length; i++) {
                minPrice = Math.min(minPrice, prices[i]);
                maxProfit = Math.max(maxProfit, prices[i]-minPrice);
            }

            return maxProfit;
        }
    }
}
