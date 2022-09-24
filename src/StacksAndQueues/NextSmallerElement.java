package StacksAndQueues;

// https://www.interviewbit.com/problems/nearest-smaller-element/
// Since we have to find the nearest smaller index to the left we will iterate from left to right.

import java.util.Stack;

public class NextSmallerElement {
    public class Solution {
        public int[] prevSmaller(int[] A) {
            int[] ans = new int[A.length];
            Stack<Integer> stack = new Stack<>();

            for(int i=0; i<A.length; i++) {
                while(!stack.isEmpty() && stack.peek()>=A[i]) {
                    stack.pop();
                }

                ans[i] = stack.isEmpty() ? -1:stack.peek();
                stack.push(A[i]);
            }

            return ans;
        }
    }

}
