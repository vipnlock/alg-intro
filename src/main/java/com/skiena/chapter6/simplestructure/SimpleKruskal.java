package com.skiena.chapter6.simplestructure;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class SimpleKruskal {

    private int n;
    private LinkedList<Edge>[] adj;
    private boolean directed;

    public static class FullEdge {
        private int current;
        private int next;
        private int weight;
    }

    public static class Edge {
        private int next;
        private int weight;
    }

    public SimpleKruskal(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        this.adj = new LinkedList[n];

        for (int i = 0; i < n; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int i, int j, int w) {
        Edge edge = new Edge();
        edge.next = j;
        edge.weight = w;
        adj[i].add(edge);
        if (!directed) {
            edge = new Edge();
            edge.next = i;
            edge.weight = w;
            adj[j].add(edge);
        }
    }

    public void kruskal() {
        LinkedList<FullEdge> edges = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (Edge edge : adj[i]) {
                if (i <= edge.next) {
                    FullEdge fullEdge = new FullEdge();
                    fullEdge.current = i;
                    fullEdge.next = edge.next;
                    fullEdge.weight = edge.weight;
                    edges.add(fullEdge);
                }
            }
        }
        Collections.sort(edges, new Comparator<FullEdge>() {
            public int compare(FullEdge fe1, FullEdge fe2) {
                return Integer.compare(fe1.weight, fe2.weight);
            }
        });

        UnionFind unionSet = new UnionFind(n);
        while (!edges.isEmpty()) {
            FullEdge fe = edges.poll();
            if (!unionSet.isSame(fe.current, fe.next)) {
                System.out.println("Edge: " + fe.current + " -- " + fe.next);
                unionSet.union(fe.current, fe.next);
            }
        }
    }

    private static class UnionFind {
        private int[] root;
        private int[] size;

        public UnionFind(int n) {
            this.root = new int[n];
            this.size = new int[n];

            for (int i = 0; i < n; i++) {
                this.root[i] = i;
                this.size[i] = 1;
            }
        }

        public int find(int i) {
            if (i == root[i]) {
                return i;
            }
            return find(root[i]);
        }

        public void union(int i, int j) {
            int root1 = find(i);
            int root2 = find(j);
            int size1 = size[root1];
            int size2 = size[root2];

            if (size1 > size2) {
                size[root1] += size[root2];
                root[root2] = root1;
            } else {
                size[root2] += size[root1];
                root[root1] = root2;
            }
        }

        public boolean isSame(int i, int j) {
            int root1 = find(i);
            int root2 = find(j);
            return root1 == root2;
        }
    }

    public static void main(String[] argv) {
        SimpleKruskal g = new SimpleKruskal(8, false);
        g.addEdge(1, 3, 12);
        g.addEdge(3, 6, 7);
        g.addEdge(6, 7, 2);
        g.addEdge(7, 5, 5);
        g.addEdge(5, 2, 7);
        g.addEdge(2, 1, 5);
        g.addEdge(1, 4, 7);
        g.addEdge(3, 4, 4);
        g.addEdge(2, 4, 9);
        g.addEdge(4, 6, 3);
        g.addEdge(4, 5, 4);
        g.addEdge(5, 6, 2);
        g.kruskal();
    }
}
