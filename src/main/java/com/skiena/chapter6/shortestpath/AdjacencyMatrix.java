package com.skiena.chapter6.shortestpath;

import java.util.Arrays;

public class AdjacencyMatrix {

    /**
     *  unweighted graphs: denote graph edges by 1 and non-edges by 0.
     *  This gives exactly the wrong interpretation if the numbers denote edge weights,
     *  for the non-edges get interpreted as a free ride between vertices.
     *  Instead, we should initialize each non-edge to MAXINT.
     *  This way we can both test whether it is present and automatically ignore it in shortest-path computations.
     */
    private int[][] weight; // adjacency / weight info

    private int numberOfVertices;

    public AdjacencyMatrix(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        this.weight = new int[numberOfVertices + 1][numberOfVertices + 1];

        for (int i = 0; i <= numberOfVertices; i++) {
            for (int j = 0; j <= numberOfVertices; j++) {
                weight[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public void setWeight(int i, int j, int w) {
        weight[i][j] = w;
    }
    public void setWeightUndirected(int i, int j, int w) {
        weight[i][j] = w;
        weight[j][i] = w;
    }
    public int getWeight(int i, int j) {
        return weight[i][j];
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    /*
     * Helper methods.
     */

    @Override
    public String toString() {
        var sb = new StringBuilder("Graph (" + numberOfVertices + " vertices): \n");
        for (int[] ints : weight) {
            sb.append(Arrays.toString(ints)).append("\n");
        }
        return sb.toString();
    }
}
