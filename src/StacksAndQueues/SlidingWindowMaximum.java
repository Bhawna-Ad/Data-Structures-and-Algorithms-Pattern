package StacksAndQueues;

// https://leetcode.com/problems/sliding-window-maximum/
// Using a deque, maintain the decreasing order in the deque and the size should not exceed k.
// Keep inserting the indices in the deque and every time check for two conditions:
//  1. the size of the deque should not exceed k, if it does remove an element from front of the deque.
//  2. the elements in the deque should be in a decreasing fashion,
//     if a greater element is found then keep removing the elements from the deque until an element greater than this value is found.
// Time Complexity: O(N)+O(N)
// Space Complexity: O(k)

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int[] ans = new int[n-k+1];
            int index = 0;

            Deque<Integer> deque = new ArrayDeque<>();
            for(int i=0; i<n; i++) {
                // maintaining the size of the deque as k.
                if(!deque.isEmpty() && deque.peek()==i-k)
                    deque.poll();

                // keep maintaining the decreasing order.
                while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i])
                    deque.pollLast();

                deque.add(i);

                // once a window of k values is formed start taking the answers.
                if(i >= k-1) {
                    ans[index++] = nums[deque.peek()];
                }
            }

            return ans;
        }
    }
}
