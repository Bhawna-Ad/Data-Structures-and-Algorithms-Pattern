package DynamicProgramming;

// https://leetcode.com/problems/ones-and-zeroes/submissions/

public class O1Knapsack {

    // Recursion
    class RecursiveSolution {
        public int findMaxForm(String[] strs, int m, int n) {
            return maxLength(strs, 0, m, n);
        }

        private int maxLength(String[] strs, int index, int m, int n) {
            if((m==0 && n==0) || index>=strs.length)
                return 0;

            String s = strs[index];
            int ones = countOnes(s);
            int zeros = s.length()-ones;

            int include = 0;
            if(zeros<=m && ones<=n)
                include = 1 + maxLength(strs, index+1, m-zeros, n-ones);

            int exclude = maxLength(strs, index+1, m, n);

            return Math.max(include, exclude);
        }

        private int countOnes(String s) {
            int count = 0;
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '1')
                    count++;
            }
            return count;
        }
    }

    // Memoization
    class MemoizationSolution {
        public int findMaxForm(String[] strs, int m, int n) {
            int len = strs.length;
            Integer[][][] dp = new Integer[len][m+1][n+1];
            return maxLength(strs, 0, m, n, dp);
        }

        private int maxLength(String[] strs, int index, int m, int n, Integer[][][] dp) {
            if((m==0 && n==0) || index>=strs.length)
                return 0;

            if(dp[index][m][n] != null)
                return dp[index][m][n];

            String s = strs[index];
            int ones = countOnes(s);
            int zeros = s.length()-ones;

            int include = 0;
            if(zeros<=m && ones<=n)
                include = 1 + maxLength(strs, index+1, m-zeros, n-ones, dp);

            int exclude = maxLength(strs, index+1, m, n, dp);

            return dp[index][m][n] = Math.max(include, exclude);
        }

        private int countOnes(String s) {
            int count = 0;
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '1')
                    count++;
            }
            return count;
        }
    }

    // Tabulation
    class TabulationSolution {
        public int findMaxForm(String[] strs, int m, int n) {
            int len = strs.length;
            int[][][] dp = new int[len+1][m+1][n+1];

            for(int index=1; index<=len; index++) {
                String s = strs[index-1];
                int ones = countOnes(s);
                int zeros = s.length()-ones;
                for(int i=0; i<=m; i++) {
                    for(int j=0; j<=n; j++) {
                        int include = 0;
                        if(i>=zeros && j>=ones)
                            include = 1 + dp[index-1][i-zeros][j-ones];
                        int exclude = dp[index-1][i][j];

                        dp[index][i][j] = Math.max(include, exclude);
                    }
                }
            }
            return dp[len][m][n];
        }

        private int countOnes(String s) {
            int count = 0;
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '1')
                    count++;
            }

            return count;
        }
    }

    // Space Optimization
    class SpaceOptimizedSolution {
        public int findMaxForm(String[] strs, int m, int n) {
            int len = strs.length;
            int[][] dp = new int[m+1][n+1];

            for(int index=1; index<=len; index++) {
                String s = strs[index-1];
                int ones = countOnes(s);
                int zeros = s.length()-ones;
                for(int i=m; i>=zeros; i--) {
                    for(int j=n; j>=ones; j--) {
                        int include = 1 + dp[i-zeros][j-ones];
                        int exclude = dp[i][j];

                        dp[i][j] = Math.max(include, exclude);
                    }
                }
            }
            return dp[m][n];
        }

        private int countOnes(String s) {
            int count = 0;
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '1')
                    count++;
            }

            return count;
        }
    }

}
