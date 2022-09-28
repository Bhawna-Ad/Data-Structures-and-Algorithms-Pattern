package StacksAndQueues;

// https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1

import java.util.Stack;

public class CelebrityProblem {
    public int findCelebrity(int[][] grid) {
        Stack<Integer>st = new Stack<>();
        // first insert all the elements into the stack.
        for(int i=0; i<grid.length; i++)
            st.push(i);

        // now each time take out two elements and check if either of them knows the other.
        while(st.size() > 1) {
            int i = st.pop();
            int j = st.pop();

            // if i knows j, then j can be a celebrity.
            if(grid[i][j] == 1)
                st.push(j);

            // if j knows i, then i can be a celebrity.
            else
                st.push(i);
        }

        // the last element left in the stack will be the potential celebrity.
        int potential_celebrity = st.pop();

        // to make the final check in the row and column of the potential celebrity.
        for(int i=0; i<grid.length; i++) {
            // if i doesnt know the potential celebrity then it is not a celebrity.
            // if potential celebrity knows i then it is not a celebrity.
            if(i != potential_celebrity) {
                if(grid[i][potential_celebrity] == 0 || grid[potential_celebrity][i]==1)
                    return -1;
            }
        }

        return potential_celebrity;
    }
}
