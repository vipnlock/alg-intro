package com.study.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        backtracking(s, 0, new LinkedList<>(), res);
        return res;
    }

    private void backtracking(String s, int start, List<String> tmp,
                              List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrom(s.substring(start, i + 1))) {
                    String pal = s.substring(start, i + 1);
                    tmp.add(pal);
                    backtracking(s, i + 1, tmp, res);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrom(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public List<List<String>> partitionDP_Backtracking(String s) {
        if (s.isEmpty()) {
            return Collections.emptyList();
        }
        int n = s.length();

        // P_i,i = true
        // P_i,i+1 = true, Si == Si+1
        // Pij = Pi+1j-1, Si == Sj
        // Pij = 0, Si != Sj

        boolean[][] p = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            p[i][i] = true;
            if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                p[i][i + 1] = true;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i + 1; j--) {
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(j);

                if (ch1 == ch2) {
                    p[i][j] = p[i + 1][j - 1];
                }
            }
        }

        List<List<String>> res = new LinkedList<>();

        int[] tmp = new int[n];
        backtracking(tmp, 0, s, p, res);

        return res;
    }

    private void backtracking(int[] tmp, int k, String word,
                              boolean[][] p, List<List<String>> res) {
        if (k != 0 && tmp[k - 1] == word.length() - 1) {
            List<String> part = new LinkedList<>();
            for (int i = 0; i < k; i++) {
                part.add(word.substring(i == 0 ? 0 : tmp[i - 1] + 1, tmp[i] + 1));
            }
            res.add(part);
        } else if (k == 0) {
            for (int i = 0; i < word.length(); i++) {
                if (p[0][i]) {
                    tmp[0] = i;
                    backtracking(tmp, 1, word, p, res);
                }
            }
        } else {
            for (int i = tmp[k - 1] + 1; i < word.length(); i++) {
                if (p[tmp[k - 1] + 1][i]) {
                    tmp[k] = i;
                    backtracking(tmp, k + 1, word, p, res);
                }
            }
        }
    }
    
}