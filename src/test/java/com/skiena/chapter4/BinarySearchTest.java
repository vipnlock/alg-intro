package com.skiena.chapter4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BinarySearchTest {

    @Test
    void search() {
        int[] array = new int[] {10, 50, 20, 1, 4, 17, 100, 87, 1198, 0, -1};
        QuickSort.sort(array);
        System.out.println(Arrays.toString(array));

        System.out.println("Index of -1 is " + BinarySearch.search(array, -1));
        System.out.println("Index of 10 is " + BinarySearch.search(array, 10));
        System.out.println("Index of 1198 is " + BinarySearch.search(array, 1198));
        System.out.println("Index of 21 should be -1: " + BinarySearch.search(array, 21));
    }

}