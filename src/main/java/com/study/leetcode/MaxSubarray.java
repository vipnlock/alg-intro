package com.study.leetcode;

class MaxSubarray {
    /*
     * Kadane's algorithm.
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        
        int maxEndingHere = nums[0];
        int totalMax = nums[0];
        
        //nums: -2,1,-3,4,-1,2,1,-5,4
        //            |
        //meh:  -2 1 -2 4  3 5 6  1 5
        // tm:  -2 1  1 4  4 5 6  6 6
        for (int i = 1; i < n; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            totalMax = Math.max(totalMax, maxEndingHere);
        }
        return totalMax;
    }
}