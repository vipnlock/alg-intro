package com.study.leetcode;

public class MatrixRotation {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int n = matrix.length;

        // 1 2 3
        // 4 5 6
        // 7 8 9
        for (int i = 0; i < n / 2; i++) {
            for (int j = i + 1; j <= n - 1 - i; j++) {
                int r = i;
                int c = j;
                int tmp = matrix[r][c];
                for (int k = 0; k < 3; k++) {
                    int fromR = n - 1 - c;
                    int fromC = r;
                    matrix[r][c] = matrix[fromR][fromC];
                    r = fromR;
                    c = fromC;
                }
                matrix[r][c] = tmp;
            }
        }
    }

}
