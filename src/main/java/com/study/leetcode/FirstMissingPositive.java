package com.study.leetcode;

class FirstMissingPositive {
    /*
     * Negating positive values as a marker.
     */
    public int firstMissingPositive_1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int n = nums.length;
        
        int firstNeg = partition(nums);

        for (int i = 0; i < firstNeg; i++) {
            if (Math.abs(nums[i]) <= firstNeg) {
                if (nums[Math.abs(nums[i]) - 1] > 0) {
                    nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
                }
            }
        }
        for (int i = 0; i < firstNeg; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return firstNeg + 1;
    }

    /*
     * Swapping values to the place, which they define.
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length
                    && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private int partition(int[] nums) {
        int n = nums.length;
        int firstLow = 0;
        // 1, 0, -1
        //i       |
        //fl  |
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                swap(nums, firstLow, i);
                firstLow++;
            }
        }
        return firstLow;
    }
    
    private void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
    
}