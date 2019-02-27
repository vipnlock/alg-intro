package com.study.csdojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem3_IsRotationTest {

    @Test
    void isRotation() {
        Problem3_IsRotation alg = new Problem3_IsRotation();

        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        int[] array2a = {4, 5, 6, 7, 8, 1, 2, 3};
        assertFalse(alg.isRotation(array1, array2a));
        int[] array2b = {4, 5, 6, 7, 1, 2, 3};
        assertTrue(alg.isRotation(array1, array2b));
        int[] array2c = {4, 5, 6, 9, 1, 2, 3};
        assertFalse(alg.isRotation(array1, array2c));
        int[] array2d = {4, 6, 5, 7, 1, 2, 3};
        assertFalse(alg.isRotation(array1, array2d));
        int[] array2e = {4, 5, 6, 7, 0, 2, 3};
        assertFalse(alg.isRotation(array1, array2e));
        int[] array2f = {1, 2, 3, 4, 5, 6, 7};
        assertTrue(alg.isRotation(array1, array2f));
    }

}