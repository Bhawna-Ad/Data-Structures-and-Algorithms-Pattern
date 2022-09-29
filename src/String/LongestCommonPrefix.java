package String;

// https://leetcode.com/problems/longest-common-prefix/
// Time Complexity: O(S) where S is the sum of all the characters in the array

public class LongestCommonPrefix {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String ans = "";

            int index = 0;
            while(true) {
                if(index > strs[0].length()-1)
                    break;
                char c = strs[0].charAt(index);
                for(int i=1; i<strs.length; i++) {
                    if(index > strs[i].length()-1 || strs[i].charAt(index) != c)
                        return ans;
                }

                ans += c;
                index++;
            }

            return ans;
        }
    }
}
