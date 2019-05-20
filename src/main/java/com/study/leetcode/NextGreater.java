package com.study.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class NextGreater {

//    public static int[] nextBigger(int[] arr) {
//        int n = arr.length;
//        int[] res = new int[n];
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (arr[i] < arr[j]) {
//                    res[i] = j;
//                    break;
//                }
//            }
//        }
//        return res;
//    }
//
//    public static void main(String[] argv) {
//        int[] test = new int[] {1, 10, 3, 2, 1, 7};
//        System.out.println(Arrays.toString(nextBigger(test)));
//    }

    public static int[] nextBigger(int[] arr) {
        int n = arr.length;
        final int[] res = new int[n];
        final LinkedList<Integer> stack = new LinkedList<>();

        stack.push(0);
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                    int index = stack.pop();
                    res[index] = i;
                }
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }

        return res;
    }

    public static void main(String[] argv) {
        // int[] test = new int[] {1, 10, 3, 2, 1, 7};
                            //  0  1  2  3  4  5  6  7  8  9  10
        int[] test = new int[] {1, 6, 3, 5, 4, 7, 6, 8, 7, 6, 5};
                            // {1, 5, 3, 5, 5, 7, 7, -1, -1, -1, -1}
        System.out.println(Arrays.toString(nextBigger(test)));
    }

}
