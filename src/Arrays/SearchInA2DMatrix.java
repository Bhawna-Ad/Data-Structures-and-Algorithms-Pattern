package Arrays;

// https://leetcode.com/problems/search-a-2d-matrix/
// Time Complexity: O(logN)
// Space Complexity: O(1)

public class SearchInA2DMatrix {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix[0].length;
            int n = matrix.length;
            int start = 0;
            int end = (m * n) - 1;

            while(start <= end) {
                int mid = start + (end - start)/2;
                if(matrix[mid/m][mid%m] == target)
                    return true;
                if(matrix[mid/m][mid%m] < target)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
            return false;
        }
    }
}

/*
* mid/m will give the row and mid%m will give the column of the corresponding row hence %m.
* */
