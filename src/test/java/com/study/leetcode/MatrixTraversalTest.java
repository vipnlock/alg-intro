package com.study.leetcode;

import org.junit.jupiter.api.Test;

class MatrixTraversalTest {

    private int[][] m01 = new int[][] {
            {1}
    };
    private int[][] m02 = new int[][] {
            {1, 2, 3}
    };
    private int[][] m03 = new int[][] {
            {1},
            {2},
            {3}
    };
    private int[][] m04 = new int[][] {
            {1, 2},
            {3, 4}
    };
    private int[][] m1 = new int[][] {
            {1,   2,  3},
            {4,   5,  6},
            {7,   8,  9},
            {10, 11, 12},
            {13, 14, 15},
    };

    private int[][] m2 = new int[][] {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15}
    };

    private int[][] m3 = new int[][] {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };

    private MatrixTraversal alg = new MatrixTraversal();

    @Test
    void lrUpwards() {
        alg.lrUpwards(m1);
        System.out.println();
        alg.lrUpwards(m2);
        System.out.println();
        alg.lrUpwards(m3);
        System.out.println();
    }

    @Test
    void rlDownFromTopLeft() {
        alg.rlDownFromTopLeft(m1);
        System.out.println();
        alg.rlDownFromTopLeft(m2);
        System.out.println();
        alg.rlDownFromTopLeft(m3);
        System.out.println();
    }

    @Test
    void lrDownFromTopRight() {
        alg.lrDownFromTopRight(m1);
        System.out.println();
        alg.lrDownFromTopRight(m2);
        System.out.println();
        alg.lrDownFromTopRight(m3);
        System.out.println();
    }

    @Test
    void spiral() {
        alg.spiral(m01);
        System.out.println();
        alg.spiral(m02);
        System.out.println();
        alg.spiral(m03);
        System.out.println();
        alg.spiral(m04);
        System.out.println();
        alg.spiral(m1);
        System.out.println();
        alg.spiral(m2);
        System.out.println();
        alg.spiral(m3);
        System.out.println();
    }

    @Test
    void zigzag() {
        alg.zigzag(m01);
        System.out.println();
        alg.zigzag(m02);
        System.out.println();
        alg.zigzag(m03);
        System.out.println();
        alg.zigzag(m04);
        System.out.println();
        alg.zigzag(m1);
        System.out.println();
        alg.zigzag(m2);
        System.out.println();
        alg.zigzag(m3);
        System.out.println();
    }

}