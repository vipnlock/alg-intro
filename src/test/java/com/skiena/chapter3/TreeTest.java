package com.skiena.chapter3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    private Tree tree = createTestTree();

    @Test
    void search() {
        System.out.println(tree.search(10));
        System.out.println(tree.search(7));
        System.out.println(tree.search(8));
    }

    @Test
    void min() {
        System.out.println(tree.min());
    }

    @Test
    void traverseTree() {
        tree.traverseTree();
    }

    private static Tree createTestTree() {
        Tree tree = new Tree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(1);
        tree.insert(7);
        tree.insert(15);
        tree.insert(13);
        tree.insert(17);

        return tree;
    }

}