package com.skiena.chapter6.shortestpath;

import java.util.Arrays;

public class Floyd {

    public void floyd(AdjacencyMatrix graph) {
        int[][] parent = new int[graph.getNumberOfVertices() + 1][graph.getNumberOfVertices() + 1];

        for (int k = 1; k <= graph.getNumberOfVertices(); k++) {
            for (int i = 1; i <= graph.getNumberOfVertices(); i++) {
                for (int j = 1; j <= graph.getNumberOfVertices(); j++) {
                    if (i == j) {
                        continue;
                    }
                    long throughK = (long)graph.getWeight(i, k) + graph.getWeight(k, j);
                    if (throughK < graph.getWeight(i, j)) {
                        graph.setWeight(i, j, (int) throughK);
                        parent[i][j] = k;
                    }
                }
            }
        }

        // parent matrix to reconstruct the actual shortest path between any given pair of vertices:
        // the shortest path from x to y is the concatenation of
        // - the shortest path from x to k with
        // - the shortest path from k to y, which can be reconstructed recursively given the matrix.
        System.out.println("Parent matrix:");
        for (int i = 0; i <= graph.getNumberOfVertices(); i++) {
            System.out.println(Arrays.toString(parent[i]));
        }
    }

}
