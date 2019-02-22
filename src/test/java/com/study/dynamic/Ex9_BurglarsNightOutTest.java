package com.study.dynamic;

import com.study.dynamic.Ex9_BurglarsNightOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex9_BurglarsNightOutTest {

    @Test
    void rob() {
        assertEquals(20, new Ex9_BurglarsNightOut().rob(new int[] {3, 8, 10, 4, 1, 7}));
        assertEquals(0, new Ex9_BurglarsNightOut().rob(new int[] {}));
        assertEquals(1, new Ex9_BurglarsNightOut().rob(new int[] {1}));
        assertEquals(2, new Ex9_BurglarsNightOut().rob(new int[] {1, 2}));
        assertEquals(4, new Ex9_BurglarsNightOut().rob(new int[] {1, 2, 3}));
    }

    @Test
    void robCircularColony() {
        assertEquals(34, new Ex9_BurglarsNightOut().robCircularColony(new int[] {1, 1, 1, 1, 11, 11, 11, 11, 11}));
        assertEquals(34, new Ex9_BurglarsNightOut().robCircularColony(new int[] {1, 1, 1, 11, 11, 11, 11, 11, 1}));
        assertEquals(34, new Ex9_BurglarsNightOut().robCircularColony(new int[] {1, 1, 11, 11, 11, 11, 11, 1, 1}));
        assertEquals(34, new Ex9_BurglarsNightOut().robCircularColony(new int[] {1, 11, 11, 11, 11, 11, 1, 1, 1}));
        assertEquals(34, new Ex9_BurglarsNightOut().robCircularColony(new int[] {11, 11, 11, 11, 11, 1, 1, 1, 1}));
        assertEquals(34, new Ex9_BurglarsNightOut().robCircularColony(new int[] {11, 11, 11, 11, 1, 1, 1, 1, 11}));
        assertEquals(34, new Ex9_BurglarsNightOut().robCircularColony(new int[] {11, 11, 11, 1, 1, 1, 1, 11, 11}));
        assertEquals(34, new Ex9_BurglarsNightOut().robCircularColony(new int[] {11, 11, 1, 1, 1, 1, 11, 11, 11}));
        assertEquals(34, new Ex9_BurglarsNightOut().robCircularColony(new int[] {11, 1, 1, 1, 1, 11, 11, 11, 11}));
    }

}