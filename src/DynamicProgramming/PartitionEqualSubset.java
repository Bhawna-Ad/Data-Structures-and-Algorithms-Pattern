package DynamicProgramming;

// https://leetcode.com/problems/partition-equal-subset-sum/

public class PartitionEqualSubset {

    // Recursion
    class RecursiveSolution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for(int num: nums)
                sum += num;

            if(sum%2 == 1)
                return false;

            int target = sum/2;
            return subsetSum(nums, 0, target);
        }

        private boolean subsetSum(int[] nums, int index, int target) {
            if(index==nums.length || target<0)
                return false;

            if(target == 0)
                return true;

            boolean include = subsetSum(nums, index+1, target-nums[index]);
            boolean exclude = subsetSum(nums, index+1, target);

            return include || exclude;
        }
    }

    // Memoization
    class MemoizationSolution {
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            int sum = 0;
            for(int num: nums)
                sum += num;

            if(sum%2 == 1)
                return false;

            int target = sum/2;
            Integer[][] dp = new Integer[n][target+1];
            return subsetSum(nums, 0, target, dp)==1 ? true:false;
        }

        private int subsetSum(int[] nums, int index, int target, Integer[][] dp) {
            if(index==nums.length || target<0)
                return 0;

            if(target == 0)
                return 1;

            if(dp[index][target] != null)
                return dp[index][target];

            int include = subsetSum(nums, index+1, target-nums[index], dp);
            int exclude = subsetSum(nums, index+1, target, dp);

            return dp[index][target] = include==1 || exclude==1 ? 1:0;
        }
    }

    // Tabulation
    class TabulationSolution {
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            int sum = 0;
            for(int num: nums)
                sum += num;

            if(sum%2 == 1)
                return false;

            int target = sum/2;

            boolean[][] dp = new boolean[n][target+1];
            for(int i=0; i<n; i++)
                dp[i][0] = true;

            if(nums[0] <= target)
                dp[0][nums[0]] = true;

            for(int i=1; i<n; i++) {
                for(int j=1; j<=target; j++) {
                    boolean take = false;
                    if(j >= nums[i])
                        take = dp[i-1][j-nums[i]];
                    boolean skip = dp[i-1][j];

                    dp[i][j] = take || skip;
                }
            }


            return dp[n-1][target];
        }
    }

    // Space Optimization
    class Solution {
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            int sum = 0;
            for(int num: nums)
                sum += num;

            if(sum%2 == 1)
                return false;

            int target = sum/2;

            boolean[] prev = new boolean[target+1];
            for(int i=0; i<n; i++)
                prev[0] = true;

            if(nums[0] <= target)
                prev[nums[0]] = true;

            for(int i=1; i<n; i++) {
                boolean[] curr = new boolean[target+1];
                for(int j=1; j<=target; j++) {
                    boolean take = false;
                    if(j >= nums[i])
                        take = prev[j-nums[i]];
                    boolean skip = prev[j];

                    curr[j] = take || skip;
                }
                prev = curr;
            }


            return prev[target];
        }
    }

}
