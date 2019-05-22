package com.study.leetcode;

public class ZigZagConvertion {

    /*
     * 0123456789...
     * ->
     * 0      10
     * 1    9 11
     * 2   8  12
     * 3  7   13   ...
     * 4 6    14 16
     * 5      15
     * ->
     * 0 10 1 9 11 2 8 12 ...
     */
    public String stringToZigZag(String str, int n) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        int len = str.length();

        int bigStep = 2 * (n - 1);

        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < n; row++) {
            int j = row;

            if (row == 0 || row == n - 1) {
                while (j < len) {
                    sb.append(str.charAt(j));
                    j += bigStep;
                }
            } else {
                int step1 = 2 * (n - 1 - row);
                int step2 = bigStep - step1;

                boolean flag = true;
                while (j < len) {
                    sb.append(str.charAt(j));
                    j += flag ? step1 : step2;
                    flag = !flag;
                }
            }
        }
        return sb.toString();
    }

}
