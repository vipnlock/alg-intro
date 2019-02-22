package com.study.dynamic;

import com.study.dynamic.Ex10_NumberSplitting;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex10_NumberSplittingTest {

    @Test
    void split() {
        assertEquals(9, new Ex10_NumberSplitting().split(6));
    }

}