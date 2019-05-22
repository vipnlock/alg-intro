package com.study.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }

        Map<String, List<String>> map = new HashMap();

        for (String str : strs) {
            if (str == null) {
                continue;
            }

            Map<Character, Integer> localmap = new TreeMap<>();
            for (int j = 0; j < str.length(); j++) {
                char nextCh = str.charAt(j);
                if (localmap.containsKey(nextCh)) {
                    localmap.put(nextCh, localmap.get(nextCh) + 1);
                } else {
                    localmap.put(nextCh, 1);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Character, Integer> entry : localmap.entrySet()) {
                sb.append(entry.getValue()).append(entry.getKey());
            }
            String chars = sb.toString();

            List<String> tmp = map.get(chars);
            if (tmp == null) {
                tmp = new ArrayList<>();
                map.put(chars, tmp);
            }

            tmp.add(str);
        }

        return new ArrayList<>(map.values());
    }
}