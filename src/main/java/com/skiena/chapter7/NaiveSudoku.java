package com.skiena.chapter7;

public class NaiveSudoku extends Sudoku {

    @Override
    protected Sudoku.Point nextSquare(Board board) {
        for (int row = 0; row < DIMENSION; row++) {
            for (int column = 0; column < DIMENSION; column++) {
                if (board.board[row][column] == 0) {
                    return new Point(row, column);
                }
            }
        }
        return null;
    }

    @Override
    protected boolean[] possibleValues(Board board, Sudoku.Point targetSquare) {
        boolean[] result = new boolean[MAX_NUMBER + 1];
        for (int i = 0; i <= MAX_NUMBER; i++) {
            result[i] = true;
        }

        for (int i = 0; i < DIMENSION; i++) {
            result[board.board[targetSquare.row][i]] = false;
            result[board.board[i][targetSquare.column]] = false;
        }

        int bigSqRow = targetSquare.row / 3;
        int bigSqColumn = targetSquare.column / 3;

        for (int row = bigSqRow * 3; row < bigSqRow * 3 + 3; row++) {
            for (int column = bigSqColumn * 3; column < bigSqColumn * 3 + 3; column++) {
                result[board.board[row][column]] = false;
            }
        }

        return result;
    }

}
