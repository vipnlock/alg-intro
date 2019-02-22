package com.study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * We are gived a rod of length n and an array of prices.
 * This arrays contains prices of smaller pieces of that rod when sold.
 * Find the maximum value that could be earned by cutting up the rod and selling the pieces.
 *
 * rod(n) = max_(i = 0..n)(cost(i) + rod(n - i))
 */
public class Ex3_RodCutter {

    int rodCutter(int[] cost, int n) {
        // Initializing rod array
        int[] rod = new int[n + 1];
        rod[0] = 0;

        Set<List<Integer>>[] best = new Set[n + 1];
        for (int i = 0; i < n + 1; i++) {
            best[i] = new HashSet();
        }

        // Loop for each rod length 'i'
        for (int i = 1; i < n + 1; i++) {
            int maxPrice = -1;

            // Loop for smaller cut lengths 'j'
            for (int j = 1; j < i + 1; j++) {
                maxPrice = Math.max(maxPrice, cost[j] + rod[i - j]);

                if (maxPrice == cost[j] + rod[i - j]) {
                    if (best[i - j].isEmpty()) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(j);
                        best[i].add(tmp);
                    } else {
                        for (List<Integer> set : best[i - j]) {
                            List<Integer> tmp = new ArrayList<>(set);
                            tmp.add(j);
                            Collections.sort(tmp);
                            best[i].add(tmp);
                        }
                    }
                }
            }
            rod[i] = maxPrice;
        }

        System.out.println("Result: " + best[n]);
        return rod[n];
    }

}
