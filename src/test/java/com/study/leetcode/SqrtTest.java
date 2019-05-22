package com.study.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqrtTest {

    private Sqrt alg = new Sqrt();

    @Test
    void mySqrt() {
        System.out.println(alg.mySqrt(8));
        System.out.println(alg.mySqrt(2147395599));
    }

}