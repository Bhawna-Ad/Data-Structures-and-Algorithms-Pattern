package DynamicProgramming;

// https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1

public class MatrixChainMultiplication {

    // Recursion
    class Solution {
        static int matrixMultiplication(int N, int arr[]) {
            return mcm(arr, 1, N-1);
        }

        private static int mcm(int[] arr, int i, int j) {
            if(i == j) {
                return 0;
            }

            int min = Integer.MAX_VALUE;

            for(int k=i; k<j; k++) {
                int steps = arr[i-1]*arr[k]*arr[j] + mcm(arr, i, k) + mcm(arr, k+1, j);
                min = Math.min(min, steps);
            }

            return min;
        }
    }

    // Memoization
    class MemoizationSolution {
        static int matrixMultiplication(int N, int arr[]) {
            Integer[][] dp = new Integer[N][N];
            return mcm(arr, 1, N-1, dp);
        }

        private static int mcm(int[] arr, int i, int j, Integer[][] dp) {
            if(i == j) {
                return 0;
            }

            if(dp[i][j] != null) {
                return dp[i][j];
            }

            int min = Integer.MAX_VALUE;

            for(int k=i; k<j; k++) {
                int steps = arr[i-1]*arr[k]*arr[j] + mcm(arr, i, k, dp) + mcm(arr, k+1, j, dp);
                min = Math.min(min, steps);
            }

            return dp[i][j] = min;
        }
    }
}
