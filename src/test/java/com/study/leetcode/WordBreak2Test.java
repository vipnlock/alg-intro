package com.study.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordBreak2Test {

    private WordBreak2 alg = new WordBreak2();

    @Test
    void wordBreak() {
        List<String> res = alg.wordBreak("aaaaaaaa", Arrays.asList("aaaa","aaa","aa"));
//        List<String> res = alg.wordBreak("pineapplepenapple", Arrays.asList("apple","pen","applepen","pine","pineapple"));
//        List<String> res = alg.wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog"));
        for (String str : res) {
            System.out.println(str);
        }
    }

}