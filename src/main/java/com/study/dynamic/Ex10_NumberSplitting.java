package com.study.dynamic;

import java.util.stream.IntStream;

/**
 * You are being given a positive integer N.
 * You need to split this integer into sum of at least of 2 positive integers in such a way
 * that the splitted integers when multiplied form the maximum product among all combinations
 * possible.
 */
public class Ex10_NumberSplitting {

    int split(int n) {
        final int[] maxProduct = IntStream.generate(() -> -1).limit(n + 1).toArray();
        maxProduct[0] = 0;
        maxProduct[1] = maxProduct[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                maxProduct[i] = Math.max(maxProduct[i], (i - j) * maxProduct[j]);
                maxProduct[i] = Math.max(maxProduct[i], (i - j) * j);
            }
        }

        return maxProduct[n];
    }

    public static void main(String[] argv) {
        for (int i = 2; i <= 20; i++) {
            System.out.println(i + ". " + new Ex10_NumberSplitting().split(i));
        }
    }

}
