package com.study;

/**
 * You are given a 2xN grid and infinite dominos of size each 1x2.
 * Find the number of ways in which you can fill this grid using these dominos.
 * Note that you can place the domino only in horizontal or vertical manner.
 *
 * Ways(n) = Ways(n - 1) + Ways(n - 2)
 * Ways(0) = 1
 * Ways(1) = 1
 */
public class Ex7_DominosArrangements {

    int numberOfWays(int n) {
        int first = 1;
        int second = 1;

        int current = (n == 1) ? first : -1;
        for (int i = 2; i <= n; i++) {
            current = first + second;
            first = second;
            second = current;
        }

        return current;
    }

}
