package com.study.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class SurroundedRegions {
    
    private static Point[] deltas = new Point[] {
        new Point(-1, 0),
        new Point(1, 0),
        new Point(0, -1),
        new Point(0, 1)
    };
    
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        
        Queue<Point> queue = new LinkedList<>();
        // connected components
        int[][] cc = new int[m][n];
        // connected component's number
        int ccn = 0;
        Set<Integer> allCC = new HashSet<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && cc[i][j] == 0) {
                    queue.add(new Point(i, j));

                    allCC.add(++ccn);
                    while (!queue.isEmpty()) {
                        Point next = queue.poll();
                        cc[next.i][next.j] = ccn;
                        
                        for (int k = 0; k < 4; k++) {
                            Point delta = deltas[k];
                            int nextI = next.i + delta.i;
                            int nextJ = next.j + delta.j;
                            if (nextI >= 0 && nextI < m
                                && nextJ >= 0 && nextJ < n
                                && board[nextI][nextJ] == 'O'
                                && cc[nextI][nextJ] == 0) {
                                queue.add(new Point(nextI, nextJ));
                                cc[nextI][nextJ] = -1;
                            }
                        }
                    }
                }
            }
        }
        
        int i = 0;
        int j = 0;
        while (i < m) {
            if (board[i][0] == 'O') {
                allCC.remove(cc[i][0]);
            }
            if (board[i][n - 1] == 'O') {
                allCC.remove(cc[i][n - 1]);
            }
            i++;
        }
        while (j < n) {
            if (board[0][j] == 'O') {
                allCC.remove(cc[0][j]);
            }
            if (board[m - 1][j] == 'O') {
                allCC.remove(cc[m - 1][j]);
            }
            j++;
        }
        
        for (i = 1; i < m - 1; i++) {
            for (j = 1; j < n - 1; j++) {
                if (allCC.contains(cc[i][j])) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private static class Point {
        private final int i;
        private final int j;
        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}