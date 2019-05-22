package com.study.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZigZagConvertionTest {

    private ZigZagConvertion alg = new ZigZagConvertion();

    @Test
    void stringToZigZag() {
        assertEquals("PAHNAPLSIIGYIR", alg.stringToZigZag("PAYPALISHIRING", 3));
        assertEquals("0132", alg.stringToZigZag("0123", 3));
    }

}