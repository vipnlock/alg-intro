package com.study.leetcode.structure;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SuffixArrayTest {

    @Test
    void build() {
        SuffixArray sa = new SuffixArray("abcabc", "rabacabdon");
        assertTrue(sa.search("abc"));
        assertTrue(sa.search("c"));
//        assertFalse(sa.search("d"));

        sa.print();
        System.out.println("Longest Common Substring: " + sa.longestCommonSubstring());
    }

}