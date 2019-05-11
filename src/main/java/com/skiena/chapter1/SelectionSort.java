package com.skiena.chapter1;

import java.util.Arrays;

public class SelectionSort {

    void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] argv) {
        int[] arr = new int[] {1,3,2,6,4,7,5,9,8};
        new SelectionSort().selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr));
        }
    }

}
