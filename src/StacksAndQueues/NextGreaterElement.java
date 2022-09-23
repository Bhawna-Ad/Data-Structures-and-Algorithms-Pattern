package StacksAndQueues;

// https://leetcode.com/problems/next-greater-element-ii/description/
// We have to find the next greater element to the right so we will iterate from right to left.
// Since the array is circular we can start from twice the size of the array.
// Time Complexity: O(N)

import java.util.Stack;

public class NextGreaterElement {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            Stack<Integer> st = new Stack<>();

            for(int i=2*n-1; i>=0; i--) {
                while(!st.isEmpty() && st.peek()<=nums[i%n])
                    st.pop();

                ans[i%n] = st.isEmpty() ? -1:st.peek();
                st.push(nums[i%n]);
            }

            return ans;
        }
    }
}
