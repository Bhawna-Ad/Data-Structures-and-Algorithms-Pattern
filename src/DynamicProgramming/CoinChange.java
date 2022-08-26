package DynamicProgramming;

// https://leetcode.com/problems/coin-change/

public class CoinChange {

    // Recursion
    class RecursionSolution {
        public int coinChange(int[] coins, int amount) {
            int ans = minCoins(coins, amount, 0);
            System.out.println(Integer.MAX_VALUE);
            return ans==Integer.MAX_VALUE-1 ? -1:ans;
        }

        private int minCoins(int[] coins, int amount, int index) {
            if(index == coins.length-1) {
                if(amount%coins[index] == 0)
                    return amount/coins[index];
                return Integer.MAX_VALUE-1;
            }

            int include = Integer.MAX_VALUE;
            if(amount >= coins[index])
                include = 1 + minCoins(coins, amount-coins[index], index);
            int exclude = minCoins(coins, amount, index+1);

            return Math.min(include, exclude);
        }
    }

    // Memoization
    class MemoizationSolution {
        public int coinChange(int[] coins, int amount) {
            int n = coins.length;
            Integer[][] dp = new Integer[n][amount+1];
            int ans = minCoins(coins, amount, 0, dp);
            return ans==Integer.MAX_VALUE-1 ? -1:ans;
        }

        private int minCoins(int[] coins, int amount, int index, Integer[][] dp) {
            if(index == coins.length-1) {
                if(amount%coins[index] == 0)
                    return amount/coins[index];
                return Integer.MAX_VALUE-1;
            }

            if(dp[index][amount] != null)
                return dp[index][amount];

            int include = Integer.MAX_VALUE;
            if(amount >= coins[index])
                include = 1 + minCoins(coins, amount-coins[index], index, dp);
            int exclude = minCoins(coins, amount, index+1, dp);

            return dp[index][amount] = Math.min(include, exclude);
        }
    }

    // Tabulation
    class TabulationSolution {
        public int coinChange(int[] coins, int amount) {
            int n = coins.length;
            int[][] dp = new int[n][amount+1];

            for(int i=0; i<=amount; i++) {
                if(i%coins[0] == 0)
                    dp[0][i] = i/coins[0];
                else
                    dp[0][i] = Integer.MAX_VALUE-1;
            }

            for(int index=1; index<n; index++) {
                for(int t=0; t<=amount; t++) {
                    int include = Integer.MAX_VALUE-1;
                    if(t >= coins[index])
                        include = 1 + dp[index][t-coins[index]];
                    int exclude = dp[index-1][t];

                    dp[index][t] = Math.min(include, exclude);
                }
            }

            int ans = dp[n-1][amount];
            return ans==Integer.MAX_VALUE-1 ? -1:ans;
        }
    }

    // Space Optimization
    class SpaceOptimizationSolution {
        public int coinChange(int[] coins, int amount) {
            int n = coins.length;
            int[] prev = new int[amount+1];

            for(int i=0; i<=amount; i++) {
                if(i%coins[0] == 0)
                    prev[i] = i/coins[0];
                else
                    prev[i] = Integer.MAX_VALUE-1;
            }

            for(int index=1; index<n; index++) {
                int[] curr = new int[amount+1];
                for(int t=0; t<=amount; t++) {
                    int include = Integer.MAX_VALUE-1;
                    if(t >= coins[index])
                        include = 1 + curr[t-coins[index]];
                    int exclude = prev[t];

                    curr[t] = Math.min(include, exclude);
                }
                prev = curr;
            }

            int ans = prev[amount];
            return ans==Integer.MAX_VALUE-1 ? -1:ans;
        }
    }
}
