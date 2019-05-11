package com.skiena.chapter1;

import java.util.Arrays;

public class InsertionSort {

    void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                swap(arr, j - 1, j);
                j--;
            }
        }
    }

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] argv) {
        int[] arr = new int[] {1,3,2,6,4,7,5,9,8};
        new InsertionSort().insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr));
        }
    }

}
