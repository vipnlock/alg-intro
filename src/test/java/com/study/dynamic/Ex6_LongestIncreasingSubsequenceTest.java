package com.study.dynamic;

import com.study.dynamic.Ex6_LongestIncreasingSubsequence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex6_LongestIncreasingSubsequenceTest {

    @Test
    void calculate() {
        assertEquals(5, new Ex6_LongestIncreasingSubsequence().longestIncSubseq(new int[] {11, 23, 10, 37, 21, 50, 80}));
    }

    @Test
    void calculateAndPring() {
        assertEquals(5, new Ex6_LongestIncreasingSubsequence().longestIncSubseqAndPrint(new int[] {11, 23, 10, 37, 21, 50, 80}));
    }

}