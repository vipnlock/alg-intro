package com.study.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideTwoIntegersTest {

    @Test
    void divide() {
        DivideTwoIntegers alg = new DivideTwoIntegers();
//        assertEquals(Integer.MIN_VALUE / 2, alg.divide(Integer.MIN_VALUE, 2));
        assertEquals(1004958205 / -2137325331, alg.divide(1004958205, -2137325331));
    }

}