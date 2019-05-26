package com.study.leetcode;

import com.study.leetcode.structure.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class PreorderAndInorderToBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0
                || inorder == null || inorder.length == 0
                || preorder.length != inorder.length) {
            return null;
        }

        return buildTree(preorder, inorder, 0, 0, preorder.length);
    }

    // preorder = [3,9,20,15,7]
    // inorder  = [9,3,15,20,7]
    // buildTree(po, 0, 4, io, 0, 4)
    //         (3)
    // left = buildTree(po, 1, 1, io, 0, 0);
    // right = buildTree(po, 2, 4, io, 2, 4);
    public TreeNode buildTree(int[] preorder, int[] inorder,
                              int pIndex, int iIndex, int length) {
        if (length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pIndex]);

        int l = 0;
        while (l < length && inorder[iIndex + l] != root.val) {
            l++;
        }

        root.left = buildTree(preorder, inorder,
                pIndex + 1, iIndex, l);
        root.right = buildTree(preorder, inorder,
                pIndex + 1 + l, iIndex + l + 1, length - 1 - l);
        return root;
    }

}