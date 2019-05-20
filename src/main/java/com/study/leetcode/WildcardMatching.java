package com.study.leetcode;

class WildcardMatching {

    /*
     * Backtracking.
     */
    public boolean isMatch(String s, String p) {
        if (s.isEmpty() && p.isEmpty()) {
            return true;
        } else if (p.isEmpty()) {
            return false;
        }
        int sn = s.length();
        int pn = p.length();
        int sidx = 0;
        int pidx = 0;

        int starpidx = -1;
        int starsidx = -1;

        // aa
        // a

        // aa
        // *

        // ab
        // *?
        while (sidx < sn) {
            if (pidx < pn && (s.charAt(sidx) == p.charAt(pidx)
                    || p.charAt(pidx) == '?')) {
                sidx++;
                pidx++;
            } else if (pidx < pn && p.charAt(pidx) == '*') {
                starpidx = ++pidx;
                starsidx = sidx;
            } else if (starpidx != -1) {
                sidx = ++starsidx;
                pidx = starpidx;
            } else {
                return false;
            }
        }

        while (pidx < pn) {
            if (p.charAt(pidx++) != '*') {
                return false;
            }
        }
        return true;
    }

    public boolean isMatchRecursive(String s, String p) {
        if (s.isEmpty() && p.isEmpty()) {
            return true;
        } else if (p.isEmpty()) {
            return false;
        }

        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0)
                || p.charAt(0) == '?'
                || p.charAt(0) == '*');

        if (p.charAt(0) == '*') {
            return firstMatch && isMatchRecursive(s.substring(1), p)
                    || isMatchRecursive(s, p.substring(1));
        } else {
            return firstMatch && isMatchRecursive(s.substring(1), p.substring(1));
        }
    }

    public boolean isMatchDP(String s, String p) {
        if (s.isEmpty() && p.isEmpty()) {
            return true;
        } else if (p.isEmpty()) {
            return false;
        }

        int[][] m = new int[p.length() + 1][s.length() + 1];
        m[0][0] = 1;
        boolean starredStart = true;
        for (int i = 1; i <= p.length(); i++) {
            starredStart &= p.charAt(i - 1) == '*';
            m[i][0] = starredStart ? 1 : 0;
        }
        for (int j = 1; j <= s.length(); j++) {
            m[0][j] = 0;
        }

        for (int i = 1; i <= p.length(); i++) {
            char pch = p.charAt(i - 1);

            for (int j = 1; j <= s.length(); j++) {
                char sch = s.charAt(j - 1);

                if (pch == '*') {
                    if (m[i - 1][j - 1] != 0) {
                        m[i][j] = m[i - 1][j - 1] + 1;
                    } else if (m[i][j - 1] != 0 || m[i - 1][j] != 0) {
                        m[i][j] = Math.max(m[i][j - 1], m[i - 1][j]);
                    } else {
                        m[i][j] = 0;
                    }

                } else if (pch == '?' || pch == sch) {
                    if (m[i - 1][j - 1] != 0) {
                        m[i][j] = m[i - 1][j - 1] + 1;
                    } else {
                        m[i][j] = 0;
                    }
                } else {
                    m[i][j] = 0;
                }
            }
        }

        return m[p.length()][s.length()] != 0;
    }
}