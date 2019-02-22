package com.study;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex8_StairwayToHeaven2Test {

    @Test
    void minimumFee_5() {
        assertEquals(3, new Ex8_StairwayToHeaven2().minimumFee(new int[] {2, 1, 3, 1, 2}));
    }

    @Test
    void minimumFee_4() {
        assertEquals(2, new Ex8_StairwayToHeaven2().minimumFee(new int[] {2, 1, 3}));
    }

    @Test
    void minimumFee_3() {
        assertEquals(2, new Ex8_StairwayToHeaven2().minimumFee(new int[] {2, 1, 3}));
    }

}