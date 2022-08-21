package QuickNotes.DynamicProgramming.OneD;

// https://www.codingninjas.com/codestudio/problems/frog-jump_3621012

public class FrogJump {

    // Recursion
    // Inclusive Exclusive
    public class RecursiveSolution {
        public static int frogJump(int n, int[] heights) {
            return jumps(0, n, heights);
        }

        private static int jumps(int index, int n, int[] heights) {
            if(index >= n-1)
                return 0;

            int first = Math.abs(heights[index]-heights[index+1]) + jumps(index+1, n, heights);

            int second = Integer.MAX_VALUE;
            if(index < n-2)
                second = Math.abs(heights[index]-heights[index+2]) + jumps(index+2, n, heights);

            return Math.min(first, second);
        }

    }

    // Memoization
    public class MemoSolution {
        public static int frogJump(int n, int[] heights) {
            Integer[] dp = new Integer[n];
            return jumps(0, n, heights, dp);
        }

        private static int jumps(int index, int n, int[] heights, Integer[] dp) {
            if(index >= n-1)
                return 0;

            if(dp[index] != null)
                return dp[index];

            int first = Math.abs(heights[index]-heights[index+1]) + jumps(index+1, n, heights, dp);

            int second = Integer.MAX_VALUE;
            if(index < n-2)
                second = Math.abs(heights[index]-heights[index+2]) + jumps(index+2, n, heights, dp);

            return dp[index] = Math.min(first, second);
        }
    }

    // Tabulation
    public class TabulationSolution {
        public static int frogJump(int n, int[] heights) {
            int[] dp = new int[n];

            for(int index=1; index<n; index++) {
                int first = Math.abs(heights[index]-heights[index-1]) + dp[index-1];

                int second = Integer.MAX_VALUE;
                if(index >= 2)
                    second = Math.abs(heights[index]-heights[index-2]) + dp[index-2];

                dp[index] = Math.min(first, second);
            }

            return dp[n-1];
        }
    }

    // Space Optimization
    public class SpaceOptimizedSolution {
        public static int frogJump(int n, int heights[]) {

            int prev = 0;
            int prev2 = 0;

            for(int index=1; index<n; index++) {
                int first = Math.abs(heights[index]-heights[index-1]) + prev;

                int second = Integer.MAX_VALUE;
                if(index >= 2)
                    second = Math.abs(heights[index]-heights[index-2]) + prev2;

                int curr = Math.min(first, second);
                prev2 = prev;
                prev = curr;
            }

            return prev;
        }
    }
}
