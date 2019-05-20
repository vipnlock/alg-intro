package com.study.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Atoi {

    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        Pattern pattern = Pattern.compile("^ *([+-]{0,1})(\\d+)");
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            return 0;
        }
        String sign = matcher.group(1);
        boolean plus = sign.isEmpty() || "+".equals(sign);
        String digits = matcher.group(2);

        int tmp = 0;
        for (int i = 0; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            if (plus) {
                if (tmp > Integer.MAX_VALUE / 10
                        || (tmp == Integer.MAX_VALUE / 10 && digit > 7)) {
                    return Integer.MAX_VALUE;
                }
                tmp = 10 * tmp + digit;
            } else {
                if (tmp < Integer.MIN_VALUE / 10
                        || (tmp == Integer.MIN_VALUE / 10 && digit > 8)) {
                    return Integer.MIN_VALUE;
                }
                tmp = 10 * tmp - digit;
            }
        }

        return tmp;
    }

}
