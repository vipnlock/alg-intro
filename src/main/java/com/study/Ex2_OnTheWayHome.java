package com.study;

/**
 * You are located in the top-left corner of a m x n grid.
 * |=|-|-| m = 4
 * |-|-|-| n = 3
 * |-|-|-|
 * |-|-|^|
 * You can only move either right or down at any point in time.
 * Your home is located in the bottom-right corner of this grid.
 * In how many unique ways you can reach your home?
 *
 * numWays[i, j] = numWays[i + 1, j] + numWays[i, j + 1]
 * Base cases:
 * - Number of ways to reach bottom right corner from last column of grid is 1: numWays[i, n] = 1
 * - Number of ways to reach bottom right corner from last row of grid is 1: numWays[m, j] = 1
 */
public class Ex2_OnTheWayHome {

    int numWays(int m, int n) {
        int[][] ways = new int[m][n];
        // Base cases:
        for (int i = 0; i < m; i++) {
            ways[i][n - 1] = 1;
        }
        for (int j = 0; j < n; j++) {
            ways[m - 1][j] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                ways[i][j] = ways[i + 1][j] + ways[i][j + 1];
            }
        }

        return ways[0][0];
    }

}
