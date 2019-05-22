package com.study.leetcode;

import com.study.leetcode.structure.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TreeInOrderTraversalTest {

    private TreeInOrderTraversal alg = new TreeInOrderTraversal();

    @Test
    void inorderTraversal() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        assertEquals(Arrays.asList(1, 2, 3), alg.inorderTraversal(root));
    }


}