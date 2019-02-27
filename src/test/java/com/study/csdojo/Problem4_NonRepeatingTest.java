package com.study.csdojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem4_NonRepeatingTest {

    @Test
    void nonRepeating() {
        Problem4_NonRepeating alg = new Problem4_NonRepeating();
        assertEquals(Character.valueOf('c'), alg.nonRepeating("abcab"));
        assertNull(alg.nonRepeating("abab"));
        assertEquals(Character.valueOf('c'), alg.nonRepeating("aabbbc"));
        assertEquals(Character.valueOf('d'), alg.nonRepeating("aabbdbc"));
    }

}