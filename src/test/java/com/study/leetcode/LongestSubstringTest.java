package com.study.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringTest {

    private LongestSubstring alg = new LongestSubstring();

    @ParameterizedTest
    @CsvSource({
            "5,tmmzuxt",
            "3,abcabcabb",
            "4,abcbcde",
            "1,aaa"
    })
    void lengthBruteForce(int expectedNumber, String str) {
        assertEquals(expectedNumber, alg.lengthBruteForce(str));
    }

    @ParameterizedTest
    @CsvSource({
            "5,tmmzuxt",
            "3,abcabcabb",
            "4,abcbcde",
            "1,aaa"
    })
    void lengthSlidingWindow(int expectedNumber, String str) {
        assertEquals(expectedNumber, alg.lengthSlidingWindow(str));
    }

    @ParameterizedTest
    @CsvSource({
            "5,tmmzuxt",
            "3,abcabcabb",
            "4,abcbcde",
            "1,aaa"
    })
    void lengthSlidingWindowWithDirectIndex(int expectedNumber, String str) {
        assertEquals(expectedNumber, alg.lengthSlidingWindowWithDirectIndex(str));
    }

}