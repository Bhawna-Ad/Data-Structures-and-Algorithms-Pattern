package String;

// https://www.interviewbit.com/problems/minimum-characters-required-to-make-a-string-palindromic/
// Using KMP Algorithm

public class MinimumCharactersToMakePalindrome {
    public class Solution {
        public int solve(String A) {
            StringBuilder B = new StringBuilder(A);
            B.reverse();

            String pattern = A + "$" + B;
            int m = pattern.length();

            int i = 1;
            int prevLPS = 0;
            int[] lps = new int[m];
            while(i < m) {
                if(pattern.charAt(i) == pattern.charAt(prevLPS)) {
                    lps[i] = prevLPS + 1;
                    prevLPS++;
                    i++;
                } else {
                    if(prevLPS == 0) {
                        lps[i] = 0;
                        i++;
                    } else {
                        prevLPS = lps[prevLPS-1];
                    }
                }
            }

            return A.length() - lps[m-1];
        }
    }

}
