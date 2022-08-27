package DynamicProgramming;

// https://leetcode.com/problems/word-break/

import java.util.List;

public class WordBreak {

    // Recursion
    class RecursiveSolution {
        public boolean wordBreak(String s, List<String> wordDict) {
            return breaks(s, 0, wordDict);
        }

        private boolean breaks(String s, int index, List<String>wordDict) {
            if(index == s.length())
                return true;

            for(int i=index+1; i<=s.length(); i++) {
                if(wordDict.contains(s.substring(index, i)) && breaks(s, i, wordDict))
                    return true;
            }

            return false;
        }
    }

    // Memoization
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int n = s.length();
            Integer[] dp = new Integer[n+1];
            return breaks(s, 0, wordDict, dp)==1;
        }

        private int breaks(String s, int index, List<String>wordDict, Integer[] dp) {
            if(index == s.length())
                return 1;

            if(dp[index]!=null)
                return dp[index];

            for(int i=index+1; i<=s.length(); i++) {
                if(wordDict.contains(s.substring(index, i)) && breaks(s, i, wordDict, dp)==1)
                    return dp[index] = 1;
            }

            return dp[index] = 0;
        }
    }
}
