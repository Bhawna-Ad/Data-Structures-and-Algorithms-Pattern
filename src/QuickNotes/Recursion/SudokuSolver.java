package QuickNotes.Recursion;

// https://leetcode.com/problems/sudoku-solver/
// Time Complexity: O(9^(n^2))

public class SudokuSolver {
    class Solution {
        public void solveSudoku(char[][] board) {
            solve(board);
        }

        public boolean isSafe(char[][] board, int row, int col, char num) {
            for(int i=0; i<board.length; i++) {
                if(board[row][i]==num || board[i][col]==num)
                    return false;
            }

            // go this many rows up to get the coordinates of the starting cell of the 3X3 matrix
            // Eg: if we are at 3rd row we have to go 3%3=0 rows up.
            // at 4th row we have to go 4%3=1 row up.
            // at 5th row we have to go 5%3=2 rows up.
            // same for the column.
            int startRow = row - (row % 3);
            int startCol = col - (col % 3);

            for(int i=startRow; i<startRow+3; i++) {
                for(int j=startCol; j<startCol+3; j++) {
                    if(board[i][j] == num)
                        return false;
                }
            }

            return true;
        }

        public boolean solve(char[][] board) {
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    if(board[i][j] == '.') {
                        for(char val=1; val<=9; val++) {
                            if(isSafe(board, i, j, val)) {
                                board[i][j] = val;
                                if(solve(board)) {
                                    return true;
                                }
                                board[i][j] = '.';
                            }
                        }

                        // if none of the values are valid to put in the given index stop the iteration
                        // and try with next possible board.
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
