package com.study.dynamic;

import com.study.dynamic.Ex7_DominosArrangements;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex7_DominosArrangementsTest {

    @Test
    void numberOfWays() {
        assertEquals(13, new Ex7_DominosArrangements().numberOfWays(6));
    }
}