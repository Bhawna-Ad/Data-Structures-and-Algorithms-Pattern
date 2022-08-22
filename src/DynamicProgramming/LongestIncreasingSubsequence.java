package DynamicProgramming;

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


}
