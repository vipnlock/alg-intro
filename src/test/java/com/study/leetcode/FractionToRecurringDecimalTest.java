package com.study.leetcode;

import org.junit.jupiter.api.Test;

class FractionToRecurringDecimalTest {

    private FractionToRecurringDecimal alg = new FractionToRecurringDecimal();

    @Test
    void fractionToDecimal() {
        System.out.println(Integer.MIN_VALUE);
//        System.out.println(alg.fractionToDecimal(-1, -2147483648));
        System.out.println(alg.fractionToDecimal(-2147483648, 1));
    }

}