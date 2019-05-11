package com.skiena.chapter2;

public class StringPatternMatching {

    int findPatter(String text, String pattern) {
        int tl = text.length();
        int pl = pattern.length();
        char ch = pattern.charAt(0);

        for (int i = 0; i < tl; i++) {
            int j = 0;
            while (j < pl && text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }
            if (j == pl) {
                return i;
            }
        }
        return -1;
    }

}
