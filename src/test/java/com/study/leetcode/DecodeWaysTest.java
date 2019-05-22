package com.study.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecodeWaysTest {

    private DecodeWays alg = new DecodeWays();

    @Test
    void numDecodings() {
        assertEquals(1, alg.numDecodings("1"));
//        assertEquals(1, alg.numDecodings("110"));
    }

}