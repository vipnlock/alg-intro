package com.study.csdojo;

public class Problem10_IsBinarySearchTree {

    boolean isBst(TreeNode treeNode) {
        return isBst(treeNode, null, null);
    }

    boolean isBst(TreeNode treeNode, Integer lowerLimit, Integer upperLimit) {
        if (treeNode == null) {
            return true;
        }
        if ((lowerLimit != null && treeNode.value < lowerLimit) || (upperLimit != null && treeNode.value > upperLimit)) {
            return false;
        }
        return isBst(treeNode.left, lowerLimit, treeNode.value) && isBst(treeNode.right, treeNode.value, upperLimit);
    }

    boolean myIsBst(TreeNode treeNode) {
        if (treeNode == null) {
            return true;
        }
        if (treeNode.left != null) {
            TreeNode tmp = treeNode.left;
            while (tmp.right != null) {
                tmp = tmp.right;
            }
            if (treeNode.value <= treeNode.left.value || treeNode.value <= tmp.value) {
                return false;
            }
        }
        if (treeNode.right != null) {
            TreeNode tmp = treeNode.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            if (treeNode.value >= treeNode.right.value || treeNode.value >= tmp.value) {
                return false;
            }
        }
        return isBst(treeNode.left) && isBst(treeNode.right);
    }

    static class TreeNode {
        private int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

}
