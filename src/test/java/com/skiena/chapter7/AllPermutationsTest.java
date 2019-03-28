package com.skiena.chapter7;

import org.junit.jupiter.api.Test;

class AllPermutationsTest {

    @Test
    void generatePermutations_2() {
        new AllPermutations().generatePermutations(2);
    }

    @Test
    void generatePermutations_3() {
        new AllPermutations().generatePermutations(3);
    }

    @Test
    void generatePermutations_5() {
        new AllPermutations().generatePermutations(5);
    }

}