package com.study.leetcode;

import java.util.List;

class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);
                if (wordDict.contains(sub) && dp[j + 1]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }

    public boolean wordBreakDP_FROM_BEGIN(String s, List<String> wordDict) {
        /*
         * dp[i] shows:
         * whether the string ending at but not including s[i] can be made up exclusively of dict words
         */
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        // s:  catsandog
        // i:  |   |
        // j:
        for (int i = 0; i < s.length(); i++) {
            if (!dp[i]) {
                continue;
            }
            for (int j = i + 1; j <= s.length(); j++) {
                if (dp[j]) {
                    continue;
                }
                if (wordDict.contains(s.substring(i, j))) {
                    dp[j] = dp[i];
                }
            }
        }
        return dp[s.length()];
    }

    /*
     * Recursion + Memoization.
     */
    public boolean wordBreakRecursionAndMemoization(String s, List<String> wordDict) {
        boolean[] cache = new boolean[s.length()];
        return check(s, 0, wordDict, cache);
    }

    private boolean check(String s, int i, List<String> dict,
                          boolean[] cache) {
        if (i == s.length()) {
            return true;
        }
        if (cache[i]) {
            return false;
        }
        String str = s.substring(i);

        for (String word : dict) {
            if (str.startsWith(word)) {
                boolean tmp = check(s, i + word.length(), dict, cache);
                if (tmp) {
                    return true;
                }
            }
        }
        cache[i] = true;
        return false;
    }

}