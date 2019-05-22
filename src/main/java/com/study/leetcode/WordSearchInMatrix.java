package com.study.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */
class WordSearchInMatrix {
    
    private static Point[] deltas = new Point[] {
        new Point(-1, 0),
        new Point(1, 0),
        new Point(0, -1),
        new Point(0, 1)
    };
    
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        if (word == null || word.isEmpty()) {
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        int w = word.length();
        
        Point[] points = new Point[w];
        return backtracking(points, 0, board, word);
    }
    
    private boolean backtracking(Point[] points, int k, char[][] board, String word) {
        if (k == word.length()) {
            return true;
        } else if (k == 0) {
            List<Point> starts = new LinkedList<>();
            char ch = word.charAt(0);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == ch) {
                        starts.add(new Point(i, j));
                    }
                }
            }
            for (Point start : starts) {
                points[0] = start;
                if (backtracking(points, 1, board, word)) {
                    return true;
                }
            }
        } else {
            Point cur = points[k - 1];
            char nextCh = word.charAt(k);
            List<Point> nextPoints = new LinkedList<>();
            for (int i = 0; i <= 3; i++) {
                int nextTryI = cur.i + deltas[i].i;
                int nextTryJ = cur.j + deltas[i].j;
                if (nextTryI >= 0 && nextTryI < board.length
                    && nextTryJ >= 0 && nextTryJ < board[0].length
                    && board[nextTryI][nextTryJ] == nextCh) {
                    Point tmp = new Point(nextTryI, nextTryJ);
                    boolean found = false;
                    for (int tt = 0; tt < k; tt++) {
                        if (points[tt].equals(tmp)) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        nextPoints.add(tmp);                        
                    }
                }
            }
            for (Point nextPoint : nextPoints) {
                points[k] = nextPoint;
                if (backtracking(points, k + 1, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static class Point {
        private int i;
        private int j;
        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
        
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            if (this == o) {
                return true;
            }
            if (o instanceof Point) {
                Point p = (Point) o;
                return this.i == p.i && this.j == p.j;
            } else {
                return false;
            }
        }
        
        public int hashCode() {
            return Objects.hash(this.i, this.j);
        }
    }
    
}