package com.study.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

    Only one letter can be changed at a time.
    Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Note:

    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.

Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.


Special adjacency lists approach:
*ot -> hot -> dot -> lot
h*t -> hot
ho* -> hot
d*t -> dot
do* -> dot -> dog
d*g -> dog
*og -> dog -> log -> cog
l*t -> lot
lo* -> lot -> log
l*g -> log
c*g -> cog
co* -> cog
 */
class WordLadder {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.isEmpty() || !wordList.contains(endWord)) {
            return 0;
        }
        int wordLen = beginWord.length();
        
        Map<String, List<String>> graph = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < wordLen; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> tmp = graph.get(newWord);
                if (tmp == null) {
                    tmp = new LinkedList<>();
                    graph.put(newWord, tmp);
                }
                tmp.add(word);
            }
        }
        
        Queue<Pair> queueBegin = new LinkedList<>();
        Queue<Pair> queueEnd = new LinkedList<>();
        queueBegin.add(new Pair(beginWord, 1));
        queueEnd.add(new Pair(endWord, 1));

        Map<String, Integer> visitedFromBegin = new HashMap<>();
        visitedFromBegin.put(beginWord, 1);
        Map<String, Integer> visitedFromEnd = new HashMap<>();
        visitedFromEnd.put(endWord, 1);

        while (!queueBegin.isEmpty() && !queueEnd.isEmpty()) {
            int tmp = bfs(graph, queueBegin, visitedFromBegin, visitedFromEnd,
                          wordLen);
            if (tmp != -1) {
                return tmp;
            }
            tmp = bfs(graph, queueEnd, visitedFromEnd, visitedFromBegin, wordLen);
            if (tmp != -1) {
                return tmp;
            }
        }
        
        return 0;
    }
    
    private int bfs(Map<String, List<String>> graph,
                    Queue<Pair> queue,
                    Map<String, Integer> visited,
                    Map<String, Integer> visitedOppositeWay, int wordLen) {
        Pair pair = queue.poll();
        String str = pair.str;
        int level = pair.level;
            
        for (int i = 0; i < wordLen; i++) {
            String newWord = str.substring(0, i) + "*" + str.substring(i + 1);
            if (graph.containsKey(newWord)) {
                for (String next : graph.get(newWord)) {
                    if (visitedOppositeWay.containsKey(next)) {
                        return level + visitedOppositeWay.get(next);
                    }
                    if (!visited.containsKey(next)) {
                        queue.add(new Pair(next, level + 1));
                        visited.put(next, level + 1);
                    }
                }
            }
        }
        return -1;
    }
    
    
    
    public int ladderLengthOneWayBFS(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.isEmpty()) {
            return 0;
        }
        int wordLen = beginWord.length();
        
        Map<String, List<String>> graph = new HashMap<>();
        
        for (String word : wordList) {
            for (int i = 0; i < wordLen; i++) {
                String newWord = word.substring(0, i) + '*'
                    + word.substring(i + 1, wordLen);
                
                List<String> adj = graph.get(newWord);
                if (adj == null) {
                    adj = new LinkedList<>();
                    graph.put(newWord, adj);
                }
                adj.add(word);
            }
        }
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        
        Set<String> visited = new HashSet<>();
        
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String word = pair.str;
            int level = pair.level;
            
            for (int i = 0; i < wordLen; i++) {
                String newWord = word.substring(0, i) + '*'
                    + word.substring(i + 1, wordLen);
                
                List<String> nextNodes = graph.get(newWord);
                if (nextNodes != null) {
                    for (String next : nextNodes) {
                        if (next.equals(endWord)) {
                            return level + 1;
                        }
                        
                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.add(new Pair(next, level + 1));
                        }
                    }
                }
            }
        }
        
        return 0;
    }
    
    private static class Pair {
        private String str;
        private int level;
        public Pair(String str, int level) {
            this.str = str;
            this.level = level;
        }
    }
}