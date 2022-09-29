package String;

// https://leetcode.com/problems/count-and-say/
/*
*  The sequence goes as:
*   if n = 5;
*   countAndSay(1) = "1"
*   countAndSay(2) = "11"
*   countAndSay(3) = "21"
*   countAndSay(4) = "1211"
*   countAndSay(5) = "111221"
*
*   first add the count of the digit and then put the digit.
* */

public class CountAndSay {
    class Solution {
        public String countAndSay(int n) {
            if(n == 1)
                return "1";

            String s = countAndSay(n-1);
            StringBuilder sb = new StringBuilder();

            int index = 0;
            while(index < s.length()) {
                int count = 1;
                char ch = s.charAt(index++);
                while(index<s.length() && s.charAt(index)==ch) {
                    count++;
                    index++;
                }

                sb.append(count);
                sb.append(ch);
            }

            return sb.toString();

        }
    }
}
