package com.study.leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PalindromePartitioningTest {

    private PalindromePartitioning alg = new PalindromePartitioning();

    @Test
    void partition() {
//        List<List<String>> parts = alg.partition("aab");
        List<List<String>> parts = alg.partition("cbbbcc");
        for (List<String> part : parts) {
            System.out.println(part);
        }
    }

}