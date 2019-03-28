package com.skiena.chapter7;

import org.junit.jupiter.api.Test;

class AllSubsetsTest {

    @Test
    void generateSubsets_2() {
        new AllSubsets().generateSubsets(2);
    }

    @Test
    void generateSubsets_3() {
        new AllSubsets().generateSubsets(3);
    }

    @Test
    void generateSubsets_5() {
        new AllSubsets().generateSubsets(5);
    }

}