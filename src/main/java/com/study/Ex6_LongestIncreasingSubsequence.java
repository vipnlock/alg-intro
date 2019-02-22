package com.study;

import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * You are being given an array named nums.
 * You need to find the longest forming increasing sub-sequence from it.
 * Longest increasing sub-sequence is the longest sub-sequence such that all elements
 * of the sub-sequence are sorted in increasing order.
 *
 * LIS(i) = 1 + max_(j < i && nums[j] < nums[i])(LIS(j))
 */
class Ex6_LongestIncreasingSubsequence {

    int longestIncSubseq(int[] nums) {
        final int n = nums.length;
        final int[] lis = IntStream.generate(() -> 1).limit(n).toArray();

        int globalMax = -1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
            if (globalMax < lis[i]) {
                globalMax = lis[i];
            }
        }

        return globalMax;
    }

    int longestIncSubseqAndPrint(int[] nums) {
        final int n = nums.length;
        final int[] lis = IntStream.generate(() -> 1).limit(n).toArray();
        final int[] achievedBy = new int[n];

        int globalMax = -1;
        int index = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    achievedBy[i] = j;
                }
            }
            if (globalMax < lis[i]) {
                globalMax = lis[i];
                index = i;
            }
        }

        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(index);
        while (index != achievedBy[index]) {
            index = achievedBy[index];
            stack.push(index);
        }

        while (!stack.isEmpty()) {
            System.out.println(nums[stack.pop()]);
        }
        return globalMax;
    }

}
