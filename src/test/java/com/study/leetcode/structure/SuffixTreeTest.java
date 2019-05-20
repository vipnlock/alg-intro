package com.study.leetcode.structure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuffixTreeTest {

    private SuffixTree tree = new SuffixTree();

    @Test
    void testTrie() {
        tree.insert("ABAB");
        tree.insert("BABA");
        System.out.println(tree.longestCommonSubstring());
//        assertTrue(tree.search("ABCD"));
//        assertTrue(tree.search("A"));
//        assertTrue(tree.search("BC"));
//        assertTrue(tree.search("D"));
    }

}