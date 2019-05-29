package com.study.leetcode;

import java.util.HashMap;
import java.util.Map;

class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        return fractionToDecimal((long) numerator, (long) denominator);
    }
    public String fractionToDecimal(long numerator, long denominator) {
        if (numerator == 0) {
            return "0";
        }

        boolean neg = false;
        if (denominator < 0) {
            neg = !neg;
        } else {
            denominator = -denominator;
        }
        if (numerator < 0) {
            neg = !neg;
        } else {
            numerator = -numerator;
        }
        StringBuilder sb = new StringBuilder();
        if (neg) {
            sb.append("-");
        }
        
        long quotient = numerator / denominator;
        long remainder = numerator % denominator;
        sb.append(quotient);
        
        if (remainder == 0) {
            return sb.toString();
        } else {
            sb.append(".");
            Map<Long, Integer> remsIndex = new HashMap<>();
            int index = 0;

            StringBuilder sb2 = new StringBuilder();
            while (remainder != 0 && !remsIndex.containsKey(remainder)) {
                remsIndex.put(remainder, index++);
                remainder *= 10;
                sb2.append(remainder / denominator);
                remainder %= denominator;
            }
            sb.append(sb2.toString());
            if (remainder != 0) {
                String tmp = sb2.toString().substring(remsIndex.get(remainder));
                sb.setLength(sb.length() - tmp.length());
                sb.append("(").append(tmp).append(")");
            }
        }
        
        return sb.toString();
    }
}