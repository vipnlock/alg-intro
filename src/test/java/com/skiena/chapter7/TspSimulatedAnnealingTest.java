package com.skiena.chapter7;

import org.junit.jupiter.api.Test;

class TspSimulatedAnnealingTest {

    @Test
    void tsp() {

        final int cities[][] = new int[][] {
                { 0, 12,  3, 23, 1,   5, 32, 56},
                {12,  0,  9, 18, 3,  41, 45,  5},
                { 3,  9,  0, 89, 56, 21, 12, 49},
                {23, 18, 89,  0, 87, 46, 75, 17},
                { 1,  3, 56, 87,  0, 55, 22, 86},
                { 5, 41, 21, 46, 55,  0, 21, 76},
                {32, 45, 12, 75, 22, 21,  0, 11},
                {56,  5, 49, 17, 86, 76, 11,  0}
        };

        new TspSimulatedAnnealing(cities).tsp();
    }

}