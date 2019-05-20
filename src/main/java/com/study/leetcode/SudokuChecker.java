package com.study.leetcode;

class SudokuChecker {
    
    public boolean isValidSudoku(char[][] board) {
        boolean valid = true;
        for (int i = 0; i < 9; i++) {
            valid &= checkRow(board, i) && checkColumn(board, i) && checkBox(board, i);
            if (!valid) {
                break;
            }
        }
        return valid;
    }
    
    private boolean checkRow(char[][] board, int i) {
        boolean[] v = new boolean[9];
        for (int j = 0; j < 9; j++) {
            if (board[i][j] == '.') {
                continue;
            }
            if (v[board[i][j] - '0' - 1]) {
                return false;
            } else {
                v[board[i][j] - '0' - 1] = true;
            }
        }
        return true;
    }
    
    private boolean checkColumn(char[][] board, int i) {
        boolean[] v = new boolean[9];
        for (int j = 0; j < 9; j++) {
            if (board[j][i] == '.') {
                continue;
            }
            if (v[board[j][i] - '0' - 1]) {
                return false;
            } else {
                v[board[j][i] - '0' - 1] = true;
            }
        }
        return true;
    }
    
    private boolean checkBox(char[][] board, int i) {
        boolean[] v = new boolean[9];
        for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
            for (int col = (i % 3) * 3; col < (i % 3) * 3 + 3; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                if (v[board[row][col] - '0' - 1]) {
                    return false;
                } else {
                    v[board[row][col] - '0' - 1] = true;
                }   
            }
        }
        return true;
    }
    
}