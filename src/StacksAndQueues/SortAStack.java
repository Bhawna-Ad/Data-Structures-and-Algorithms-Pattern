package StacksAndQueues;

// https://www.codingninjas.com/codestudio/problems/sort-a-stack_985275

import java.util.Stack;

// Sorting the stack recursively.

public class SortAStack {
    public class Solution {

        // First off remove each element from the stack and store it separately.
        public static void sortStack(Stack<Integer> stack) {
            // Write your code here.
            if(stack.isEmpty())
                return;

            int num = stack.pop();
            sortStack(stack);

            // once the stack is empty start inserting the values in stack according to their values.
            insert(stack, num);
        }

        // To insert the values into the stack in sorted manner.
        private static void insert(Stack<Integer>stack, int num) {
            // if the stack is empty or the value is greater than the value at the top of the stack
            // just add the value into the stack and return.
            if(stack.isEmpty() || stack.peek()<num) {
                stack.push(num);
                return;
            }

            // otherwise if that value is lesser than the top value of the stack
            // then remove the values from the stack one by one and insert them back into the stack at their correct place.
            int rem = stack.pop();
            insert(stack, num);
            stack.push(rem);
        }

    }
}
