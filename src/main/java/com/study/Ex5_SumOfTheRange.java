package com.study;

/**
 * You are being given an integer array named myArray.
 * You need to find the sum of elements between indices i and j (i <= j), inclusive.
 * Note that there are many such queries that you need to answer.
 *
 * SumRange(i, j) = SumRange(0, i) - SumRange(0, j)
 * SumRange(0, n) = SumRange(0, n-1) + myArray(n)
 */
public class Ex5_SumOfTheRange {

    private int[] sumUntil;

    void preprocessing(int[] myArray) {
        sumUntil = new int[myArray.length];
        sumUntil[0] = myArray[0];

        for (int i = 1; i < myArray.length; i++) {
            sumUntil[i] = sumUntil[i - 1] + myArray[i];
        }
    }

    int sumRange(int i, int j) {
        if (i == 0) {
            return sumUntil[j];
        } else {
            return sumUntil[j] - sumUntil[i - 1];
        }
    }

}
