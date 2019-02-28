package com.study.csdojo;

public class Problem6_Minesweeper {

    int[][] mineSweeper(int[][] bombs, int numRows, int numCols) {
        int[][] field = new int[numRows][numCols];
        for (int[] bomb : bombs) {
            field[bomb[0]][bomb[1]] = -1;

            for (int i = 0; i < 3; i++) {
                int ir = bomb[0] -1 + i;
                if (ir >= 0 && ir < numRows) {
                    for (int j = 0; j < 3; j++) {
                        int jr = bomb[1] - 1 + j;
                        if (jr >= 0 && jr < numCols && field[ir][jr] != -1) {
                            field[ir][jr]++;
                        }
                    }
                }
            }
        }
        return field;
    }

}
