package com.study.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 */
class LongestSubstring {

    public int lengthBruteForce(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (allUnique(s, i, j)) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }

    private boolean allUnique(String s, int i, int j) {
        Set<Character> set = new HashSet<>();
        for (int k = i; k < j; k++) {
            Character ch = s.charAt(k);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    /*
     * Sliding window
     */

    int lengthSlidingWindow(String s) {
        int result = 0;

        Set<Character> set = new HashSet<>();
        int n = s.length();
        int i = 0, j = 0;

        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                result = Math.max(result, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return result;
    }

    /*
     * Sliding window with Direct index
     */

    int lengthSlidingWindowWithDirectIndex(String s) {
        int result = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            result = Math.max(result, j - i + 1);
            map.put(s.charAt(j), j);
        }

        return result;
    }


}