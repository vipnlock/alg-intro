package com.study.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnagramsTest {

    private Anagrams alg = new Anagrams();

    @Test
    void groupAnagrams() {
        List<List<String>> result = alg.groupAnagrams(new String[] {
                "hos","boo","nay","deb","wow","bop","bob","brr","hey","rye","eve","elf","pup","bum","iva","lyx","yap","ugh","hem","rod","aha","nam","gap","yea","doc","pen","job","dis","max","oho","jed","lye","ram","pup","qua","ugh","mir","nap","deb","hog","let","gym","bye","lon","aft","eel","sol","jab"});
        for (List<String> strings : result) {
            System.out.println(strings);
        }
    }

    @Test
    void sortString() {
        String tmp = "dcba";
        char[] arr = tmp.toCharArray();
        Arrays.sort(arr);
        System.out.println(new String(arr));
    }

}