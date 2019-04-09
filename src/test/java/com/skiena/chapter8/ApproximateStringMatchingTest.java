package com.skiena.chapter8;

import org.junit.jupiter.api.Test;

class ApproximateStringMatchingTest {

    @Test
    void stringCompareRecursion() {
        ApproximateStringMatching alg = new ApproximateStringMatching();
        System.out.println(alg.stringCompareRecursion("shopping", "shopting", 7, 7));
        System.out.println(alg.stringCompareRecursion("shopping", "shoting", 7, 6));
        System.out.println(alg.stringCompareRecursion("shopping", "hoting", 7, 5));
        System.out.println(alg.stringCompareRecursion("abcd", "defg", 3, 3));
        System.out.println(alg.stringCompareRecursion("aaaa", "ssss", 3, 3));

        System.out.println(alg.stringCompareRecursion("ABCDEFGHIJKL", "LNOPQRSTUVWX", 11, 11));
    }

    @Test
    void stringCompareDP() {
        ApproximateStringMatching alg = new ApproximateStringMatching();
        System.out.println(alg.stringCompareDP(" thou-shalt-not", " you-should-not"));
    }

}