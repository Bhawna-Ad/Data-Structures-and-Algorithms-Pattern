package DynamicProgramming;

// https://leetcode.com/problems/minimum-cost-to-cut-a-stick/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumCostToCutAStick {

    // Recursion
    class RecursiveSolution {
        public int minCost(int n, int[] cuts) {
            List<Integer> list = new ArrayList<>();
            for(int c: cuts)
                list.add(c);
            list.add(0);
            list.add(n);

            Collections.sort(list);
            return cost(1, cuts.length, list);
        }

        private int cost(int i, int j, List<Integer>cuts) {
            if(i > j)
                return 0;

            int minn = Integer.MAX_VALUE;
            for(int ind=i; ind<=j; ind++) {
                int cost = cuts.get(j+1)-cuts.get(i-1) + cost(i, ind-1, cuts) + cost(ind+1, j, cuts);
                minn = Math.min(minn, cost);
            }

            return minn;
        }
    }


    // Memoization
    class MemoizationSolution {
        public int minCost(int n, int[] cuts) {
            int len = cuts.length;
            List<Integer>list = new ArrayList<>();
            for(int c: cuts)
                list.add(c);
            list.add(0);
            list.add(n);

            Collections.sort(list);

            Integer[][] dp = new Integer[len+1][len+1];
            return cost(1, len, list, dp);
        }

        private int cost(int i, int j, List<Integer>cuts, Integer[][] dp) {
            if(i > j)
                return 0;

            if(dp[i][j] != null)
                return dp[i][j];

            int minn = Integer.MAX_VALUE;
            for(int ind=i; ind<=j; ind++) {
                int cost = cuts.get(j+1)-cuts.get(i-1) + cost(i, ind-1, cuts, dp) + cost(ind+1, j, cuts, dp);
                minn = Math.min(minn, cost);
            }

            return dp[i][j] = minn;
        }
    }

    // Tabulation
    class Solution {
        public int minCost(int n, int[] cuts) {
            int len = cuts.length;
            List<Integer>list = new ArrayList<>();
            for(int c: cuts)
                list.add(c);
            list.add(0);
            list.add(n);

            Collections.sort(list);

            int[][] dp = new int[len+2][len+2];

            for(int i=len; i>=1; i--) {
                for(int j=1; j<=len; j++) {
                    if(i > j) continue;
                    int minn = Integer.MAX_VALUE;

                    for(int ind=i; ind<=j; ind++) {
                        int cost = list.get(j+1)-list.get(i-1) + dp[i][ind-1] + dp[ind+1][j];
                        minn = Math.min(minn, cost);
                    }

                    dp[i][j] = minn;
                }
            }
            return dp[1][len];
        }
    }

}
