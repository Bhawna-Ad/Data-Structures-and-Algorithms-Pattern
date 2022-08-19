package QuickNotes.Recursion;

import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
// Time Complexity: O(4^(m*n))

public class RatInAMaze {

    class Solution {
        public static ArrayList<String> findPath(int[][] m, int n) {
            // Your code here
            ArrayList<String>ways = new ArrayList<>();
            boolean[][] vis = new boolean[n][n];
            getPaths(m, n, ways, "", 0, 0, vis);
            return ways;
        }

        public static void getPaths(int[][]m, int n, ArrayList<String> ways, String path, int row, int col, boolean[][]vis) {
            if(m[row][col]==0) {
                return;
            }

            if(row==n-1 && col==n-1) {
                ways.add(path);
                return;
            }

            vis[row][col] = true;
            //move up
            if(row > 0 && !vis[row-1][col]) {
                getPaths(m, n, ways, path+'U', row-1, col, vis);
            }

            //move down
            if(row < m.length-1 && !vis[row+1][col]) {
                getPaths(m, n, ways, path+'D', row+1, col, vis);
            }

            //move left
            if(col > 0 && !vis[row][col-1]) {
                getPaths(m, n, ways, path+'L', row, col-1, vis);
            }

            //move right
            if(col < m[0].length-1 && !vis[row][col+1]) {
                getPaths(m, n, ways, path+'R', row, col+1, vis);
            }

            vis[row][col] = false;
        }
    }
}
