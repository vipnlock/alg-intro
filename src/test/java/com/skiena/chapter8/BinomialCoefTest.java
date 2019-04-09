package com.skiena.chapter8;

import org.junit.jupiter.api.Test;

class BinomialCoefTest {

    @Test
    void binomialCoefficient() {
        BinomialCoef alg = new BinomialCoef();
        System.out.println(alg.binomialCoefficient(5, 4));
        System.out.println(alg.binomialCoefficient(99, 57));
        System.out.println(alg.binomialCoefficient(99, 42));
    }

}