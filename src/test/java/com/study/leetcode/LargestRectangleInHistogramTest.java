package com.study.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestRectangleInHistogramTest {

    private LargestRectangleInHistogram alg = new LargestRectangleInHistogram();

    @Test
    void largestRectangleArea() {
        assertEquals(10, alg.largestRectangleAreaMy(new int[]{2, 1, 5, 6, 2, 3}));
//        assertEquals(2, alg.largestRectangleArea(new int[]{2, 0, 2}));
//        assertEquals(9, alg.largestRectangleArea(new int[]{1, 2, 3, 4, 5}));
    }

}