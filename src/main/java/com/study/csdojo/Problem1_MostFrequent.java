package com.study.csdojo;

import java.util.HashMap;
import java.util.Map;

public class Problem1_MostFrequent {

    /**
     * Find the most frequent occuring item in an array.
     */
    Integer mostFrequent(int[] array) {
        int maxCount = -1;
        Integer maxItem = null;
        Map<Integer, Integer> count = new HashMap<>();

        for (int i : array) {
            if (count.containsKey(i)) {
                count.put(i, count.get(i) + 1);
            } else {
                count.put(i, 1);
            }
            if (count.get(i) > maxCount) {
                maxCount = count.get(i);
                maxItem = i;
            }
        }
        return maxItem;
    }

}
