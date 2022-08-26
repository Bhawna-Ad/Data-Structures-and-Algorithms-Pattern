package DynamicProgramming;

// https://leetcode.com/problems/minimum-path-sum/
// Can move right(row+1) and down(col+1)

public class MinimumSumPath {

    // Recursion
    class RecursiveSolution {
        public int minPathSum(int[][] grid) {
            return minPath(grid, 0, 0);
        }

        private int minPath(int[][] grid, int row, int col) {
            if(row==grid.length-1 && col==grid[0].length-1)
                return grid[row][col];

            int right = Integer.MAX_VALUE;
            int down = Integer.MAX_VALUE;

            if(row < grid.length-1)
                down = minPath(grid, row+1, col);

            if(col < grid[0].length-1)
                right = minPath(grid, row, col+1);

            return grid[row][col] + Math.min(down, right);
        }
    }

    // Memoization
    class MemoizationSolution {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            Integer[][] dp = new Integer[m][n];
            return minPath(grid, 0, 0, dp);
        }

        private int minPath(int[][] grid, int row, int col, Integer[][] dp) {
            if(row==grid.length-1 && col==grid[0].length-1)
                return grid[row][col];

            if(dp[row][col] != null)
                return dp[row][col];

            int right = Integer.MAX_VALUE;
            int down = Integer.MAX_VALUE;

            if(row < grid.length-1)
                down = minPath(grid, row+1, col, dp);

            if(col < grid[0].length-1)
                right = minPath(grid, row, col+1, dp);

            return dp[row][col] = grid[row][col] + Math.min(down, right);
        }
    }

    // Tabulation
    class TabulationSolution {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int[][] dp = new int[m][n];
            dp[0][0] = grid[0][0];

            for(int row=0; row<m; row++) {
                for(int col=0; col<n; col++) {
                    if(row==0 && col==0) {
                        dp[0][0] = grid[0][0];
                        continue;
                    }

                    int right = Integer.MAX_VALUE;
                    int down = Integer.MAX_VALUE;
                    if(row > 0)
                        right = dp[row-1][col];
                    if(col > 0)
                        down = dp[row][col-1];

                    dp[row][col] = grid[row][col] + Math.min(right, down);
                }
            }

            return dp[m-1][n-1];
        }
    }

    // Space Optimization
    class SpaceOptimizedSolution {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int[] prev = new int[n];

            for(int i=0; i<=m-1; i++) {
                int[] curr = new int[n];
                for(int j=0; j<=n-1; j++) {
                    if(i==0 && j==0) {
                        curr[j] = grid[i][j];
                        continue;
                    }

                    int down = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
                    if(i > 0)
                        down = prev[j];
                    if(j > 0)
                        right = curr[j-1];

                    curr[j] = grid[i][j] + Math.min(down, right);
                }
                prev = curr;
            }

            return prev[n-1];
        }
    }
}
