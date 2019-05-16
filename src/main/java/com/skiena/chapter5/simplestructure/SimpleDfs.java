package com.skiena.chapter5.simplestructure;

import java.util.LinkedList;

public class SimpleDfs {

    private int n;  // number of vertices
    private LinkedList<Integer>[] adj;
    private boolean directed;

    // DFS specific
    private boolean finished = false;

    private int time;
    private int[] enter;
    private int[] exit;

    private boolean[] discovered;
    private boolean[] processed;
    private int[] parent;

    public SimpleDfs(int n, boolean directed) {
        this.n = n;
        this.directed = directed;

        this.adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            this.adj[i] = new LinkedList<>();
        }

        this.discovered = new boolean[n];
        this.processed = new boolean[n];
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            this.parent[i] = -1;
        }

        this.enter = new int[n];
        this.exit = new int[n];
    }

    public void addEdge(int i, int j) {
        adj[i].add(j);
        if (!directed && i != j) {
            adj[j].add(i);
        }
    }

    public void dfs(int current) {
        if (finished) {
            return;
        }

        discovered[current] = true;
        enter[current] = ++time;
        System.out.println("Early process vertex " + current);

        for (Integer next : adj[current]) {
            if (!discovered[next]) {
                parent[next] = current;
                System.out.println("Process Tree Edge (" + current + "->" + next + ")");
                dfs(next);
            } else if (!processed[next] && (parent[current] != next || directed)) {
                System.out.println("Process Back Edge (" + current + "->" + next + ")");
            } else if (processed[next] && directed) {
                if (enter[next] > enter[current]) {
                    System.out.println("Process FORWARD Edge (" + current + "->" + next + ")");
                }
                if (enter[next] < enter[current]) {
                    System.out.println("Process CROSS Edge (" + current + "->" + next + ")");
                }
            } else {
                System.out.println("-- Ignore same Edge (" + current + "->" + next + ")");
            }

            if (finished) {
                return;
            }
        }

        processed[current] = true;
        exit[current] = ++time;
        System.out.println("Late process vertex " + current);
    }

    private void printParentTree() {
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                System.out.println(i + ": start of DFS");
            } else {
                printParentTree(i);
            }
            System.out.println();
        }
    }

    private void printParentTree(int i) {
        if (parent[i] != -1) {
            printParentTree(parent[i]);
        }
        System.out.print(i + "->");
    }

    public static void main(String[] argv) {
        testUndirectedGraph();
        testDirectedGraph();
    }

    private static void testUndirectedGraph() {
        SimpleDfs g = new SimpleDfs(6, false);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(0, 5);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.dfs(0);
        g.printParentTree();
    }

    private static void testDirectedGraph() {
        SimpleDfs g = new SimpleDfs(6, true);
        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(0, 5);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 0);
        g.addEdge(5, 4);

        g.dfs(0);
        g.printParentTree();
    }

}
