package com.study.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SurroundedRegionsTest {

    private SurroundedRegions alg = new SurroundedRegions();

    @Test
    void solve() {
        char[][] matrix = new char[][] {
            {'O','O','O','O','O','O','O','O','X','O','O','O','O','O','X','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'X','O','O','X','O','X','O','O','O','O','X','O','O','X','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','X','O'},
            {'O','X','X','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','X','O','O','O','O','O','O','X','O','O','O','O','O','X','X','O'},
            {'O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','X','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','O'},
            {'O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','X','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O'},
            {'X','O','O','O','O','O','O','O','O','X','X','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','X','O','O','O','O','O','O','O','O','X','O','O','O','O','O','X'},
            {'O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','X','O','X','O','O'},
            {'O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','X','X','O','O','O','X','O','O','X','O','O','X'},
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'}
        };
        alg.solve(matrix);
        for (char[] chars : matrix) {
            System.out.println(Arrays.toString(chars));
        }
    }

}