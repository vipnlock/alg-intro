package com.study.leetcode.structure;

import com.commons.Pair;

import java.util.Arrays;
import java.util.Comparator;

public class SuffixArray {

    public String[] words;

    // wordId, position
    public Pair<Integer, Integer>[] suffixes;

    // Longest Common Prefix
    public int[] lcp;

    public SuffixArray(String ... words) {
        this.words = new String[words.length];

        int totalLen = 0;
        for (int wCtr = 0; wCtr < words.length; wCtr++) {
            this.words[wCtr] = words[wCtr];
            totalLen += words[wCtr].length();
        }

        this.suffixes = new Pair[totalLen];
        this.lcp = new int[totalLen];
        int sCtr = 0;
        for (int wCtr = 0; wCtr < words.length; wCtr++) {
            String nextWord = words[wCtr];

            for (int i = 0; i < nextWord.length(); i++) {
                suffixes[sCtr++] = Pair.of(wCtr, i);
            }
        }

        Arrays.sort(suffixes, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return words[o1.getFirst()].substring(o1.getSecond())
                        .compareTo(words[o2.getFirst()].substring(o2.getSecond()));
            }
        });
        longestCommonPrefix();
    }

    public boolean search(String substr) {
        int lower = 0;
        int upper = suffixes.length;
        while (lower < upper) {
            int mid = (lower + upper) / 2;

            Pair<Integer, Integer> suffixPair = suffixes[mid];
            String suffix = words[suffixPair.getFirst()].substring(suffixPair.getSecond());

            String compareTo = suffix.length() > substr.length() ? suffix.substring(0, substr.length()) : suffix;
            if (substr.compareTo(compareTo) == 0) {
                return true;
            } else if (substr.compareTo(compareTo) > 0) {
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }
        return false;
    }

    public void longestCommonPrefix() {
        for (int i = 1; i < suffixes.length; i++) {
            lcp[i - 1] = 0;

            int minLen = Math.min(words[suffixes[i - 1].getFirst()].length() - suffixes[i - 1].getSecond(),
                    words[suffixes[i].getFirst()].length() - suffixes[i].getSecond());

            String word1 = words[suffixes[i - 1].getFirst()].substring(suffixes[i - 1].getSecond());
            String word2 = words[suffixes[i].getFirst()].substring(suffixes[i].getSecond());
            for (int j = 0; j < minLen; j++) {
                if (word1.charAt(j) == word2.charAt(j)) {
                    lcp[i - 1]++;
                }
            }
        }
    }

    public String longestCommonSubstring() {
        int maxIndex = -1;
        for (int i = 1; i < lcp.length; i++) {
            if (!suffixes[i - 1].getFirst().equals(suffixes[i].getFirst())) {
                maxIndex = i - 1;
                break;
            }
        }
        for (int i = maxIndex + 2; i < lcp.length; i++) {
            if (lcp[maxIndex] < lcp[i - 1] && !suffixes[i - 1].getFirst().equals(suffixes[i].getFirst())) {
                maxIndex = i - 1;
            }
        }
        return words[suffixes[maxIndex].getFirst()].substring(suffixes[maxIndex].getSecond(), suffixes[maxIndex].getSecond() + lcp[maxIndex]);
    }

    public void print() {
        for (int i = 0; i < suffixes.length; i++) {
            Pair<Integer, Integer> nextSuffix = suffixes[i];

            System.out.println(nextSuffix.getFirst() + "." + nextSuffix.getSecond() + "." + lcp[i] + " : " + words[nextSuffix.getFirst()].substring(nextSuffix.getSecond()));
        }
    }

}
