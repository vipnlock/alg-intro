package com.study.leetcode;

import com.study.leetcode.structure.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SymmetricTreesTest {

    private SymmetricTrees alg = new SymmetricTrees();

    @Test
    void isSymmetric() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        assertFalse(alg.isSymmetric(root));
    }

}