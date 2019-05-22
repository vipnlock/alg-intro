package com.study.leetcode;

import com.study.leetcode.structure.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class TreeInOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode tmp = root;
        while (tmp != null || !stack.isEmpty()) {
            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }

            tmp = stack.pop();
            res.add(tmp.val);
            tmp = tmp.right;
        }

        return res;
    }

    public List<Integer> inorderTraversalFirst(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode tmp = root;
        while (tmp != null) {
            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }
            do {
                tmp = stack.pop();
                res.add(tmp.val);
            } while (!stack.isEmpty() && tmp.right == null);

            if (tmp.right != null) {
                tmp = tmp.right;
            } else {
                tmp = null;

                while (!stack.isEmpty()) {
                    tmp = stack.pop();
                    res.add(tmp.val);
                    if (tmp.right != null) {
                        tmp = tmp.right;
                        break;
                    } else {
                        tmp = null;
                    }
                }
            }
        }

        return res;
    }

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> res = new LinkedList<>();
        traverse(root, res);
        return res;
    }

    private void traverse(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        traverse(node.left, res);
        res.add(node.val);
        traverse(node.right, res);
    }

}