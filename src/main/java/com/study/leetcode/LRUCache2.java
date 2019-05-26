package com.study.leetcode;

import java.util.LinkedHashMap;

class LRUCache2 {

    public int cap;
    private LinkedHashMap<Integer, Integer> lru;

    public LRUCache2(int capacity) {
        this.cap = capacity;
        this.lru = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (lru.containsKey(key)) {
            int new_value = lru.get(key);
            lru.remove(key);
            lru.put(key, new_value);
            return new_value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (lru.containsKey(key)) {
            lru.remove(key);

        } else if (lru.size() >= cap) {
            for (int k : lru.keySet()) {
                lru.remove(k);
                break;
            }
        }

        lru.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */