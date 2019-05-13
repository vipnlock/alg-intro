package com.skiena.chapter4;

import java.util.LinkedList;
import java.util.Queue;

public class MergeSort {

    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int start, int end) {
        if (start == end) {
            return;
        }
        int median = (start + end) / 2;

        sort(array, start, median);
        sort(array, median + 1, end);
        merge(array, start, median, end);
    }

    private static void merge(int[] array, int start, int median, int end) {
        Queue<Integer> arr1 = new LinkedList<>();
        Queue<Integer> arr2 = new LinkedList<>();

        for (int i = start; i <= median; i++) {
            arr1.add(array[i]);
        }
        for (int i = median + 1; i <= end; i++) {
            arr2.add(array[i]);
        }

        int i = start;
        while (!arr1.isEmpty() && !arr2.isEmpty()) {
            if (arr1.peek().compareTo(arr2.peek()) < 0) {
                array[i++] = arr1.poll();
            } else {
                array[i++] = arr2.poll();
            }
        }
        while (!arr1.isEmpty()) {
            array[i++] = arr1.poll();
        }
        while (!arr2.isEmpty()) {
            array[i++] = arr2.poll();
        }
    }

}
