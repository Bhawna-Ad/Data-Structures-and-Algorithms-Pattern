package DynamicProgramming;

public class MaximumSumIncreasingSubsequence {

    // Recursion
    class RecursiveSolution {
        public int maxSumIS(int arr[], int n) {
            return maxSum(arr, 0, -1);
        }

        private int maxSum(int[] nums, int index, int prev) {
            if(index == nums.length) {
                return 0;
            }

            int include = 0;
            if(nums[index] > prev) {
                include = nums[index] + maxSum(nums, index+1, nums[index]);
            }

            int exclude = maxSum(nums, index+1, prev);

            return Math.max(include, exclude);
        }
    }

    // Memoization
    class MemoizationSolution {
        public int maxSumIS(int arr[], int n) {
            //code here.
            Integer[][] dp = new Integer[n][n + 1];
            return maxSum(arr, 0, -1, dp);

        }

        private int maxSum(int[] nums, int index, int prev, Integer[][] dp) {
            if (index == nums.length) {
                return 0;
            }

            if (dp[index][prev + 1] != null) {
                return dp[index][prev + 1];
            }

            int include = 0;
            if (prev == -1 || nums[index] > nums[prev]) {
                include = nums[index] + maxSum(nums, index + 1, index, dp);
            }

            int exclude = maxSum(nums, index + 1, prev, dp);

            return dp[index][prev + 1] = Math.max(include, exclude);
        }
    }
}
