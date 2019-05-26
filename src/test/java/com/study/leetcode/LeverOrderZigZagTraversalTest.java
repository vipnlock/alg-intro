package com.study.leetcode;

import com.study.leetcode.structure.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeverOrderZigZagTraversalTest {

    private LeverOrderZigZagTraversal alg = new LeverOrderZigZagTraversal();

    @Test
    void zigzagLevelOrder() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        List<List<Integer>> res = alg.zigzagLevelOrder(root);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }

}