package com.skiena.chapter4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MergeSortTest {

    @Test
    void sort() {
        int[] array = new int[] {10, 50, 20, 1, 4, 17, 100, 87, 1198, 0, -1};
        System.out.println(Arrays.toString(array));
        MergeSort.sort(array);
        System.out.println(Arrays.toString(array));
    }

}