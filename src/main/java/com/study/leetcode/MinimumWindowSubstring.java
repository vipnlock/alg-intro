package com.study.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        int nl = s.length();
        int tl = t.length();

        Set<Character> targetSet = new HashSet<>();
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tl; i++) {
            Character tch = t.charAt(i);
            Integer count = map.get(tch);
            if (count != null) {
                map.put(tch, count + 1);
            } else {
                map.put(tch, 1);
            }
            targetSet.add(tch);
            set.add(tch);
        }

        int i = 0;
        int j = 0;
        int mini = 0;
        int minj = Integer.MAX_VALUE;
        while (j < nl) {
            char ch = s.charAt(j);

            Integer count = map.get(ch);
            if (count != null) {
                map.put(ch, count - 1);

                if (count - 1 == 0) {
                    set.remove(ch);
                }
                while (set.isEmpty()) {
                    if ((minj - mini) > (j - i)) {
                        mini = i;
                        minj = j;
                    }
                    char lch = s.charAt(i);
                    if (map.containsKey(lch)) {
                        int tmp = map.get(lch);
                        map.put(lch, tmp + 1);
                        if (tmp + 1 == 1) {
                            set.add(lch);
                        }
                    }
                    i++;
                }
            }

            j++;
        }

        return minj < Integer.MAX_VALUE ? s.substring(mini, minj + 1) : "";
    }
}