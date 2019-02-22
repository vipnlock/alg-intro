package com.study.dynamic;

import com.study.dynamic.Ex2_OnTheWayHome;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex2_OnTheWayHomeTest {

    @Test
    @DisplayName("The number of unique ways to reach our home in a 4X3 grid")
    void numWays() {
        Ex2_OnTheWayHome otwh = new Ex2_OnTheWayHome();
        assertEquals(10, otwh.numWays(4, 3));
    }

}