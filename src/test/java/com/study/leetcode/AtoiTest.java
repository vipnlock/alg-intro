package com.study.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtoiTest {

    private Atoi alg = new Atoi();

    @Test
    void myAtoi() {
        assertEquals(10, alg.myAtoi("   10 sf"));
        assertEquals(+10, alg.myAtoi("   +10 sf"));
        assertEquals(-10, alg.myAtoi("   -10 sf"));
        assertEquals(0, alg.myAtoi("   - 10 sf"));
        assertEquals(0, alg.myAtoi("   + 10 sf"));
        assertEquals(1, alg.myAtoi("   +1 0 sf"));
        assertEquals(Integer.MIN_VALUE, alg.myAtoi("   -11111111111111111 sf"));
        assertEquals(Integer.MAX_VALUE, alg.myAtoi("   +11111111111111111 sf"));
    }

}