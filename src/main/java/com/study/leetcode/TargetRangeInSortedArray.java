package com.study.leetcode;

class TargetRangeInSortedArray {
    public int[] searchRange(int[] nums, int target) {        
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        int n = nums.length;
        
        int lower = 0;
        int upper = n - 1;        
        // 1
        // L
        // U
        // target = 1
        
        // 0,1,2,3,4,5
        // 5,7,7,8,8,10
        //       L m  U
        // target = 8
        // target = 6
        int position = -1;
        while (lower <= upper) {
            int mid = (lower + upper) / 2;
            
            if (nums[mid] == target) {
                position = mid;
                break;
            } else if (nums[mid] < target) {
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }
        if (position == -1) {
            return new int[] {-1, -1};
        }

        int lb = -1;
        if (position == 0 || nums[position - 1] != target) {
            lb = position;
        } else {
            lower = 0;
            upper = position - 1;
            while (lower <= upper) {
                if (nums[lower] == target) {
                    lb = lower;
                    break;
                } else {
                    int mid = (lower + upper) / 2;
                    if (nums[mid] == target) {
                        if (mid > 0 && nums[mid - 1] == target) {
                            upper = mid - 1;
                        } else {
                            lb = mid;
                            break;
                        }
                    } else {
                        lower = mid + 1;
                    }
                }
            }
        }        
        
        int rb = -1;
        if (position == n - 1 || nums[position + 1] != target) {
            rb = position;
        } else {
            lower = position + 1;
            upper = n - 1;
            while (lower <= upper) {
                if (nums[upper] == target) {
                    rb = upper;
                    break;
                } else {
                    int mid = (lower + upper) / 2;
                    if (nums[mid] == target) {
                        if (mid < n - 1 && nums[mid + 1] == target) {
                            lower = mid + 1;
                        } else {
                            rb = mid;
                            break;
                        }
                    } else {
                        upper = mid - 1;
                    }
                }
            }
        }
        
        return new int[] {lb, rb};
    }
}