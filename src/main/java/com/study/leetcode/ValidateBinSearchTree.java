package com.study.leetcode;

import com.study.leetcode.structure.TreeNode;

import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class ValidateBinSearchTree {
    /*
     * Iterative.
     */
    public boolean isValidBST(TreeNode root) {
        TreeNode tmp = root;

        LinkedList<TreeNode> stack = new LinkedList<>();

        Integer last = null;
        while (tmp != null || !stack.isEmpty()) {
            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }

            tmp = stack.pop();
            if (last == null) {
                last = tmp.val;
            } else if (last.compareTo(tmp.val) >= 0) {
                return false;
            }
            last = tmp.val;
            tmp = tmp.right;
        }
        return true;
    }

    /*
     * Recursive.
     */
    public boolean isValidBSTRecursive(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        if (lower != null && root.val <= lower) {
            return false;
        }
        if (upper != null && root.val >= upper) {
            return false;
        }
        return isValid(root.left, lower, root.val)
                && isValid(root.right, root.val, upper);
    }

}