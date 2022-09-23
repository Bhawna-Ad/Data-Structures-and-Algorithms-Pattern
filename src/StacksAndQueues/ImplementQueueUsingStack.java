package StacksAndQueues;

// https://leetcode.com/problems/implement-queue-using-stacks/
// Constant inserting time solution
// Either push or pop will be costly.
// Insert in one stack and when taking out elements add all the elements from that stack into another.

import java.util.Stack;

public class ImplementQueueUsingStack {
    class MyQueue {

        Stack<Integer> input;
        Stack<Integer>output;

        public MyQueue() {
            this.input = new Stack<>();
            this.output = new Stack<>();
        }

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            if(output.isEmpty()) {
                while(!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.pop();
        }

        public int peek() {
            if(output.isEmpty()) {
                while(!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.peek();
        }

        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
