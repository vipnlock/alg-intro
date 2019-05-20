package com.study.leetcode;

class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        } else if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) {
            return 1;
        } else if (divisor == Integer.MIN_VALUE) {
            return 0;
        } else if (divisor == 1) {
            return dividend;
        } else if (divisor == -1) {
            return -dividend;
        } else if (dividend == 0) {
            return 0;
        }

        int abs1 = (dividend > 0) ? -dividend : dividend;
        int abs2 = Math.abs(divisor);
        int counter = -1;
        while (abs1 <= 0) {
            int tmpAbs2 = abs2;
            int tmpCounter = 1;
            if (tmpAbs2 < Integer.MAX_VALUE >> 1) {
                while (abs1 + tmpAbs2 + tmpAbs2 < 0) {
                    tmpAbs2 += tmpAbs2;
                    tmpCounter += tmpCounter;
                }
            }
            if (tmpAbs2 != abs2) {
                counter += tmpCounter;
                abs1 += tmpAbs2;
            }
            abs1 += abs2;
            counter++;
        }
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            return -counter;
        } else {
            return counter;
        }
    }
}