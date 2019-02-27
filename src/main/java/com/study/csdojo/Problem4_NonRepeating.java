package com.study.csdojo;

import java.util.HashMap;
import java.util.Map;

public class Problem4_NonRepeating {

    Character nonRepeating(String s) {
        Map<Character, Integer> characters = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!characters.containsKey(ch)) {
                characters.put(ch, 1);
            } else {
                characters.put(ch, characters.get(ch) + 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (characters.get(ch) == 1) {
                return ch;
            }
        }
        return null;
    }

}
