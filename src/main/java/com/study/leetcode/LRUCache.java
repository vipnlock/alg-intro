package com.study.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {

    private final int maxCapacity;
    private int capacity;
    private final Map<Integer, Node> map;
    private LinkedList<Node> list;

    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.list = new LinkedList<>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            list.remove(node);
            list.add(0, node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            list.remove(node);
            node.value = value;
        } else if (capacity == 0) {
            node = new Node(key, value);
            Node toDelete = list.removeLast();
            map.remove(toDelete.key);
        } else {
            node = new Node(key, value);
            capacity--;
        }
        list.add(0, node);
        map.put(key, node);
    }

    private static class Node {
        private int key;
        private int value;
        private int used;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */