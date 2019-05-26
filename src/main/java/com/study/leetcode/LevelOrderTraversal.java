package com.study.leetcode;

import com.study.leetcode.structure.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LevelOrderTraversal {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        /*
         * Using DFS.
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            List<List<Integer>> res = new LinkedList<>();
            traverse(root, 0, res);
            return res;
        }

        private void traverse(TreeNode node, int level, List<List<Integer>> res) {
            if (node == null) {
                return;
            }
            if (level == res.size()) {
                res.add(new LinkedList<>());
            }
            res.get(level).add(node.val);
            traverse(node.left, level + 1, res);
            traverse(node.right, level + 1, res);
        }

        /*
         * Using BFS.
         */
        public List<List<Integer>> levelOrderBFS(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            List<List<Integer>> res = new LinkedList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            Queue<Integer> levels = new LinkedList<>();
            queue.add(root);
            levels.add(1);

            int curLevel = 1;
            List<Integer> tmpList = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode tmp = queue.poll();
                Integer level = levels.poll();

                if (!level.equals(curLevel)) {
                    curLevel = level;
                    res.add(tmpList);
                    tmpList = new LinkedList<>();
                }
                tmpList.add(tmp.val);

                if (tmp.left != null) {
                    queue.add(tmp.left);
                    levels.add(curLevel + 1);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                    levels.add(curLevel + 1);
                }
            }
            if (!tmpList.isEmpty()) {
                res.add(tmpList);
            }

            return res;
        }

    }
}