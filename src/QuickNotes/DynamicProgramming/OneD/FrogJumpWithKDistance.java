package QuickNotes.DynamicProgramming.OneD;

public class FrogJumpWithKDistance {

    // Recursive Solution
    public class RecursiveSolution {
        public static int frogJump(int n, int[] heights, int k) {
            return jumps(0, n, heights, k);
        }

        private static int jumps(int index, int n, int[] heights, int k) {
            if(index >= n-1)
                return 0;

            int ans = Integer.MAX_VALUE;

            for(int i=1; i<=k; i++) {

                if(index + i < n) {
                    int first = Math.abs(heights[index]-heights[index+i]) + jumps(index+i, n, heights, k);
                    ans = Math.min(ans, first);
                }
            }

            return ans;
        }

    }


    // Memoization
    public class MemoizationSolution {
        public static int frogJump(int n, int[] heights, int k) {
            Integer[] dp = new Integer[n];
            return jumps(0, n, heights, k, dp);
        }

        private static int jumps(int index, int n, int[] heights, int k, Integer[] dp) {
            if(index >= n-1)
                return 0;

            if(dp[index] != null)
                return dp[index];

            int ans = Integer.MAX_VALUE;

            for(int i=1; i<=k; i++) {

                if(index + i < n) {
                    int first = Math.abs(heights[index]-heights[index+i]) + jumps(index+i, n, heights, k, dp);
                    ans = Math.min(ans, first);
                }
            }

            return ans;
        }
    }

    // Tabulation
    // Time Complexity: O(N*k)
    class TabulationSolution {
        public static int frogJump(int n, int[] heights, int k) {
            Integer[] dp = new Integer[n];
            dp[0] = 0;

            for(int index=1; index<n; index++) {
                int ans = Integer.MAX_VALUE;

                for(int i=1; i<=k; i++) {

                    if(index - i >= 0) {
                        int first = Math.abs(heights[index]-heights[index-i]) + dp[index-i];
                        ans = Math.min(ans, first);
                    }
                }

                dp[index] =  ans;
            }
            return dp[n-1];
        }
    }



}
