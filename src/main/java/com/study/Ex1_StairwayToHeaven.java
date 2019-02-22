package com.study;

/**
 * You want to reach heaven that is on the top of this staircase.
 * The staircase has n steps.
 * At each step you can climb either 1 step or 2 steps further.
 * In how many ways we can reach heaven?
 *
 * ways(n) = ways(n - 2) + ways(n - 1)
 */
public class Ex1_StairwayToHeaven {

    int stairwayToHeaven(int n) {
        int[] ways = new int[n + 1];
        ways[0] = 1;
        ways[1] = 1;

        for (int i = 2; i <= n; i++) {
            ways[i] = ways[i - 2] + ways[i - 1];
        }

        return ways[n];
    }

}
