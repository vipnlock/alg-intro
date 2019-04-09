package com.skiena.chapter8;

public class BinomialCoef {

    private static final int MAXN = 100;

    public long binomialCoefficient(int n, int k) {
        final long bc[][] = new long[MAXN][MAXN];   // table of binomial coefficient

        for (int i = 0; i < MAXN; i++) {
            bc[i][0] = 1;
            bc[i][i] = 1;
        }

        for (int i = 1; i < MAXN; i++) {
            for (int j = 1; j < i; j++) {
                bc[i][j] = bc[i - 1][j - 1] + bc[i - 1][j];
            }
        }
        return bc[n][k];
    }

}
