package com.study.leetcode;

import com.study.leetcode.structure.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PopulatingNextRightPointersTest {

    private PopulatingNextRightPointers alg = new PopulatingNextRightPointers();

    @Test
    void connect() {
        Node root = new Node(1,
                new Node(2, new Node(4, null, null, null), new Node(5, null, null, null), null),
                new Node(3, new Node(5, null, null, null), new Node(6, null, null, null), null), null);

        root = alg.connect(root);
        System.out.println("Hello");
    }

}