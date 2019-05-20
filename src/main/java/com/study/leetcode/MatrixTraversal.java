package com.study.leetcode;

public class MatrixTraversal {

    public void lrUpwards(int[][] m) {
        int rows = m.length;
        int cols = m[0].length;

        int lines = rows + cols - 1;

        for (int line = 1; line <= lines; line++) {
            int startColumn = Math.max(line - rows, 0);

            int chCount = Math.min(line, cols - startColumn);
            chCount = Math.min(chCount, rows);

            for (int j = 0; j < chCount; j++) {
                System.out.print(m[Math.min(line, rows) - 1 - j][startColumn + j] + " ");
            }
            System.out.println();
        }
    }

    public void rlDownFromTopLeft(int [][] m) {
        int rows = m.length;
        int cols = m[0].length;

        for (int k = 0; k < cols; k++) {
            int i = 0;
            int j = k;
            while (isValid(i, j, rows, cols)) {
                System.out.print(m[i][j] + " ");
                i++;
                j--;
            }
            System.out.println();
        }

        for (int k = 1; k < rows; k++) {
            int i = k;
            int j = cols - 1;
            while (isValid(i, j, rows, cols)) {
                System.out.print(m[i][j] + " ");
                i++;
                j--;
            }
            System.out.println();
        }
    }

    public void lrDownFromTopRight(int[][] m) {
        int rows = m.length;
        int cols = m[0].length;

        for (int k = cols - 1; k >= 0; k--) {
            int i = 0;
            int j = k;
            while (isValid(i, j, rows, cols)) {
                System.out.print(m[i][j] + " ");
                i++;
                j++;
            }
            System.out.println();
        }

        for (int k = 1; k < rows; k++) {
            int i = k;
            int j = 0;
            while (isValid(i, j, rows, cols)) {
                System.out.print(m[i][j] + " ");
                i++;
                j++;
            }
            System.out.println();
        }
    }

    public void spiral(int[][] m) {
        int rows = m.length;
        int cols = m[0].length;

        int L = 0;
        int R = cols;
        int U = 0;
        int B = rows;

        int i = L;
        int j = U;
        //  1  |  0 dx
        //  0  |  1 dy
        // --------
        //  0  | -1 dx
        //  -1 |  0 dy
//        int dx = 1;
//        int dy = 0;
//        int upper = R;
//        int
        while (L < R && U < B) {
            while (j < R) {
                System.out.print(m[i][j] + " ");
                j++;
            }
            i++;
            j--;
            U++;
            while (i < B) {
                System.out.print(m[i][j] + " ");
                i++;
            }
            j--;
            i--;
            R--;
            if (U < B) {
                while (j >= L) {
                    System.out.print(m[i][j] + " ");
                    j--;
                }
                i--;
                j++;
                B--;
            }
            if (L < R) {
                while (i >= U) {
                    System.out.print(m[i][j] + " ");
                    i--;
                }
                j++;
                i++;
                L++;
            }
        }
    }

    public void zigzag(int[][] m) {
        int rows = m.length;
        int cols = m[0].length;

        int j = 0;
        for (int i = 0; i < rows; i++) {
            int dj = i % 2 == 0 ? 1 : -1;
            while (j >= 0 && j < cols) {
                System.out.print(m[i][j] + " ");
                j += dj;
            }
            j -= dj;
            System.out.println();
        }
    }

    private static boolean isValid(int i, int j, int rows, int cols) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

}
