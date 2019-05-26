package com.study.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class MaxPointsOnLine {

    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int n = points.length;
        if (n <= 2) {
            return n;
        }

        Map<String, Set<Point>> lines = new HashMap<>();

        int totalMax = 0;

        for (int i = 0; i < n; i++) {
            Point p = new Point(i, points[i][0], points[i][1]);

            for (int j = i + 1; j < n; j++) {
                Point q = new Point(j, points[j][0], points[j][1]);
                String func = getFunction(p, q);
                Set<Point> set = lines.get(func);
                if (set == null) {
                    set = new HashSet<>();
                    lines.put(func, set);
                }
                set.add(p);
                set.add(q);
                totalMax = Math.max(totalMax, set.size());
            }
        }
        return totalMax;
    }

    public String getFunction(Point p, Point q) {
        if (p.x == q.x && p.y == q.y) {
            return p.x + ":" + p.y;
        }
        Point p1 = p.y > q.y ? p : q;
        Point p2 = p.y > q.y ? q : p;
        int b = p1.x - p2.x;
        int a = p1.y - p2.y;
        int c1 = a * p1.x - b * p1.y;
        int c2 = a * p2.x - b * p2.y;
        if (c1 != c2) {
            return "c1 != c2";
        }
        int gcd = gcd(Math.abs(a), Math.abs(b), Math.abs(c1));
        if (gcd != 0) {
            return (a / gcd) + "x-" + (b / gcd) + "y-" + (c1 / gcd);
        } else {
            return (a) + "x-" + (b) + "y-" + (c1);
        }
    }

    public static class Point {
        private int id;
        private int x;
        private int y;

        public Point(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null) {
                return false;
            }
            if (o instanceof Point) {
                Point p = (Point) o;
                return p.id == this.id;
            } else {
                return false;
            }
        }

        public int hashCode() {
            return Objects.hash(this.id);
        }
    }

    public int gcd(int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        } else if (x == 0) {
            return y;
        } else if (y == 0) {
            return x;
        }
        int t1 = x > y ? x : y;
        int t2 = x > y ? y : x;
        int r;
        while ((r = t1 % t2) != 0) {
            t1 = t2;
            t2 = r;
        }
        return t2;
    }

    public int gcd(int x, int y, int z) {
        int gcd = gcd(x, y);
        if (gcd == 0) {
            return z;
        } else if (gcd > 1) {
            return gcd(gcd, z);
        } else {
            return 1;
        }
    }

}