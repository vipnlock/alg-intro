package com.study.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RegexpsMatching {

    public boolean isMatchRecursive(String s, String p) {
        if (s.isEmpty() && p.isEmpty()) {
            return true;
        } else if (p.isEmpty()) {
            return false;
        }

        boolean firstMatch = !s.isEmpty() && (
                s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() > 1 && p.charAt(1) == '*') {
            return firstMatch && isMatch(s.substring(1), p)
                    || isMatch(s, p.substring(2));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    /*
     * Dynamic Programming.
     */
    public boolean isMatch(String s, String p) {
        if (s.isEmpty() && p.isEmpty()) {
            return true;
        } else if (p.isEmpty()) {
            return false;
        }
        List<Part> parts = parsePattern(p);
        int pSize = parts.size();
        int sSize = s.length();

        int[][] m = new int[pSize + 1][sSize + 1];
        m[0][0] = 1;
        boolean starredStart = true;
        for (int i = 1; i <= pSize; i++) {
            starredStart &= parts.get(i - 1).star;
            m[i][0] = starredStart ? 1 : 0;
        }
        for (int j = 1; j <= sSize; j++) {
            m[0][j] = 0;
        }

        for (int i = 1; i <= pSize; i++) {
            Part part = parts.get(i - 1);

            for (int j = 1; j <= sSize; j++) {
                char ch = s.charAt(j - 1);

                if (part.ch == '.' && part.star) {
                    if (m[i - 1][j - 1] != 0) {
                        m[i][j] = m[i - 1][j - 1] + 1;
                    } else if (m[i][j - 1] != 0 || m[i - 1][j] != 0) {
                        m[i][j] = Math.max(m[i][j - 1], m[i - 1][j]);
                    } else {
                        m[i][j] = 0;
                    }
                } else if (part.star) {
                    if (ch == part.ch) {
                        if (m[i - 1][j - 1] != 0) {
                            m[i][j] = m[i - 1][j - 1] + 4;
                        } else if (m[i][j - 1] != 0) {
                            m[i][j] = m[i][j - 1] + 2;
                        } else if (m[i - 1][j] != 0) {
                            m[i][j] = m[i - 1][j];
                        } else {
                            m[i][j] = 0;
                        }
                    } else if (m[i - 1][j] != 0) {
                        m[i][j] = m[i - 1][j];
                    } else {
                        m[i][j] = 0;
                    }
                } else {
                    if ((ch == part.ch || part.ch == '.')
                            && m[i - 1][j - 1] != 0) {
                        m[i][j] = m[i - 1][j - 1] + 4;
                    } else {
                        m[i][j] = 0;
                    }
                }
            }
        }
        return m[pSize][sSize] != 0;
    }

    private List<Part> parsePattern(String p) {
        int pSize = p.length();

        List<Part> parts = new ArrayList<>();
        for (int i = 0; i < pSize; i++) {
            char ch = p.charAt(i);
            boolean star = i + 1 < pSize && p.charAt(i + 1) == '*';
            parts.add(new Part(ch, star));
            if (star) {
                i++;
            }
        }
        return parts;
    }

    private static class Part {
        private char ch;
        private boolean star;
        public Part(char ch, boolean star) {
            this.ch = ch;
            this.star = star;
        }
    }

}