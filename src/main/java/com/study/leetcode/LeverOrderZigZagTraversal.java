package com.study.leetcode;

import com.study.leetcode.structure.TreeNode;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class LeverOrderZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int queueSize = 1;
        int nextSize = 0;
        boolean leftToRight = true;

        LinkedList<Integer> tmp = new LinkedList<>();

        while (!queue.isEmpty()) {
            if (queueSize == 0) {
                queueSize = nextSize;
                nextSize = 0;
                addEntry(res, tmp, leftToRight);
                tmp = new LinkedList<>();
                leftToRight = !leftToRight;
            }
            TreeNode node = queue.poll();
            tmp.add(node.val);
            queueSize--;

            if (node.left != null) {
                queue.add(node.left);
                nextSize++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextSize++;
            }
        }
        if (!tmp.isEmpty()) {
            addEntry(res, tmp, leftToRight);
        }

        return res;
    }

    private void addEntry(List<List<Integer>> res, LinkedList<Integer> tmp,
                          boolean leftToRight) {
        if (!leftToRight) {
            LinkedList<Integer> tmpReversed = new LinkedList<>();
            Iterator<Integer> iter = tmp.descendingIterator();
            while (iter.hasNext()) {
                tmpReversed.add(iter.next());
            }
            res.add(tmpReversed);
        } else {
            res.add(tmp);
        }
    }
}