package com.study.leetcode;

class InverseInteger {
    public static void main(String[] argv) {
//        System.out.println(reverse( -(1 << 10 - 1)));
        System.out.println(reverseInt(123));
        System.out.println(reverseInt(-120));
        System.out.println(reverseInt(Integer.MIN_VALUE));
        System.out.println(reverseInt(Integer.MAX_VALUE));
    }

    public static int reverse(int x) {
        String xStr = Integer.toString(x);
        StringBuilder sb = new StringBuilder(xStr);
        String reversedStr = sb.reverse().toString();

        if (reversedStr.charAt(reversedStr.length() - 1) == '-') {
            reversedStr = "-" + reversedStr.substring(0, reversedStr.length() - 1);
        }
        try {
            return Integer.parseInt(reversedStr);
        } catch (Exception e) {
            return 0;
        }
    }

    public static int reverseInt(int x) {
        int res = 0;
        while (x != 0) {
            int rem = x % 10;
            x /= 10;

            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && rem > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && rem < -8)) {
                return 0;
            }
            res = 10 * res + rem;
        }
        return res;
    }

}