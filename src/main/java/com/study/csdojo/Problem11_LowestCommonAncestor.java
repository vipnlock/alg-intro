package com.study.csdojo;

import java.util.LinkedList;

public class Problem11_LowestCommonAncestor {

    public TreeNode lca(TreeNode head, int a, int b) {
        if (head == null) {
            return null;
        }
        LinkedList<TreeNode> trackA = new LinkedList<>();
        if (!search(head, trackA, a)) {
            return null;
        }
        LinkedList<TreeNode> trackB = new LinkedList<>();
        if (!search(head, trackB, b)) {
            return null;
        }
        int i = -1;
        int minSize = Math.min(trackA.size(), trackB.size());
        TreeNode commonAncestor = null;
        while (minSize > 0) {
            TreeNode elemA = trackA.pop();
            TreeNode elemB = trackB.pop();
            if (elemA.value == elemB.value) {
                commonAncestor = elemA;
            } else {
                break;
            }
            minSize--;
        }
        return commonAncestor;
    }

    private boolean search(TreeNode head, LinkedList<TreeNode> track, int target) {
        if (head == null) {
            return false;
        }
        if (head.value == target || search(head.left, track, target) || search(head.right, track, target)) {
            track.push(head);
            return true;
        }
        return false;
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
