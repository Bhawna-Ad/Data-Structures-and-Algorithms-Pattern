package Recursion;

// https://leetcode.com/problems/n-queens/

import java.util.ArrayList;
import java.util.List;

public class NQueensProblem {
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            char[][] board = new char[n][n];
            List<List<String>> boards = new ArrayList<>();
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    board[i][j] = '.';
                }
            }
            solve(board, 0, boards);
            return boards;
        }

        private void solve(char[][] board, int row, List<List<String>> boards) {
            if(row == board.length) {
                boards.add(getBoard(board));
                return;
            }

            for(int col=0; col<board.length; col++) {
                if(isSafe(board, row, col)) {
                    board[row][col] = 'Q';
                    solve(board, row+1, boards);
                    board[row][col] = '.';
                }
            }
        }

        private boolean isSafe(char[][] board, int row, int col) {
            for(int i=0; i<board.length; i++) {
                if(board[i][col]=='Q' || board[row][i]=='Q')
                    return false;
            }

            for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++) {
                if(board[i][j] == 'Q')
                    return false;
            }

            for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
                if(board[i][j] == 'Q')
                    return false;
            }

            return true;
        }

        private List<String> getBoard(char[][] board) {
            List<String> ans = new ArrayList<>();

            for(char[] row: board) {
                String s = "";
                for(char ch: row) {
                    s += ch;
                }
                ans.add(s);
            }

            return ans;
        }
    }
}
