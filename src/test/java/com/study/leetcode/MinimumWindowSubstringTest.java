package com.study.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumWindowSubstringTest {

    private MinimumWindowSubstring alg = new MinimumWindowSubstring();

    @Test
    void minWindow() {
        assertEquals("A", alg.minWindow("AA", "A"));
        assertEquals("AA", alg.minWindow("AA", "AA"));
        assertEquals("", alg.minWindow("A", "AA"));
        assertEquals("BANC", alg.minWindow("ADOBECODEBANC", "ABC"));

    }

}