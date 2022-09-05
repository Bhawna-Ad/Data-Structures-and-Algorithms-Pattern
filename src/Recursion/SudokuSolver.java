package Recursion;

// https://leetcode.com/problems/sudoku-solver/

public class SudokuSolver {
    class Solution {
        public void solveSudoku(char[][] board) {
            solve(board);
        }

        private boolean solve(char[][] board) {
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    if(board[i][j] == '.') {
                        for(char val='1'; val<='9'; val++) {
                            if(isValid(board, i, j, val)) {
                                board[i][j] = val;
                                if(solve(board))
                                    return true;
                                board[i][j] = '.';
                            }
                        }
                        return false;
                    }
                }
            }

            return true;
        }

        private boolean isValid(char[][] board, int row, int col, char ch) {
            for(int i=0; i<board.length; i++) {
                if(board[i][col]==ch || board[row][i]==ch)
                    return false;
            }

            int startRow = row - (row%3);
            int startCol = col - (col%3);

            for(int i=startRow; i<startRow+3; i++) {
                for(int j=startCol; j<startCol+3; j++) {
                    if(board[i][j] == ch)
                        return false;
                }
            }

            return true;
        }
    }
}
