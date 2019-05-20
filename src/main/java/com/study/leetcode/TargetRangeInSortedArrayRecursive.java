package com.study.leetcode;

class TargetRangeInSortedArrayRecursive {
    
    public int[] searchRange(int[] nums, int target) {        
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        int n = nums.length;
        
        int position = binSearch(nums, 0, n - 1, target);
        if (position == -1) {
            return new int[] {-1, -1};
        }
        int lb;
        if (position == 0 || nums[position - 1] != target) {
            lb = position;
        } else {
            lb = binSearchLB(nums, 0, position - 1, target);
        }
        
        int rb;
        if (position == n - 1 || nums[position + 1] != target) {
            rb = position;
        } else {
            rb = binSearchRB(nums, position + 1, n - 1, target);
        }
        
        return new int[] {lb, rb};
    }
    
    private int binSearchLB(int[] nums, int lower, int upper, int target) {
        if (lower > upper) {
            return -1;
        }
        int mid = (lower + upper) / 2;
        if (nums[mid] == target) {
            if (mid == 0 || nums[mid - 1] != target) {
                return mid;
            } else {
                return binSearchLB(nums, lower, mid - 1, target);
            }
        } else {
            return binSearchLB(nums, mid + 1, upper, target);
        }
    }
    
    private int binSearchRB(int[] nums, int lower, int upper, int target) {
        if (lower > upper) {
            return -1;
        }
        int mid = (lower + upper) / 2;
        if (nums[mid] == target) {
            if (mid == upper || nums[mid + 1] != target) {
                return mid;
            } else {
                return binSearchRB(nums, mid + 1, upper, target);
            }
        } else {
            return binSearchRB(nums, lower, mid - 1, target);
        }
    }
    
    private int binSearch(int[] nums, int lower, int upper, int target) {
        if (lower > upper) {
            return -1;
        }
        int mid = (lower + upper) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binSearch(nums, mid + 1, upper, target);
        } else {
            return binSearch(nums, lower, mid - 1, target);
        }
    }
    
}