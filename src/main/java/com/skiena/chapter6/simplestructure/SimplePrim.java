package com.skiena.chapter6.simplestructure;

import java.util.Arrays;
import java.util.LinkedList;

public class SimplePrim {

    private int n;
    private LinkedList<Edge>[] adj;
    private boolean directed;

    private static class Edge {
        private int next;
        private int weight;
    }

    private boolean[] inTree;
    private int[] distance;
    private int[] parent;

    public SimplePrim(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        this.adj = new LinkedList[n];

        this.inTree = new boolean[n];
        this.distance = new int[n];
        this.parent = new int[n];

        for (int i = 0; i < n; i++) {
            this.adj[i] = new LinkedList<>();
            this.distance[i] = Integer.MAX_VALUE;
            this.parent[i] = -1;
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

    public void prim(int start) {
        distance[start] = 0;
        int current = start;

        while (!inTree[current]) {
            inTree[current] = true;

            // recalculate distances
            for (Edge edge : adj[current]) {
                if (!inTree[edge.next] && distance[edge.next] > edge.weight) {
                    distance[edge.next] = edge.weight;
                    parent[edge.next] = current;
                }
            }

            // choose next closest vertex
            int minWeight = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!inTree[i] && minWeight > distance[i]) {
                    minWeight = distance[i];
                    current = i;
                }
            }
        }
    }

    public void printTree() {
        System.out.println(Arrays.toString(parent));

        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                System.out.println("Tree root: " + i);
            } else {
                System.out.println("Edge: " + i + " -- " + parent[i]);
            }
        }
    }

    public static void main(String[] argv) {
        SimplePrim g = new SimplePrim(7, false);
        g.addEdge(0, 2, 12);
        g.addEdge(2, 5, 7);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 4, 5);
        g.addEdge(4, 1, 7);
        g.addEdge(1, 0, 5);
        g.addEdge(0, 3, 7);
        g.addEdge(2, 3, 4);
        g.addEdge(1, 3, 9);
        g.addEdge(3, 5, 3);
        g.addEdge(3, 4, 4);
        g.addEdge(4, 5, 2);
        g.prim(0);

        g.printTree();
    }
}
