package com.skiena.chapter8;

import org.junit.jupiter.api.Test;

class FibonacciNumbersTest {

    @Test
    void simpleFib() {
        FibonacciNumbers alg = new FibonacciNumbers();
        System.out.println(alg.simpleFib(7));
    }

    @Test
    void cachingFib() {
        FibonacciNumbers alg = new FibonacciNumbers();
        System.out.println(alg.simpleFib(7));
    }

    @Test
    void fib_DP() {
        FibonacciNumbers alg = new FibonacciNumbers();
        System.out.println(alg.fib_DP(7));
    }

    @Test
    void fib_DP_ultimate() {
        FibonacciNumbers alg = new FibonacciNumbers();
        System.out.println(alg.fib_DP_ultimate(7));
    }

}