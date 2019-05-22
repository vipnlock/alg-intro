package com.study.leetcode;

class Sqrt {
    public int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        
        int lower = 1;
        int upper = x;
        
        while (lower < upper) {
            int mid = (lower + upper) / 2;

            int tmp = x / mid;
            if (tmp == mid) {
                return mid;
            } else if (tmp > mid) {
                upper = mid - 1;
            } else {
                lower = mid + 1;
            }
        }
        return lower * lower <= x ? lower : lower - 1;
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int lower = 1;
        int upper = x;

        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;

            int tmp = x / mid;
            if (tmp == mid) {
                return mid;
            } else if (tmp < mid) {
                upper = mid - 1;
            } else if (x / (mid + 1) < mid + 1) {
                return mid;
            } else {
                lower = mid + 1;
            }
        }
        return lower * lower <= x ? lower : lower - 1;
    }

}