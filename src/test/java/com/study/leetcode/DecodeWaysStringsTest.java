package com.study.leetcode;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DecodeWaysStringsTest {

    private DecodeWaysStrings alg = new DecodeWaysStrings();

    @Test
    void numDecodings() {
        assertEquals(404, alg.numDecodings("*1*1*0"));
        assertEquals(291868912, alg.numDecodings("*********"));
        assertEquals(11, alg.numDecodings("*1"));
        assertEquals(1, alg.numDecodings("110"));
        assertEquals(104671669, alg.numDecodings("********************"));
    }

}