package Recursion;

// https://leetcode.com/problems/palindrome-partitioning/
// Time Complexity: O(2^N)

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> ans = new ArrayList<>();
            partitions(s, 0, ans, new ArrayList<>());
            return ans;
        }

        private void partitions(String s, int index, List<List<String>> ans, List<String>part) {
            if(index == s.length()) {
                ans.add(new ArrayList<>(part));
                return;
            }

            for(int i=index; i<s.length(); i++) {
                System.out.println(s.substring(index, i+1));
                if(isPalindrome(s, index, i)) {
                    part.add(s.substring(index, i+1));
                    partitions(s, i+1, ans, part);
                    part.remove(part.size()-1);
                }
            }
        }

        private boolean isPalindrome(String s, int start, int end) {
            while(start <= end) {
                if(s.charAt(start) != s.charAt(end))
                    return false;
                start++;
                end--;
            }

            return true;
        }
    }
}
