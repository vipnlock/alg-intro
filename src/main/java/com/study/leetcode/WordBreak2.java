package com.study.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> dict = new HashSet<>(wordDict);

        boolean[] dp = new boolean[n + 1];
        // everything to the right of the given string (i.e. empty string)
        // can be broke up into dictionary words.
        dp[n] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);
                if (dict.contains(sub) && dp[j + 1]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        List<String> res = new LinkedList<>();
        backtracking(s, 0, sb, dict, dp, res);

        return res;
    }

    private void backtracking(String s, int start, StringBuilder sb,
                              Set<String> dict,
                              boolean[] dp,
                              List<String> res) {
        int n = s.length();
        if (start == n) {
            res.add(sb.toString());

        } else {
            for (int j = start; j < n; j++) {
                String sub = s.substring(start, j + 1);
                if (dict.contains(sub) && dp[j + 1]) {
                    int origLen = sb.length();
                    if (start != 0) {
                        sb.append(" ");
                    }
                    sb.append(sub);
                    backtracking(s, j + 1, sb, dict, dp, res);
                    sb.setLength(origLen);
                }
            }
        }
    }

}