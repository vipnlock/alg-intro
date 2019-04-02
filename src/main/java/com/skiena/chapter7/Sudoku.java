package com.skiena.chapter7;

import java.util.Arrays;

/**
 * Demonstrates search pruning techniques:
 * - most constrained square selection - prune as much (back off) and as soon as possible.
 * - look ahead
 */
public abstract class Sudoku extends Backtracking<Sudoku.Board> {

    static final int DIMENSION = 9; // 9x9 board
    static final int MAX_NUMBER = 9; // numbers 1 to 9
    private static final int NCELLS = DIMENSION * DIMENSION;    // 81 cells in a 9x9 problem

    public void solve(int[][] board) {
        int[] partialSolution = new int[NCELLS + 1];
        backtrack(partialSolution, 1, new Board(board));
    }

    @Override
    protected boolean isSolution(int[] partialSolution, int stepNr, Board board) {
        return board.freeCount == 0;
    }

    @Override
    protected void processSolution(int[] solution, int stepNr, Board board) {
        printBoard(board);
        finished = true;
    }

    @Override
    protected int[] constructCandidates(int[] partialSolution, int nextStepNr, Board board) {
        /*
         * Partial solution stores contents of a board square (1-9), but not the coordinates of the board square.
         * Thus, we keep a separate array of move positions as part of the Board class.
         */
        final int[] possibleCandidates = new int[DIMENSION + 1];
        int numberOfCandidates = 0;

        // 1 step. nextSquare.
        final Point nextSquare = nextSquare(board);
        if (nextSquare == null) {
            // error condition - no moves possible
            return new int[0];
        }
        board.move[nextStepNr] = nextSquare;

        // 2 step. possibleValues.
        boolean[] possibleValues = possibleValues(board, nextSquare);
        for (int i = 1; i <= MAX_NUMBER; i++) {
            if (possibleValues[i]) {
                possibleCandidates[numberOfCandidates++] = i;
            }
        }

        return Arrays.copyOf(possibleCandidates, numberOfCandidates);
    }

    @Override
    protected void makeMove(int[] partialSolution, int nextStepNr, Board board) {
        board.board[board.move[nextStepNr].row][board.move[nextStepNr].column] = partialSolution[nextStepNr];
        board.freeCount--;
    }

    @Override
    protected void unmakeMove(int[] partialSolution, int nextStepNr, Board board) {
        board.board[board.move[nextStepNr].row][board.move[nextStepNr].column] = 0;
        board.freeCount++;
    }

    /**
     * Picks the open square we want to fill:
     *       a. arbitrary square selection.
     *       b. most constrained square selection - is much, much better.
     */
    protected abstract Point nextSquare(Board board);

    /**
     * identifies, which numbers are candidates to fill this square.
     *       a. local count - allow all numbers 1 to 9 that have not appeared in the given row, column or sector.
     *       b. look ahead - what if current partial solution has some other open square, where there are no
     *                       candidates remaining under the local count criteria.
     */
    protected abstract boolean[] possibleValues(Board board, Point targetSquare);

    private void printBoard(Board board) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < DIMENSION; row++) {
            String prefix = "";
            for (int column = 0; column < DIMENSION; column++) {
                sb.append(prefix)
                  .append(board.board[row][column]);
                prefix = ",\t";
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }


    static class Point {
        int row;
        int column;

        Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    static class Board {
        /**
         * matrix of board contents
         */
        final int board[][];

        /**
         * how many open squares remain?
         */
        int freeCount = 0;

        /**
         * how did we fill the squares?
         * positions of the filled squares in the partial solution vector.
         */
        Point[] move = new Point[NCELLS + 1];

        Board(int[][] board) {
            this.board = board;
            for (int row = 0; row < DIMENSION; row++) {
                for (int column = 0; column < DIMENSION; column++) {
                    if (board[row][column] == 0) {
                        freeCount++;
                    }
                }
            }
        }
    }

}
