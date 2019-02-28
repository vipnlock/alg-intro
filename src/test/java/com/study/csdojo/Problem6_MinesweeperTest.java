package com.study.csdojo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Problem6_MinesweeperTest {

    @Test
    void mineSweeper() {
        Problem6_Minesweeper alg = new Problem6_Minesweeper();

        int[][] bombs1 = {{0, 2}, {2, 0}};
        System.out.println(Arrays.deepToString(alg.mineSweeper(bombs1, 3, 3)));
        // should return:
        // [[0, 1, -1],
        //  [1, 2, 1],
        //  [-1, 1, 0]]

        int[][] bombs2 = {{0, 0}, {0, 1}, {1, 2}};
        System.out.println(Arrays.deepToString(alg.mineSweeper(bombs2, 3, 4)));
        // should return:
        // [[-1, -1, 2, 1],
        //  [2, 3, -1, 1],
        //  [0, 1, 1, 1]]

        int[][] bombs3 = {{1, 1}, {1, 2}, {2, 2}, {4, 3}};
        System.out.println(Arrays.deepToString(alg.mineSweeper(bombs3, 5, 5)));
        // should return:
        // [[1, 2, 2, 1, 0],
        //  [1, -1, -1, 2, 0],
        //  [1, 3, -1, 2, 0],
        //  [0, 1, 2, 2, 1],
        //  [0, 0, 1, -1, 1]]
    }

}