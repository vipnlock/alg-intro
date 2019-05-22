package com.study.leetcode;

class MyPow {
    public double myPow(double x, int n) {
        // x^n = ( (x ^ 2) ^ 2 ) ^ n/4;
        
        // n = 149
        // a^149 = a*(a^2)^74
        // a^148 = (a^2)^74
        //         a * b^74 = a * (b^2) ^ 37 ...
        
        if (n < 0) {
            return myPow(1 / x, -n);
        }
        if (n == 1) {
            return x;
        }
        
        if (n % 2 == 0) {
            return myPow(x * x, n >> 1);
        } else {
            return x * myPow(x * x, n >> 1);
        }
    }
}