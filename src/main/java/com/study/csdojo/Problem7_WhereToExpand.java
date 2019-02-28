package com.study.csdojo;

import java.util.LinkedList;

public class Problem7_WhereToExpand {

    int[][] click(int[][] field, int numRows, int numCols, int givenI, int givenJ) {
        if (field[givenI][givenJ] != 0) {
            return field;
        }
        LinkedList<int[]> queue = new LinkedList<>();
        queue.push(new int[] {givenI, givenJ});
        while (!queue.isEmpty()) {
            int[] pos = queue.pop();
            field[pos[0]][pos[1]] = -2;
            for (int i = pos[0] - 1; i < pos[0] + 2; i++) {
                for (int j = pos[1] - 1; j < pos[1] + 2; j++) {
                    if (i >= 0 && i < numRows && j >= 0 && j < numCols && field[i][j] == 0) {
                        field[i][j] = -2;
                        queue.push(new int[] {i, j});
                    }
                }
            }
        }
        return field;
    }

}
