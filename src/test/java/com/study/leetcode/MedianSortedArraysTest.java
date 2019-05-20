package com.study.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianSortedArraysTest {

    private MedianSortedArrays alg = new MedianSortedArrays();

    @Test
    void findMedianSortedArrays() {
        assertEquals(2, alg.findMedianSortedArrays(new int[] {}, new int[] {2}));
        assertEquals(2, alg.findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
        assertEquals(2.5, alg.findMedianSortedArrays(new int[] {1, 3}, new int[] {2, 4}));
        assertEquals(47.5, alg.findMedianSortedArrays(new int[] {10, 20, 30, 40, 50, 60}, new int[] {35, 45, 55, 65, 75, 85}));
    }

}