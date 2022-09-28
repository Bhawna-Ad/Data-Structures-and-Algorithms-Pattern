package StacksAndQueues;

// https://leetcode.com/problems/online-stock-span/
// Find the nearest greater element to the left.

import java.util.Stack;

public class StockSpanProblem {
    class StockSpanner {
        Stack<int[]> st;
        public StockSpanner() {
            this.st = new Stack<>();
        }

        public int next(int price) {
            int span = 1;
            while(!st.isEmpty() && st.peek()[0]<=price)
                span += st.pop()[1];

            st.push(new int[] {price, span});

            return span;
        }
    }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
}
