package com.skiena.chapter7;

import org.junit.jupiter.api.Test;

class SudokuTest {

    @Test
    void solveEasy() {
        long begin = System.nanoTime();
        new NaiveSudoku().solve(new int[][] {
                {0, 0, 0, 0, 0, 4, 9, 2, 0},
                {4, 0, 3, 0, 5, 2, 0, 0, 0},
                {1, 0, 9, 0, 3, 0, 0, 0, 8},
                {0, 4, 0, 7, 0, 0, 5, 3, 0},
                {0, 3, 7, 0, 0, 1, 0, 0, 0},
                {2, 0, 0, 3, 0, 0, 7, 6, 0},
                {0, 0, 0, 8, 0, 0, 0, 9, 2},
                {5, 1, 0, 0, 0, 9, 0, 0, 0},
                {0, 6, 2, 0, 7, 0, 0, 0, 5}});
        System.out.println((System.nanoTime() - begin) / 1000000);
    }

    @Test
    void solveHard() {
        long begin = System.nanoTime();
        new NaiveSudoku().solve(new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 1, 2},
                {0, 0, 0, 0, 3, 5, 0, 0, 0},
                {0, 0, 0, 6, 0, 0, 0, 7, 0},
                {7, 0, 0, 0, 0, 0, 3, 0, 0},
                {0, 0, 0, 4, 0, 0, 8, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 2, 0, 0, 0, 0},
                {0, 8, 0, 0, 0, 0, 0, 4, 0},
                {0, 5, 0, 0, 0, 0, 6, 0, 0}});
        System.out.println((System.nanoTime() - begin) / 1000000);
    }

}