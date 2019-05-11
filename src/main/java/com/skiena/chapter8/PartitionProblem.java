package com.skiena.chapter8;

public class PartitionProblem {

    /*
     * Split bunch of tasks (books) into k parts (CPUs)
     * s[0] is always a fake element. first element of the array is a[1].
     */
    public void partition(int s[], int k) {
        int n = s.length - 1;

        int[][] m = new int[n + 1][k + 1];  // DP table for values
        int[][] d = new int[n + 1][k + 1];  // DP table for dividers
        int[] p = new int[n + 1];               // prefix sums array

        // construct prefix sums
        p[0] = 0;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] + s[i];
        }

        // initialize boundaries
        for (int i = 1; i <= n; i++) {
            m[i][1] = p[i];
        }
        for (int j = 1; j <= k; j++) {
            m[1][j] = s[1];
        }

        // evaluate main recurrence
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                m[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= i - 1; x++) {
                    int cost = Math.max(m[x][j - 1], p[i] - p[x]);
                    if (m[i][j] > cost) {
                        m[i][j] = cost; // whenever we update the cost,
                        d[i][j] = x;    // we record which divider position was required to achieve that value.
                    }
                }
            }
        }

        reconstructPartition(s, d, n, k);
    }

    private void reconstructPartition(int s[], int[][] d, int n, int k) {
        if (k == 1) {
            printBooks(s, 1, n);
        } else {
            reconstructPartition(s, d, d[n][k], k - 1);
            printBooks(s, d[n][k] + 1, n);
        }
    }

    private void printBooks(int[] s, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println();
    }

}
