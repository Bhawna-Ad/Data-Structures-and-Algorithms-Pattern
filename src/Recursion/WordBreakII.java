package Recursion;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/word-break-ii/
// Time Complexity: Exponential;

public class WordBreakII {
    class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            List<String> ans = new ArrayList<>();
            combinations(s, ans, wordDict, "");
            return ans;
        }

        private void combinations(String s, List<String>ans, List<String>wordDict, String word) {
            if(s.length() == 0) {
                ans.add(word.trim());
                return;
            }

            for(int i=0; i<s.length(); i++) {
                String left = s.substring(0, i+1);
                if(wordDict.contains(left)) {
                    String right = s.substring(i+1);
                    combinations(right, ans, wordDict, word+left+" ");
                }
            }
        }
    }
}
