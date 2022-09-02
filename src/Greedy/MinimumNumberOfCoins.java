package Greedy;

// https://practice.geeksforgeeks.org/problems/number-of-coins1824/1
// Time Complexity: O(V)
// Space Complexity: O(N)

public class MinimumNumberOfCoins {
    class Solution{
        public int minCoins(int V) {
            int count = 0;
            int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
            int n = coins.length;
            for(int i=0; i<n; i++) {
                while (V >= coins[i]) {
                    V -= coins[i];
                    count++;
                }
            }
            return count;
        }
    }
}
