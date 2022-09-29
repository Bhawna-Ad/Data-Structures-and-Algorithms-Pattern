package String;

// https://leetcode.com/problems/roman-to-integer/
// store the values into variables and add them.

public class RomanNumberToIntegerAndViceVersa {
    class Solution {
        public int romanToInt(String s) {
            final int I=1,V=5,X=10,L=50,C=100,D=500,M=1000;

            int sum=0;

            for(int i=0; i<s.length(); i++){
                switch(s.charAt(i)){
                    case 'M':
                        sum=sum+M;
                        break;
                    case 'D':
                        sum=sum+D;
                        break;
                    case 'C':
                        if(i<s.length()-1 &&(s.charAt(i+1)=='D'||s.charAt(i+1)=='M'))
                            sum=sum - C;
                        else
                            sum=sum + C;
                        break;
                    case 'L':
                        sum=sum + L;
                        break;
                    case 'X':
                        if(i<s.length()-1&&(s.charAt(i+1)=='L'||s.charAt(i+1)=='C'))
                            sum=sum - X;
                        else
                            sum=sum + X;
                        break;
                    case 'V':
                        sum=sum + V;
                        break;
                    case 'I':
                        if(i<s.length()-1&&(s.charAt(i+1)=='X'||s.charAt(i+1)=='V'))
                            sum=sum - I;
                        else
                            sum=sum + I;
                        break;

                }

            }
            return sum;
        }
    }
}
