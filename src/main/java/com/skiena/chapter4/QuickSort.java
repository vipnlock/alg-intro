package com.skiena.chapter4;

public class QuickSort {

    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int median = partition(array, start, end);
        sort(array, start, median - 1);
        sort(array, median + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int p = end;
        int firstHigh = start;

        for (int i = start; i < end; i++) {
            if (array[i] < array[p]) {
                swap(array, i, firstHigh);
                firstHigh++;
            }
        }
        swap(array, firstHigh, p);
        return firstHigh;
    }

    private static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

}
