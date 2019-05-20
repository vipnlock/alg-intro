package com.study.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WildcardMatchingTest {

    private WildcardMatching alg = new WildcardMatching();

    @Test
    void isMatch() {
        assertTrue(alg.isMatch("mississippi", "m??*ss*?i*pi"));
//        assertTrue(alg.isMatch("", "*"));
//        assertTrue(alg.isMatch("aaaab", "*aa*b*"));
        // too long
//        assertTrue(alg.isMatch("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba",
//                "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"));
    }

}