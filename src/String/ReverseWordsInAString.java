package String;

public class ReverseWordsInAString {
    class Solution {
        public String reverseWords(String s) {
            String ans = "";
            int i = s.length()-1;
            while(i >= 0) {
                while(i>=0 && s.charAt(i) == ' ')
                    i--;

                int j = i;
                while(i>=0 && s.charAt(i)!=' ')
                    i--;

                ans += s.substring(i+1, j+1) + " ";
            }

            return ans.trim();
        }
    }
}
