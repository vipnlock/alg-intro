package com.study.dynamic;

import com.study.dynamic.Ex4_ShareMarket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex4_ShareMarketTest {

    @Test
    void maxProfit() {
        assertEquals(5, new Ex4_ShareMarket().maxProfit(new int[] {8, 1, 2, 4, 6, 3}));
    }

    @Test
    void maxProfitWithoutArrays() {
        assertEquals(5, new Ex4_ShareMarket().maxProfitWithoutArrays(new int[] {8, 1, 2, 4, 6, 3}));
    }

}