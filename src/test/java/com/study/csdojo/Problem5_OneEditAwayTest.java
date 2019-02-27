package com.study.csdojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem5_OneEditAwayTest {

    @Test
    void isOneAway() {
        Problem5_OneEditAway alg = new Problem5_OneEditAway();
        assertFalse(alg.isOneAway("abcde", "abme"));
        assertTrue(alg.isOneAway("abcde", "abcd"));
        assertTrue(alg.isOneAway("abde", "abcde"));
        assertTrue(alg.isOneAway("a", "a"));
        assertTrue(alg.isOneAway("abcdef", "abqdef"));
        assertTrue(alg.isOneAway("abcdef", "abccef"));
        assertTrue(alg.isOneAway("abcdef", "abcde"));
        assertFalse(alg.isOneAway("aaa", "abc"));
        assertFalse(alg.isOneAway("abcde", "abc"));
        assertFalse(alg.isOneAway("abc", "abcde"));
        assertFalse(alg.isOneAway("abc", "bcc"));
    }

}