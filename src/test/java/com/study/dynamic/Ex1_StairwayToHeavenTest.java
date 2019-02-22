package com.study.dynamic;

import com.study.dynamic.Ex1_StairwayToHeaven;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex1_StairwayToHeavenTest {

    @Test
    void stairwayToHeaven() {
        Ex1_StairwayToHeaven sth = new Ex1_StairwayToHeaven();
        assertEquals(8, sth.stairwayToHeaven(5));
    }

}