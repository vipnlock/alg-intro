package com.skiena.chapter5.simplestructure;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleBfs {

    private int vCount;
    private LinkedList<Integer>[] adj;
    private boolean directed;

    // BFS specific
    private boolean[] discovered;
    private boolean[] processed;
    private int[] parent;
    private Queue<Integer> queue;

    public SimpleBfs(int vCount, boolean directed) {
        this.vCount = vCount;
        this.directed = directed;

        this.adj = new LinkedList[vCount];
        for (int i = 0; i < vCount; i++) {
            this.adj[i] = new LinkedList<>();
        }

        // BFS specific
        this.discovered = new boolean[vCount];
        this.processed = new boolean[vCount];

        this.parent = new int[vCount];
        for (int i = 0; i < vCount; i++) {
            parent[i] = -1;
        }

        this.queue = new LinkedList<>();
    }

    public void addEdge(int i, int j) {
        adj[i].add(j);
    }

    public void bfs(int start) {
        discovered[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            Integer current = queue.poll();
            System.out.println("Process Vertex " + current);
            processed[current] = true;

            for (Integer next : adj[current]) {
                if (!processed[next] || directed) {
                    System.out.println("Process Edge (" + current + "->" + next + ")");
                }
                if (!discovered[next]) {
                    discovered[next] = true;
                    parent[next] = current;
                    queue.add(next);
                }
            }
            // System.out.println("Late process of vertex " + current);
        }
        printBfsTree(parent);
    }

    public static void main(String[] argv) {
        SimpleBfs g = new SimpleBfs(4, false);
        g.addEdge(0, 1);
        g.addEdge(1, 0);

        g.addEdge(0, 2);
        g.addEdge(2, 0);

        g.addEdge(1, 2);
        g.addEdge(2, 1);

        g.addEdge(1, 3);
        g.addEdge(3, 1);

        g.addEdge(3, 3);

        g.bfs(2);
    }

    private void printBfsTree(int[] parent) {
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                System.out.println(i + ": start of BFS");
            } else {
                printBfsTree(parent, i);
                System.out.println();
            }
        }
    }

    private void printBfsTree(int[] parent, int i) {
        if (parent[i] != -1) {
            printBfsTree(parent, parent[i]);
        }
        System.out.print(i + "->");
    }

}