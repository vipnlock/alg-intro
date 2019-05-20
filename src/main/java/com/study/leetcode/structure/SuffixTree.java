package com.study.leetcode.structure;

import com.commons.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SuffixTree {

    // AB
    // () -A- () -B- () -$- [0:0]
    //    -B- () -$- [0:1]
    //    -$- [0:2]

    private Node root;
    private int wordCounter = 0;

    public SuffixTree() {
        this.root = new Node();
    }

    public void insert(String word) {
        int n = word.length();

        for (int i = 0; i < n; i++) {
            Node tmp = root;
            for (int j = i; j < n; j++) {
                char ch = word.charAt(j);
                if (tmp.has(ch)) {
                    tmp = tmp.get(ch);
                } else {
                    tmp = tmp.put(ch, wordCounter);
                }
            }
            tmp.terminate(wordCounter, i);
        }

        wordCounter++;
    }

    public boolean search(String substr) {
        Node tmp = root;

        for (int i = 0; i < substr.length(); i++) {
            char ch = substr.charAt(i);

            if (tmp.has(ch)) {
                tmp = tmp.get(ch);
            } else {
                return false;
            }
        }

        return true;
    }

    /*
     * Implementation is not finished...
     */
    public String longestCommonSubstring() {
        Pair<Integer, Set<Integer>> subtree = traverse(root, 0);
        if (subtree.getSecond().size() == 2) {
            return traverse(root, 0, subtree);
        }
        return null;
    }

    private boolean finished = false;
    private String traverse(Node tmp, int prefixLength, Pair<Integer, Set<Integer>> target) {
        List<Character> chars = new ArrayList<>(tmp.children.keySet());
        Collections.sort(chars);

        for (Character ch : chars) {
            Node next = tmp.children.get(ch);
            if (next.isTerm()) {
                if (prefixLength - 1 == target.getFirst() && ((Term) next).words().containsAll(target.getSecond())) {
                    finished = true;
                    return "";
                }
            } else {
                if (prefixLength == target.getFirst() && next.wordIds.containsAll(target.getSecond())) {
                    finished = true;
                    return "";
                }
                String str = traverse(tmp, prefixLength + 1, target);
                if (finished) {
                    return ch + str;
                }
            }
        }
        return null;
    }

    private Pair<Integer, Set<Integer>> traverse(Node tmp, int prefixLength) {
        List<Character> chars = new ArrayList<>(tmp.children.keySet());
        Collections.sort(chars);

        Set<Integer> wordIdsInSubtree = new HashSet<>();
        int maxPrefixLen = 0;

        for (Character ch : chars) {
            Node next = tmp.children.get(ch);
            if (next.isTerm()) {
                int origSize = wordIdsInSubtree.size();
                wordIdsInSubtree.addAll(((Term) next).words());
                if (origSize < wordIdsInSubtree.size()) {
                    maxPrefixLen = Math.max(maxPrefixLen, prefixLength);
                }
            } else {
                Pair<Integer, Set<Integer>> subtree = traverse(next, prefixLength + 1);
                int origSize = wordIdsInSubtree.size();
                wordIdsInSubtree.addAll(subtree.getSecond());
                tmp.wordIds.addAll(wordIdsInSubtree);
                if (origSize < wordIdsInSubtree.size()) {
                    maxPrefixLen = Math.max(maxPrefixLen, subtree.getFirst());
                }
            }
        }
        return Pair.of(maxPrefixLen, wordIdsInSubtree);
    }

    public static class Node {
        private Map<Character, Node> children = new HashMap<>();
        private Set<Integer> wordIds = new HashSet<>();

        public boolean has(Character ch) {
            return children.containsKey(ch);
        }

        public Node get(Character ch) {
            return children.get(ch);
        }
        public Node put(Character ch, int wordId) {
            Node tmp = new Node();
            children.put(ch, tmp);
            wordIds.add(wordId);
            return tmp;
        }



        public boolean isTerm() {
            return false;
        }

        public void terminate(int wordId, int position) {
            if (has('$')) {
                ((Term) get('$')).add(wordId, position);
            } else {
                children.put('$', new Term(wordId, position));
            }
        }
    }

    public static class Term extends Node {
        private Map<Integer, Integer> words;

        public Term(int wordId, int position) {
            words = new HashMap<>();
            add(wordId, position);
        }

        public void add(int wordId, int position) {
            words.put(wordId, position);
        }

        public boolean isTerm() {
            return true;
        }

        public Set<Integer> words() {
            return words.keySet();
        }
    }

}
