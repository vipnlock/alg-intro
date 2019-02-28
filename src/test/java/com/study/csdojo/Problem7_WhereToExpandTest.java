package com.study.csdojo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Problem7_WhereToExpandTest {

    @Test
    void click() {
        Problem7_WhereToExpand alg = new Problem7_WhereToExpand();

        int[][] field1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 1, -1, 1, 0}};

        System.out.println(Arrays.deepToString(alg.click(field1, 3, 5, 2, 2)));
        // should return:
        // [[0, 0, 0, 0, 0],
        //  [0, 1, 1, 1, 0],
        //  [0, 1, -1, 1, 0]]

        System.out.println(Arrays.deepToString(alg.click(field1, 3, 5, 1, 4)));
        // should return:
        // [[-2, -2, -2, -2, -2],
        //  [-2, 1, 1, 1, -2],
        //  [-2, 1, -1, 1, -2]]


        int[][] field2 = {{-1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, -1}};

        System.out.println(Arrays.deepToString(alg.click(field2, 4, 4, 0, 1)));
        // should return:
        // [[-1, 1, 0, 0],
        //  [1, 1, 0, 0],
        //  [0, 0, 1, 1],
        //  [0, 0, 1, -1]]

        System.out.println(Arrays.deepToString(alg.click(field2, 4, 4, 1, 3)));
        // should return:
        // [[-1, 1, -2, -2],
        //  [1, 1, -2, -2],
        //  [-2, -2, 1, 1],
        //  [-2, -2, 1, -1]]
    }

}