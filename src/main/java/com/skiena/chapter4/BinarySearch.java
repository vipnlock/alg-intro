package com.skiena.chapter4;

public class BinarySearch {

    public static int search(int[] array, int key) {
        return search(array, key, 0, array.length - 1);
    }

    private static int search(int[] array, int key, int start, int end) {
        if (start > end) {
            return -1;  // key not found
        }

        int middle = (start + end) / 2;
        if (key == array[middle]) {
            return middle;
        } else if (key < array[middle]) {
            return search(array, key, start, middle - 1);
        } else {
            return search(array, key, middle + 1, end);
        }
    }

}
