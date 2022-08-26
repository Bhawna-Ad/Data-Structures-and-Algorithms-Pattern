package DynamicProgramming;

// https://leetcode.com/problems/edit-distance/
// Trying all possible operations each time the characters from both strings do not match.

public class EditDistance {

    // Recursion
    // Time Complexity: Exponential (O(3^n*3^m))
    // Space Complexity: O(N+M)
    class RecursionSolution {
        public int minDistance(String word1, String word2) {
            return distance(word1, word2, 0, 0);
        }

        private int distance(String word1, String word2, int index1, int index2) {
            // if first string gets exhausted first, perform insert operation for the remaining elements of the second string.
            // Hence, add 1, number of characters left in second string times and return it.
            if(index1 == word1.length())
                return word2.length()-index2;

            // if second string gets exhausted first, perform delete operation on the remaining elements of the first string.
            // Hence, add 1, numbers of characters left in first string times and return it.
            if(index2 == word2.length())
                return word1.length()-index1;

            // No operation performed when the characters match.
            if(word1.charAt(index1) == word2.charAt(index2))
                return distance(word1, word2, index1+1, index2+1);

            // try all possible operations.

            // insert an element right before the current value of index1
            int insert = 1 + distance(word1, word2, index1, index2+1);
            // delete the element at index index1.
            int delete = 1 + distance(word1, word2, index1+1, index2);
            // replace the element at index index1.
            int replace = 1 + distance(word1, word2, index1+1, index2+1);

            return Math.min(insert, Math.min(delete, replace));
        }
    }

    // Memoization
    // Time Complexity: O(N*M)
    // Space Complexity: O(N*M) + O(N+M)
    class MemoizationSolution {
        public int minDistance(String word1, String word2) {
            int n1 = word1.length();
            int n2 = word2.length();
            Integer[][] dp = new Integer[n1][n2];
            return distance(word1, word2, 0, 0, dp);
        }

        private int distance(String word1, String word2, int index1, int index2, Integer[][] dp) {
            if(index1 == word1.length())
                return word2.length()-index2;

            if(index2 == word2.length())
                return word1.length()-index1;

            if(dp[index1][index2] != null)
                return dp[index1][index2];

            if(word1.charAt(index1) == word2.charAt(index2))
                return distance(word1, word2, index1+1, index2+1, dp);

            int insert = 1 + distance(word1, word2, index1, index2+1, dp);
            int delete = 1 + distance(word1, word2, index1+1, index2, dp);
            int replace = 1 + distance(word1, word2, index1+1, index2+1, dp);

            return dp[index1][index2] = Math.min(insert, Math.min(delete, replace));
        }
    }

    // Tabulation
    // Time Complexity: O(N*M)
    // Space Complexity: O(N*M)
    class TabulationSolution {
        public int minDistance(String word1, String word2) {
            int n1 = word1.length();
            int n2 = word2.length();
            Integer[][] dp = new Integer[n1+1][n2+1];

            for(int i=0; i<=n1; i++)
                dp[i][n2] = n1-i;

            for(int i=0; i<=n2; i++)
                dp[n1][i] = n2-i;

            for(int index1=n1-1; index1>=0; index1--) {
                for(int index2=n2-1; index2>=0; index2--) {
                    if(word1.charAt(index1) == word2.charAt(index2)) {
                        dp[index1][index2] = dp[index1+1][index2+1];
                        continue;
                    }

                    int insert = 1 + dp[index1][index2+1];
                    int delete = 1 + dp[index1+1][index2];
                    int replace = 1 + dp[index1+1][index2+1];

                    dp[index1][index2] = Math.min(insert, Math.min(delete, replace));
                }
            }

            return dp[0][0];
        }
    }


    // Space Optimization
    class Solution {
        public int minDistance(String word1, String word2) {
            int n1 = word1.length();
            int n2 = word2.length();
            int[] next = new int[n2+1];

            for(int i=0; i<=n2; i++)
                next[i] = n2-i;

            for(int index1=n1-1; index1>=0; index1--) {
                int[] curr = new int[n2+1];
                curr[n2] = n1 - index1;
                for(int index2=n2-1; index2>=0; index2--) {
                    if(word1.charAt(index1) == word2.charAt(index2)) {
                        curr[index2] = next[index2+1];
                        continue;
                    }

                    int insert = 1 + curr[index2+1];
                    int delete = 1 + next[index2];
                    int replace = 1 + next[index2+1];

                    curr[index2] = Math.min(insert, Math.min(delete, replace));
                }
                next = curr;
            }

            return next[0];
        }
    }


}
