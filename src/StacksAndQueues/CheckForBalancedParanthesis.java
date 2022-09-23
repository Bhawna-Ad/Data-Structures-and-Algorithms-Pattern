package StacksAndQueues;

// https://leetcode.com/problems/valid-parentheses/
// Insert the opening brackets into the stack and pop out the brackets if a match is found.

import java.util.Stack;

public class CheckForBalancedParanthesis {
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> st = new Stack<>();

            for(char ch: s.toCharArray()) {
                if(ch=='(' || ch=='[' || ch=='{')
                    st.push(ch);
                else {
                    if(st.isEmpty())
                        return false;

                    if(ch==')' && st.peek()=='('
                            || ch==']' && st.peek()=='['
                            || ch=='}' && st.peek()=='{')
                        st.pop();
                    else
                        return false;
                }
            }

            return st.isEmpty();
        }
    }
}
