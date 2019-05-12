package com.skiena.chapter3;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class IntegerMinHeapTest {

    @Test
    void heapSort() {
        int[] array = new int[] {10, 50, 20, 1, 4, 17, 100, 87, 1198, 0, -1};
        System.out.println(Arrays.toString(array));
        IntegerMinHeap.heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    void compare() {
        IntegerMinHeap heap = IntegerMinHeap.makeHeapFaster(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(heap.compare(5, 10) + " should be 0");
        System.out.println(heap.compare(5, 4) + " should be 2");
    }

}