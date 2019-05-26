package com.study.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxPointsOnLineTest {

    private MaxPointsOnLine alg = new MaxPointsOnLine();

    @Test
    void maxPoints3() {
        assertEquals(3,
                alg.maxPoints(new int[][]{
                        new int[]{1,1},
                        new int[]{1,1},
                        new int[]{1,1}
                }));
    }

    @Test
    void maxPoints2() {
        assertEquals(3,
                alg.maxPoints(new int[][]{
                        new int[]{0,0},
                        new int[]{1,1},
                        new int[]{0,0}
                }));
    }

    @Test
    void maxPoints1() {
        assertEquals(4,
                alg.maxPoints(new int[][]{
                        new int[]{1, 1},
                        new int[]{3, 2},
                        new int[]{5, 3},
                        new int[]{4, 1},
                        new int[]{2, 3},
                        new int[]{1, 4}
                }));
        assertEquals(4,
                alg.maxPoints(new int[][]{
                                new int[]{1, 1},
                                new int[]{5, 3},
                                new int[]{4, 1},
                                new int[]{2, 3},
                                new int[]{1, 4},
                                new int[]{3, 2}
                        }
                ));
        assertEquals(4,
                alg.maxPoints(new int[][]{
                        new int[]{0, 0},
                        new int[]{2, 2},
                        new int[]{1, 1},
                        new int[]{0, 1},
                        new int[]{2, 3},
                        new int[]{1, 2},
                        new int[]{0, 2},
                        new int[]{2, 4},
                        new int[]{1, 3},
                        new int[]{1, 4},
                        new int[]{2, 5},
                        new int[]{0, 3}
                }));
    }

    @Test
    void gcd() {
        assertEquals(3, alg.gcd(21, 9));
        assertEquals(5, alg.gcd(25, 85));
    }

    @Test
    void getFunction() {
        System.out.println(alg.getFunction(new MaxPointsOnLine.Point(1, 1, 1), new MaxPointsOnLine.Point(2, 0, 2)));
        System.out.println(alg.getFunction(new MaxPointsOnLine.Point(1, 2, 0), new MaxPointsOnLine.Point(2, -1, 3)));
    }
}