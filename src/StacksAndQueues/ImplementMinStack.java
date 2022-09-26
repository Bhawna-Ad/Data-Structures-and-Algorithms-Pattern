package StacksAndQueues;

import java.util.Stack;

// https://leetcode.com/problems/min-stack/
// We will push each value into the stack.
// Whenever a value lesser than the min value till now is added, it will first put the min value into the stack and then update min.
// So when a value is popped out from the stack, if that is the min value then we will pop another value from the stack which is the next min.

public class ImplementMinStack {
    class MinStack {
        private Stack<Integer> st;
        private int min;

        public MinStack() {
            this.st = new Stack<>();
            this.min = Integer.MAX_VALUE;
        }

        public void push(int val) {
            if(min >= val) {
                // first insert the minimum that was before this element was added into the stack.
                st.push(min);
                min = val;
            }
            st.push(val);
        }

        public void pop() {
            if(st.pop() == min)
                min = st.pop();
        }

        public int top() {
            return st.peek();
        }

        public int getMin() {
            return min;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
