package DynamicProgramming;

// https://leetcode.com/problems/palindrome-partitioning/

public class PalindromicPartitioning {

    // Recursion
    class RecursiveSolution{
        static int palindromicPartition(String str)
        {
            // code here
            return f(0, str)-1;
        }

        static int f(int index, String str) {
            if(index==str.length()) return 0;

            String temp = "";
            int minCost = Integer.MAX_VALUE;
            for(int i=index; i<str.length(); i++) {
                temp += str.charAt(i);
                if(isPalindrome(temp)) {
                    int cost = 1 + f(i+1, str);
                    minCost = Math.min(minCost, cost);
                }
            }
            return minCost;
        }

        static boolean isPalindrome(String s) {
            int i=0;
            int j=s.length()-1;
            while(i <= j) {
                if(s.charAt(i) != s.charAt(j)) return false;
                i++;
                j--;
            }

            return true;
        }
    }

    // Memoization
    class MemoizationSolution{
        static int palindromicPartition(String str)
        {
            // code here
            Integer[] dp = new Integer[str.length()];
            return f(0, str, dp)-1;
        }

        static int f(int index, String str, Integer[] dp) {
            if(index==str.length()) return 0;

            if(dp[index] != null) return dp[index];

            String temp = "";
            int minCost = Integer.MAX_VALUE;
            for(int i=index; i<str.length(); i++) {
                temp += str.charAt(i);
                if(isPalindrome(temp)) {
                    int cost = 1 + f(i+1, str, dp);
                    minCost = Math.min(minCost, cost);
                }
            }
            return dp[index] = minCost;
        }

        static boolean isPalindrome(String s) {
            int i=0;
            int j=s.length()-1;
            while(i <= j) {
                if(s.charAt(i) != s.charAt(j)) return false;
                i++;
                j--;
            }

            return true;
        }
    }
}
