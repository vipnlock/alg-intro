package com.study.leetcode;

import com.study.leetcode.structure.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] max = new int[] { Integer.MIN_VALUE };
        maxSum(root, max);
        return max[0];
    }

    private int maxSum(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, maxSum(root.left, max));
        int right = Math.max(0, maxSum(root.right, max));
        int currentMaxPathSum = left + root.val + right;
        max[0] = Math.max(max[0], currentMaxPathSum);
        return Math.max(left, right) + root.val;
    }




    public int maxPathSumNotOptimal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Pair pair = maxSum(root);
        return Math.max(pair.maxPathSum, pair.maxBranchSum);
    }
    
    private Pair maxSum(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        Pair left = maxSum(root.left);
        Pair right = maxSum(root.right);
        
        if (left == null && right == null) {
            return new Pair(root.val, root.val);
        } else if (left == null) {
            int maxRightBranch = Math.max(right.maxBranchSum + root.val, root.val);
            return new Pair(Math.max(right.maxPathSum, maxRightBranch),
                            maxRightBranch);
        } else if (right == null) {
            int maxLeftBranch = Math.max(left.maxBranchSum + root.val, root.val);
            return new Pair(Math.max(left.maxPathSum, maxLeftBranch),
                            maxLeftBranch);
        } else {
            int maxLeftBranch = Math.max(left.maxBranchSum + root.val, root.val);
            int maxRightBranch = Math.max(right.maxBranchSum + root.val, root.val);
            int maxBranch = Math.max(maxLeftBranch, maxRightBranch);
            return new Pair(
                Math.max(
                    Math.max(left.maxPathSum, right.maxPathSum),
                    Math.max(maxLeftBranch - root.val + maxRightBranch, maxBranch)),
                maxBranch);
        }
    }
    
    private static class Pair {
        private int maxPathSum;
        private int maxBranchSum;
        public Pair(int maxPathSum, int maxBranchSum) {
            this.maxPathSum = maxPathSum;
            this.maxBranchSum = maxBranchSum;
        }
    }
}