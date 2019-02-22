package com.study;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex3_RodCutterTest {

    @Test
    void rodCutter() {
        Ex3_RodCutter rc = new Ex3_RodCutter();

        // n is always 1 less than cost array length because 0th element is cost[0]
        int[] cost = {0, 2, 4, 7, 8};
        int size = 4;

        // Maximum value that can be earned by cutting up the rod and selling the pieces of the cost array {0, 2, 4, 7, 8} is:
        assertEquals(9, rc.rodCutter(cost, size));
    }

    @Test
    void rodCutter5() {
        Ex3_RodCutter rc = new Ex3_RodCutter();

        // n is always 1 less than cost array length because 0th element is cost[0]
        int[] cost = {0, 2, 4, 6, 8, 9};
        int size = 5;

        // Maximum value that can be earned by cutting up the rod and selling the pieces of the cost array {0, 2, 4, 7, 8} is:
        assertEquals(10, rc.rodCutter(cost, size));
    }

}
