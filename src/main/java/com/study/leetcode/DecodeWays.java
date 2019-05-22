package com.study.leetcode;

class DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();

        int ways0 = 1;
        int ways1 = 1;
        int ways2 = 1;

        char prevCh = s.charAt(0);
        for (int i = 1; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '0') {
                if (prevCh == '0' || prevCh > '2') {
                    return 0;
                } else {
                    ways2 = ways0;
                }
            } else if ((ch >= '1' && ch <= '9' && prevCh == '1')
                    || (ch >= '1' && ch <= '6' && prevCh == '2')) {
                if (i >= 2) {
                    ways2 = ways0 + ways1;
                } else {
                    ways2 = ways1 + 1;
                }
            } else {
                ways2 = ways1;
            }

            prevCh = ch;
            ways0 = ways1;
            ways1 = ways2;
        }

        return ways2;
    }

    public int numDecodingsDP(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int[] ways = new int[s.length()];
        ways[0] = 1;

        char prevCh = s.charAt(0);
        for (int i = 1; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '0') {
                if (prevCh == '0' || prevCh > '2') {
                    return 0;
                } else {
                    ways[i] = (i >= 2) ? ways[i - 2] : 1;
                }
            } else if ((ch >= '1' && ch <= '9' && prevCh == '1')
                    || (ch >= '1' && ch <= '6' && prevCh == '2')) {
                if (i >= 2) {
                    ways[i] = ways[i - 1] + ways[i - 2];
                } else {
                    ways[i] = ways[i - 1] + 1;
                }
            } else {
                ways[i] = ways[i - 1];
            }

            prevCh = ch;
        }

        return ways[n - 1];
    }

    public int numDecodingsBacktracking(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        counter = 0;
        
        backtracking(0, s);
        return counter;
    }
    
    private int counter;
    private void backtracking(int k, String s) {
        if (k >= s.length()) {
            counter++;
        } else {
            char ch = s.charAt(k);

            char nextCh = '$';
            if ((ch == '1' || ch == '2') && k < s.length() - 1) {
                nextCh = s.charAt(k + 1);
            }
            
            if (ch >= '1' && ch <= '9') {
                backtracking(k + 1, s);
            }
            
            if ((ch == '1' && nextCh >= '0' && nextCh <= '9')
                || (ch == '2' && nextCh >= '0' && nextCh <= '6')) {
                backtracking(k + 2, s);
            }
        }
    }

}