package DynamicProgramming;

// https://leetcode.com/problems/longest-common-subsequence/
// Using two indices, choose if matched else move indices alternatively.

public class LongestCommonSubsequence {

    // Recursion
    // Exponential time complexity
    class RecursiveSolution {
        public int longestCommonSubsequence(String text1, String text2) {
            return longestSeq(text1, text2, 0, 0);
        }

        private int longestSeq(String text1, String text2, int index1, int index2) {
            if(index1 == text1.length() || index2 == text2.length())
                return 0;

            if(text1.charAt(index1) == text2.charAt(index2))
                return 1 + longestSeq(text1, text2, index1+1, index2+1);

            return Math.max(longestSeq(text1, text2, index1+1, index2), longestSeq(text1, text2, index1, index2+1));
        }
    }

    // Memoization
    class MemoizationSolution {
        public int longestCommonSubsequence(String text1, String text2) {
            int n1 = text1.length();
            int n2 = text2.length();

            Integer[][] dp = new Integer[n1][n2];
            return longestSeq(text1, text2, 0, 0, dp);
        }

        private int longestSeq(String text1, String text2, int index1, int index2, Integer[][] dp) {
            if(index1 == text1.length() || index2 == text2.length())
                return 0;

            if(dp[index1][index2] != null)
                return dp[index1][index2];

            if(text1.charAt(index1) == text2.charAt(index2))
                return 1 + longestSeq(text1, text2, index1+1, index2+1, dp);

            return dp[index1][index2] = Math.max(longestSeq(text1, text2, index1+1, index2, dp), longestSeq(text1, text2, index1, index2+1, dp));
        }
    }

    // Tabulation
    class TabulationSolution {
        public int longestCommonSubsequence(String text1, String text2) {
            int n1 = text1.length();
            int n2 = text2.length();

            Integer[][] dp = new Integer[n1+1][n2+1];
            for(int i=0; i<=n2; i++)
                dp[n1][i] = 0;

            for(int i=0; i<=n1; i++)
                dp[i][n2] = 0;

            for(int index1=n1-1; index1>=0; index1--) {
                for(int index2=n2-1; index2>=0; index2--) {
                    if(text1.charAt(index1) == text2.charAt(index2))
                        dp[index1][index2] = 1 + dp[index1+1][index2+1];

                    else
                        dp[index1][index2] = Math.max(dp[index1+1][index2], dp[index1][index2+1]);
                }
            }

            return dp[0][0];
        }
    }

    // Space Optimization
    class SpaceOptimizedSolution {
        public int longestCommonSubsequence(String text1, String text2) {
            int n1 = text1.length();
            int n2 = text2.length();

            int[] prev = new int[n2+1];

            for(int index1=n1-1; index1>=0; index1--) {
                int[] curr = new int[n2+1];
                for(int index2=n2-1; index2>=0; index2--) {
                    if(text1.charAt(index1) == text2.charAt(index2))
                        curr[index2] = 1 + prev[index2+1];

                    else
                        curr[index2] = Math.max(prev[index2], curr[index2+1]);
                }
                prev = curr;
            }

            return prev[0];
        }
    }
}
