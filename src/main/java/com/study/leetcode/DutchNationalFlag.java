package com.study.leetcode;

class DutchNationalFlag {

    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        int mid = 0;
        while (mid <= high) {
            if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public void sortColorsMy(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        
        int first1 = 0;
        int last1 = n - 1;
        
        // 0 0 2 1 0 2 0 1 2 2
        // 0 0 0 1 1 0 2 2 2 2
        //       f   l
        //           i

        // 2 1 2
        // f   l
        //   i
        
        // 0 0 2 2
        //   f l
        //     i
        
        // 1,2,2,2,2,0,0,0,1,1
        // 1,1,1,0,2,0,0,2,2,2
        // f             l
        //       i
        if (nums[first1] > nums[last1]) {
            swap(nums, first1, last1);
        }
        for (int i = first1 + 1; i <= last1; i++) {
            if (nums[i] == 1) {
                swap(nums, i, first1);
            }
            while (nums[i] == 0 && first1 < i) {
                swap(nums, i, first1++);
            }
            while (nums[i] == 2 && last1 > i) {
                swap(nums, i, last1--);
            }
            while (nums[i] == 0 && first1 < i) {
                swap(nums, i, first1++);
            }
        }
        if (nums[first1] == 2 || nums[last1] == 0) {
            swap(nums, first1, last1);
        }
    }
    
    private void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}