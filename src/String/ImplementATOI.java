package String;

// https://leetcode.com/problems/string-to-integer-atoi/

public class ImplementATOI {
    class Solution {
        public int myAtoi(String s) {
            if(s.length() == 0)
                return 0;
            int index = 0;
            int num = 0;

            // skipping leading spaces
            while(index<s.length()-1 && s.charAt(index) == ' ')
                index++;

            // checking whether the number is positive or not.
            int sign = 1;
            if(s.charAt(index) == '-') {
                sign = -1;
                index++;
            }
            else if(s.charAt(index) == '+')
                index++;


            // creating the number
            while(index<s.length() && Character.isDigit(s.charAt(index))) {
                int digit = s.charAt(index) - '0';

                // we need to check before multiplying the number with 10 hence divide by 10
                // if the number is out of range then cap it at Max or min value accordingly.
                if ((num > Integer.MAX_VALUE / 10) ||
                        (num == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                num = 10*num + digit;
                index++;
            }
            return num*sign;
        }
    }
}
