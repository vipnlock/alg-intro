package com.study.csdojo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Problem2_CommonElementsTest {

    @Test
    void commonElements() {
        Problem2_CommonElements alg = new Problem2_CommonElements();

        int[] array1A = {1, 3, 4, 6, 7, 9};
        int[] array2A = {1, 2, 4, 5, 9, 10};
        System.out.println(Arrays.toString(alg.commonElements(array1A, array2A)) + " should return [1, 4, 9] (an array).");

        int[] array1B = {1, 2, 9, 10, 11, 12};
        int[] array2B = {0, 1, 2, 3, 4, 5, 8, 9, 10, 12, 14, 15};
        System.out.println(Arrays.toString(alg.commonElements(array1B, array2B)) + " should return [1, 2, 9, 10, 12] (an array).");

        int[] array1C = {0, 1, 2, 3, 4, 5};
        int[] array2C = {6, 7, 8, 9, 10, 11};
        System.out.println(Arrays.toString(alg.commonElements(array1C, array2C)) + " should return [] (an empty array).");
    }

    @Test
    void myCommonElements() {
        Problem2_CommonElements alg = new Problem2_CommonElements();

        int[] array1A = {1, 3, 4, 6, 7, 9};
        int[] array2A = {1, 2, 4, 5, 9, 10};
        System.out.println(Arrays.toString(alg.myCommonElements(array1A, array2A)) + " should return [1, 4, 9] (an array).");

        int[] array1B = {1, 2, 9, 10, 11, 12};
        int[] array2B = {0, 1, 2, 3, 4, 5, 8, 9, 10, 12, 14, 15};
        System.out.println(Arrays.toString(alg.myCommonElements(array1B, array2B)) + " should return [1, 2, 9, 10, 12] (an array).");

        int[] array1C = {0, 1, 2, 3, 4, 5};
        int[] array2C = {6, 7, 8, 9, 10, 11};
        System.out.println(Arrays.toString(alg.myCommonElements(array1C, array2C)) + " should return [] (an empty array).");
    }

}