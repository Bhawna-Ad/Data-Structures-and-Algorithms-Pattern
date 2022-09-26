package StacksAndQueues;

// https://leetcode.com/problems/largest-rectangle-in-histogram/

import java.util.Stack;

public class LargestRectangleInHistogram {
    /*
    * Two pass solution:
    * For every rectangle find the first min from the left and first min from the right.
    * */
    class TwoPassSolution {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] left = new int[n];
            int[] right = new int[n];

            nearestSmallerToLeft(heights, left, n);
            nearestSmallerToRight(heights, right, n);

            int max = Integer.MIN_VALUE;

            for(int i=0; i<n; i++) {
                int area = (right[i]-left[i]-1)*heights[i];
                max = Math.max(max, area);
            }

            return max;
        }

        private void nearestSmallerToLeft(int[] heights, int[] left, int n) {
            Stack<Integer> st = new Stack<>();
            for(int i=0; i<n; i++) {
                while(!st.isEmpty() && heights[i]<=heights[st.peek()])
                    st.pop();

                left[i] = st.isEmpty() ? -1:st.peek();
                st.push(i);
            }
        }

        private void nearestSmallerToRight(int[] heights, int[] right, int n) {
            Stack<Integer>st = new Stack<>();
            for(int i=n-1; i>=0; i--) {
                while(!st.isEmpty() && heights[i]<=heights[st.peek()])
                    st.pop();

                right[i] = st.isEmpty() ? n:st.peek();
                st.push(i);
            }
        }
    }

    /*
    * One pass solution:
    * We will insert the index and height pair into the stack.
    * and keep inserting until an index with lesser value is encountered.
    * Once a lesser value is found keep popping out the values in the stack until the height becomes greater than the current value.
    * Also keep calculating the max area.
    * */
    class Solution {
        private class Pair {
            int index;
            int height;
            Pair(int index, int height) {
                this.index = index;
                this.height = height;
            }
        }
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int maxArea = Integer.MIN_VALUE;
            Stack<Pair>st = new Stack<>();
            for(int i=0; i<n; i++) {
                int start = i;
                while(!st.isEmpty() && heights[i]<=st.peek().height) {
                    Pair p = st.pop();
                    int height = p.height;
                    int index = p.index;
                    int width = i-index;

                    maxArea = Math.max(maxArea, width*height);
                    start = index;
                }
                st.push(new Pair(start, heights[i]));
            }

            while(!st.isEmpty()) {
                Pair p = st.pop();
                int height = p.height;
                int index = p.index;
                int width = n-index;

                maxArea = Math.max(maxArea, height*width);
            }

            return maxArea;
        }
    }
}
