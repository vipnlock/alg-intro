package com.skiena.chapter8;

import org.junit.jupiter.api.Test;

class PartitionProblemTest {

    @Test
    void partition1() {
        final PartitionProblem alg = new PartitionProblem();
        alg.partition(new int[] {0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 3);
    }

    @Test
    void partition2() {
        final PartitionProblem alg = new PartitionProblem();
        alg.partition(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 3);
    }

}
