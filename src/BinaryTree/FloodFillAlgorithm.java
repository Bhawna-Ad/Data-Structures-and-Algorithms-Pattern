package BinaryTree;

// https://leetcode.com/problems/flood-fill/
// Time Complexity: O(N)
// Space Complexity: O(N)

public class FloodFillAlgorithm {
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int color = image[sr][sc];

            if(color == newColor)
                return image;

            dfs(image, sr, sc, color, newColor);
            return image;
        }

        private void dfs(int[][] image, int row, int col, int color, int newColor) {
            if(row<0 || row>=image.length || col<0 || col>=image[0].length)
                return;

            if(image[row][col] != color)
                return;

            image[row][col] = newColor;

            dfs(image, row, col+1, color, newColor);
            dfs(image, row, col-1, color, newColor);
            dfs(image, row+1, col, color, newColor);
            dfs(image, row-1, col, color, newColor);
        }
    }
}
