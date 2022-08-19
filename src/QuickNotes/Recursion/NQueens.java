package QuickNotes.Recursion;

// https://leetcode.com/problems/n-queens/
// Using recursion and backtracking
// Time Complexity: O(N!*N)

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            char[][] board = new char[n][n];
            List<List<String>> boards = new ArrayList<>();
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    board[i][j] = '.';
                }
            }
            solve(boards, board, 0);
            return boards;
        }


        public void solve(List<List<String>>boards, char[][]board, int row) {
            if(row == board.length) {
                boards.add(getBoard(board));
                return;
            }

            for(int col=0; col<board.length; col++) {
                if(isSafe(board, row, col)) {
                    board[row][col] = 'Q';
                    solve(boards, board, row+1);
                    board[row][col] = '.';
                }
            }
        }

        public boolean isSafe(char[][] board, int row, int col) {
            //to check row and column
            for(int i=0; i<board.length; i++) {
                if(board[i][col]=='Q' || board[row][i]=='Q')
                    return false;
            }

            //to check for upper-right diagonal only since the rows below the current one are not yet processed.
            for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++) {
                if(board[i][j]=='Q')
                    return false;
            }

            //to check for upper-left diagonal only since the rows below the current one are not yet processed.
            for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
                if(board[i][j]=='Q')
                    return false;
            }

            return true;
        }

        public List<String> getBoard(char[][] board) {
            List<String> queens = new ArrayList<>();
            for(int i=0; i<board.length; i++) {
                String row = "";
                for(int j=0; j<board[0].length; j++) {
                    row += board[i][j];
                }
                queens.add(row);
            }
            return queens;
        }
    }
}
