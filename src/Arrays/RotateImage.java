package Arrays;
//https://leetcode.com/problems/rotate-image/
//Time Complexity: O(2*N*M)
//Space Complexity: O(1)
public class RotateImage {
    class Solution {
        public void rotate(int[][] matrix) {
            transpose(matrix);
            for(int[] row: matrix)
                reverse(row);
        }

        private void transpose(int[][] matrix) {
            for(int i=0; i<matrix.length; i++) {
                for(int j=0; j<i; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        private void reverse(int[] row) {
            int start = 0;
            int end = row.length-1;
            while(start < end) {
                int temp = row[start];
                row[start] = row[end];
                row[end] = temp;
                start++;
                end--;
            }
        }
    }
}
