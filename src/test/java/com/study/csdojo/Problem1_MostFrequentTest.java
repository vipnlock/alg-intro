package com.study.csdojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem1_MostFrequentTest {

    @Test
    void mostFrequent() {
        Problem1_MostFrequent alg = new Problem1_MostFrequent();
        assertEquals(Integer.valueOf(1), alg.mostFrequent(new int[] {1, 3, 1, 3, 2, 1}));
        assertEquals(Integer.valueOf(3), alg.mostFrequent(new int[] {3, 3, 1, 3, 2, 1}));
        assertNull(alg.mostFrequent(new int[] {}));
        assertEquals(Integer.valueOf(0), alg.mostFrequent(new int[] {0}));
        assertEquals(Integer.valueOf(-1), alg.mostFrequent(new int[] {0, -1, 10, 10, -1, 10, -1, -1, -1, 1}));
    }

}