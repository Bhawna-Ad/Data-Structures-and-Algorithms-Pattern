package QuickNotes.DynamicProgramming.OneD;

// https://leetcode.com/problems/climbing-stairs/

public class ClimbingStairs {

    // Recursive Solution
    // Inclusive Exclusive
    // Time Complexity: O(2^n)
    // Space Complexity: O(n)
    // Will give TLE
    class RecursiveSolution {
        public int climbStairs(int n) {
            return steps(0, n);
        }

        private int steps(int index, int n) {
            // when the path is found.
            if(index == n)
                return 1;

            if(index > n)
                return 0;

            // can either climb one steps or two steps.
            int ones = steps(index + 1, n);
            int twos = steps(index + 2, n);

            // return all the possible ways
            return ones + twos;
        }
    }

    // Memoization
    // Accepted Solution
    // Time Complexity: O(N)
    // Space Complexity: O(N) + O(N)
    /*
    * For n = 5, the dp will contain [8, 5, 3, 2, 1]
    * */
    class MemoizationSolution {
        public int climbStairs(int n) {
            Integer[] dp = new Integer[n];
            return steps(0, n, dp);
        }

        private int steps(int index, int n, Integer[] dp) {
            if(index == n)
                return 1;

            if(index > n)
                return 0;

            if(dp[index] != null)
                return dp[index];

            int ones = steps(index + 1, n, dp);
            int twos = steps(index + 2, n, dp);

            return dp[index] = ones + twos;
        }
    }

    // Tabulation
    // Removes auxiliary stack space
    class TabulationSolution {
        public int climbStairs(int n) {
            Integer[] dp = new Integer[n+1];
            dp[1] = 1;
            dp[2] = 2;

            for(int i=3; i<=n; i++) {
                int ones = dp[i-1];
                int twos = dp[i-2];

                dp[i] = ones + twos;
            }
            return dp[n];
        }
    }

    // Space Optimization
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    class SpaceOptimizationSolution {
        public int climbStairs(int n) {
            int prev = 1;
            int prev2 = 1;

            for(int i=2; i<=n; i++) {
                int ones = prev;
                int twos = prev2;

                int curr = ones + twos;
                prev2 = prev;
                prev = curr;

            }
            return prev;
        }
    }
}
