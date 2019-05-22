package com.study.leetcode;

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
 */
// Recursive solution + cache.
class JumpGame {
    
    private static final int REACHABLE = 1;
    private static final int NOT_REACHABLE = 2;

    /*
     * DP. Greedy optimization: 1 ms.
     * O(n) / O(1).
     */
    public boolean canJumpDPGreedyOptimized(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;

        int lastReachable = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] + i >= lastReachable) {
                lastReachable = i;
            }
        }
        return lastReachable == 0;
    }

    /*
     * DP "inversed" approach: 167 ms. Because more cache hits.
     * O(n^2) / O(n)
     */
    public boolean canJumpInversedDP(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;

        boolean[] reachable = new boolean[n];
        reachable[n - 1] = true;

        // 2,3,1,1,4
        for (int i = n - 2; i >= 0; i--) {
            int maxJump = Math.min(i + nums[i], n - 1);
            for (int k = i + 1; k <= maxJump; k++) {
                if (reachable[k]) {
                    reachable[i] = true;
                    break;
                }
            }
        }
        return reachable[0];
    }

    /*
     * DP "classic" approach: 228 ms.
     * O(n^2) / O(2n) = O(n) from recursion + O(n) from the memo table.
     */
    public boolean canJumpClassicDP(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;

        boolean[] reachable = new boolean[n];
        reachable[n - 1] = true;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || !reachable[i]) {
                continue;
            }
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < n) {
                    reachable[i + j] = true;
                }
            }
        }
        return reachable[n - 1];
    }

    /*
     * Recursive approach without caching: Time Limit Exceeded.
     * Recursive approach with caching: 1555 ms.
     * O(2^n) / O(n) - recursion requires additional memory for the stack frames.
     */
    public boolean canJumpRecursive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        cache = new int[nums.length];
        return canJump(nums, 0, nums.length - 1);
    }
    
    private int[] cache;
    
    private boolean canJump(int[] nums, int startPos, int targetPos) {
        if (startPos == targetPos) {
            return true;
        } else if (startPos > targetPos) {
            return false;
        }
        if (cache[startPos] == REACHABLE) {
            return true;
        } else if (cache[startPos] == NOT_REACHABLE) {
            return false;
        }
        
        if (nums[startPos] <= 0) {
            return false;
        }
        boolean isPossible = false;
        for (int i = 1; i <= nums[startPos]; i++) {
            isPossible |= canJump(nums, startPos + i, targetPos);
            if (isPossible) {
                cache[startPos] = REACHABLE;
                return true;
            }
        }
        cache[startPos] = NOT_REACHABLE;
        return false;
    }
    
}