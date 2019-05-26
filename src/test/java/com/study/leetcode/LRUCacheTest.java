package com.study.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    @Test
    void testCache1() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));
        cache.put(3, 3);
        assertEquals(-1, cache.get(2));
        cache.put(4, 4);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }

    @Test
    void testCache2() {
        LRUCache cache = new LRUCache(1);
        cache.put(2, 1);
        assertEquals(1, cache.get(2));
        cache.put(3, 2);
        assertEquals(-1, cache.get(2));
        assertEquals(2, cache.get(3));
    }

}