package com.study.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrappingRainWaterTest {

    private TrappingRainWater alg = new TrappingRainWater();

    @Test
    void trap() {
        assertEquals(14, alg.trap(new int[]{5, 2, 1, 2, 1, 5}));
        assertEquals(23, alg.trap(new int[]{5, 5, 1, 7, 1, 1, 5, 2, 7, 6}));
    }

}