package com.study.dynamic;

import java.util.Arrays;

/**
 * A burglar has come to your colony at night. Your colony has many houses arranged in linear fashion
 * and each house has some amount of money. The burglar wishes to take as much money as possible.
 * But he can't rob 2 consecutive houses otherwise the security bell will ring and he will get caught.
 * The money in the houses are given in the form of an array named houses.
 */
public class Ex9_BurglarsNightOut {

    int rob(int[] houses) {
        final int n = houses.length;
        if (n == 0) {
            return 0;
        }
        final int[] maxMoney = new int[n + 1];
        maxMoney[n] = 0;
        maxMoney[n - 1] = houses[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            maxMoney[i] = Math.max(houses[i] + maxMoney[i + 2], maxMoney[i + 1]);
        }

        return maxMoney[0];
    }

    int robCircularColony(int[] houses) {
        final int n = houses.length;
        int[] houses1 = Arrays.copyOfRange(houses, 0, n - 1);
        int[] houses2 = Arrays.copyOfRange(houses, 1, n);
        return Math.max(rob(houses1), rob(houses2));
    }

}
