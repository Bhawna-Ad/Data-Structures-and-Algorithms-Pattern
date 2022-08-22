package DynamicProgramming;

// https://leetcode.com/problems/longest-increasing-subsequence/
// using include exclude technique
public class LongestIncreasingSubsequence {

    // Recursion
    class RecursiveSolution {
        public int lengthOfLIS(int[] nums) {
            return longestLIS(nums, 0, Integer.MIN_VALUE);
        }

        private int longestLIS(int[] nums, int index, int prev) {
            if(index == nums.length)
                return 0;

            int include = 0;
            if(nums[index] > prev)
                include = 1 + longestLIS(nums, index+1, nums[index]);

            int exclude = longestLIS(nums, index+1, prev);

            return Math.max(include, exclude);
        }
    }

    // Memoization
    class MemoizationSolution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            Integer[][] dp = new Integer[n][n+1];
            return longestLIS(nums, 0, -1, dp);
        }

        private int longestLIS(int[] nums, int index, int prev, Integer[][] dp) {
            if(index == nums.length)
                return 0;

            if(dp[index][prev+1] != null)
                return dp[index][prev+1];

            int include = 0;
            if(prev==-1 || nums[index] > nums[prev])
                include = 1 + longestLIS(nums, index+1, index, dp);

            int exclude = longestLIS(nums, index+1, prev, dp);

            return dp[index][prev+1] = Math.max(include, exclude);
        }
    }

    // Tabulation
    class TabulationSolution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            Integer[][] dp = new Integer[n+1][n+1];

            for(int i=n; i>=0; i--)
                dp[n][i] = 0;

            for(int index=n-1; index>=0; index--) {
                for(int prev=index-1; prev>=-1; prev--) {
                    int include = 0;
                    if(prev==-1 || nums[index] > nums[prev])
                        include = 1 + dp[index+1][index+1];

                    int exclude = dp[index+1][prev+1];

                    dp[index][prev+1] = Math.max(include, exclude);
                }
            }
            return dp[0][0];
        }
    }

    // Space Optimization
    class SpaceOptimizationSolution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] next = new int[n+1];

            for(int index=n-1; index>=0; index--) {
                int[] curr = new int[n+1];
                for(int prev=index-1; prev>=-1; prev--) {
                    int include = 0;
                    if(prev==-1 || nums[index] > nums[prev])
                        include = 1 + next[index+1];

                    int exclude = next[prev+1];

                    curr[prev+1] = Math.max(include, exclude);
                }
                next = curr;
            }
            return next[0];
        }
    }
}
