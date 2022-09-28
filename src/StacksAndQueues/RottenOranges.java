package StacksAndQueues;

// https://leetcode.com/problems/rotting-oranges/

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    class DFSSolution {
        public int orangesRotting(int[][] grid) {
            if(grid==null || grid.length==0)
                return -1;

            int time = 2;
            for(int i=0; i<grid.length; i++) {
                for(int j=0; j<grid[0].length; j++) {
                    if(grid[i][j] == 2)
                        dfs(grid, i, j, 2);
                }
            }

            for(int[] row: grid) {
                for(int val: row) {
                    if(val == 1)
                        return -1;
                    time = Math.max(time, val);
                }
            }

            return time-2;
        }

        private void dfs(int[][] grid, int row, int col, int mins) {
            if(row<0 || row>=grid.length || col<0 || col>=grid[0].length)
                return;

            // case where no oranges are present in the cell.
            if(grid[row][col] == 0)
                return;

            // case where the rotten orange is already visited
            if(1 < grid[row][col] && grid[row][col] < mins)
                return;

            grid[row][col] = mins;
            dfs(grid, row+1, col, mins+1);
            dfs(grid, row-1, col, mins+1);
            dfs(grid, row, col-1, mins+1);
            dfs(grid, row, col+1, mins+1);
        }
    }

    // Using a queue first add all the rotten oranges into the it.
    // Time Complexity: O(N*N)*4
    // Space Complexity: O(N*N)
    class BFSSolution {
        private class Tuple {
            int row;
            int col;
            int time;
            Tuple(int row, int col, int time) {
                this.row = row;
                this.col = col;
                this.time = time;
            }
        }
        public int orangesRotting(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            Queue<Tuple> q = new LinkedList<>();
            boolean[][] vis = new boolean[m][n];
            int fresh = 0;

            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(grid[i][j] == 2) {
                        q.add(new Tuple(i, j, 0));
                        vis[i][j] = true;
                    }

                    if(grid[i][j] == 1)
                        fresh++;
                }
            }


            int total_time = 0;
            int[] drow = {-1, 0, +1, 0};
            int[] dcol = {0, -1, 0, +1};
            int count = 0;
            while(!q.isEmpty()) {
                Tuple t = q.poll();
                int row = t.row;
                int col = t.col;
                int time = t.time;

                total_time = Math.max(total_time, time);

                for(int i=0; i<4; i++) {
                    int nrow = row + drow[i];
                    int ncol = col + dcol[i];
                    if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && !vis[nrow][ncol] && grid[nrow][ncol]==1) {
                        q.add(new Tuple(nrow, ncol, time+1));
                        vis[nrow][ncol] = true;
                        count++;
                    }
                }

            }

            return count==fresh ? total_time:-1;
        }
    }
}
