package com.study.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegexpsMatchingTest {

    private RegexpsMatching alg = new RegexpsMatching();

    @Test
    void isMatch() {
        assertTrue(alg.isMatch("baabbbaccbccacacc", "c*..b*a*a.*a..*c"));
    }

}