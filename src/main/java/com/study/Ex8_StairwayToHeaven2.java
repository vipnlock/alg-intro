package com.study;

import java.util.stream.IntStream;

/**
 * You want to reach heaven that is at the top of this staircase.
 * The staircase has n steps.
 * Each staircase has a fee associated with it, given in a fee array.
 * If you pay that fee, you can either take 1 step, 2 steps or 3 steps further.
 * You can only start from the lowermost stair (index 0).
 * What is the lowest fee you need to pay in order to reach heaven (i.e. at stair with index n).
 *
 * MinFee(n) = Min (fee(n-1) + MinFee(n-1), fee(n-2) + MinFee(n-2), fee(n-3) + MinFee(n-3))
 */
public class Ex8_StairwayToHeaven2 {

    int minimumFee(int[] cost) {
        final int n = cost.length;
        final int[] minFee = IntStream.generate(() -> Integer.MAX_VALUE).limit(n + 1).toArray();
        minFee[0] = 0;
        minFee[1] = minFee[2] = cost[0];
        final int[] cameFrom = new int[n + 1];
        cameFrom[0] = -1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= 3; j++) {
                int tmpFrom = i - j;
                if (minFee[i] > cost[tmpFrom] + minFee[tmpFrom]) {
                    minFee[i] = cost[tmpFrom] + minFee[tmpFrom];
                    cameFrom[i] = tmpFrom;
                }
            }
        }

        System.out.println("heaven");
        int indexToPrint = cameFrom[n];
        while (indexToPrint != -1) {
            System.out.println(indexToPrint);
            indexToPrint = cameFrom[indexToPrint];
        }
        return minFee[n];
    }

}
