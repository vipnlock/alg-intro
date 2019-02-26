package com.study.other;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SumOfPairsTest {

    @Test
    void closesSumPair() {
        System.out.println(Arrays.toString(new SumOfPairs().closesSumPair(
                new int[] {-1, 3, 8, 2, 9, 5},
                new int[] {4, 1, 2, 10, 5, 20},
                24)));
    }

}