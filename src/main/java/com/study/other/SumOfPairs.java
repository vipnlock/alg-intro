package com.study.other;

import java.util.Arrays;

public class SumOfPairs {

    public int[] closesSumPair(int[] a1, int[] a2, int target) {
        int[] a1Sorted = Arrays.copyOf(a1, a1.length);
        Arrays.sort(a1Sorted);
        int[] a2Sorted = Arrays.copyOf(a2, a2.length);
        Arrays.sort(a1Sorted);

        int i = 0;
        int j = a2Sorted.length - 1;
        int smallestDiff = Math.abs(a1Sorted[0] + a2Sorted[0] - target);
        int[] closestPair = new int[] {a1Sorted[0], a2Sorted[0]};

        while (i < a1Sorted.length && j >= 0) {
            int diff = a1Sorted[i] + a2Sorted[j] - target;

            if (smallestDiff > Math.abs(diff)) {
                smallestDiff = Math.abs(diff);
                closestPair[0] = a1Sorted[i];
                closestPair[1] = a2Sorted[j];
            }

            if (diff == 0) {
                return new int[] {a1Sorted[i], a2Sorted[j]};
            } else if (diff < 0) {
                i++;
            } else {
                j--;
            }
        }

        return closestPair;
    }

}
