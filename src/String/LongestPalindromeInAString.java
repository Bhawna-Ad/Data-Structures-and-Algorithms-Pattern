package String;

public class LongestPalindromeInAString {

    // Brute force solution
    // Time limit exceeded
    // Time Complexity: O(N^3)
    // Space Complexity: O(1)
    class Solution {
        public String longestPalindrome(String s) {
            if(s.length() == 1)
                return s;

            int max = 0;
            String ans = "";

            for(int i=0; i<=s.length(); i++) {
                for(int j=0; j<=i; j++) {
                    String str = s.substring(j, i);
                    if(isPalindrome(str)) {
                        if(str.length() > max) {
                            max = str.length();
                            ans = str;
                        }
                    }
                }
            }

            return ans;
        }

        private boolean isPalindrome(String s) {
            int i = 0;
            int j = s.length()-1;
            while(i<=j) {
                if(s.charAt(i) != s.charAt(j))
                    return false;
                i++;
                j--;
            }

            return true;
        }
    }

    // Better Solution:
    // Taking each element as the center and expanding and keep checking if it is palindrome.
    // We will check once for odd length palindrome and one for even lenght palindrome.
    // Time Complexity: O(N*N)
    // Space Complexity: O(1)
    class OptimalSolution {
        public String longestPalindrome(String s) {
            if(s.length() == 1)
                return s;

            int maxLen = 0;
            String ans = "";

            for(int i=0; i<s.length(); i++) {
                // check for odd length
                int left = i;
                int right = i;
                while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
                    if(right-left+1 > maxLen) {
                        ans = s.substring(left, right+1);
                        maxLen = right-left+1;
                    }
                    left--;
                    right++;
                }

                // check for even length
                left = i;
                right = i+1;
                while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
                    if(right-left+1 > maxLen) {
                        ans = s.substring(left, right+1);
                        maxLen = right - left + 1;
                    }
                    left--;
                    right++;
                }
            }

            return ans;
        }
    }
}
