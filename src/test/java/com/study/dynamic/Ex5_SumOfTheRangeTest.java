package com.study.dynamic;

import com.study.dynamic.Ex5_SumOfTheRange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex5_SumOfTheRangeTest {

    @Test
    void sumRange() {
        Ex5_SumOfTheRange sum = new Ex5_SumOfTheRange();

        sum.preprocessing(new int[] {1, -2, 3, 10, -8, 0});

        assertEquals(2, sum.sumRange(0, 2));
        assertEquals(3, sum.sumRange(1, 4));
        assertEquals(10, sum.sumRange(3, 3));
    }

}