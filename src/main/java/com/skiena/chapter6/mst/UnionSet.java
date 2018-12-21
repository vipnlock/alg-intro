package com.skiena.chapter6.mst;

import com.skiena.chapter5.graph.Graph;
import com.skiena.chapter5.graph.Vertex;

/*
 * Union set == Subtree == Component.
 */
public class UnionSet {

    /**
     * Parent element.
     */
    private final Vertex[] parent;

    /**
     * Number of elements in subtree i.
     */
    private final int[] subtreeSize;

    /**
     * Number of elements in set.
     */
    private int size;

    public UnionSet(Graph graph) {
        size = graph.getNumberOfVertices();

        parent = new Vertex[size + 1];
        subtreeSize = new int[size + 1];

        for (int i = 1; i <= size; i++) {
            parent[i] = graph.getVertex(i);
            subtreeSize[i] = 1;
        }
    }

    public Vertex findRootOfSubtree(Vertex vertex) {
        if (parent[vertex.getId()] == vertex) {
            return vertex;
        } else {
            return findRootOfSubtree(parent[vertex.getId()]);
        }
    }

    public void unionSubtrees(Vertex v1, Vertex v2) {
        Vertex root1 = findRootOfSubtree(v1);
        Vertex root2 = findRootOfSubtree(v2);
        int root1Id = root1.getId();
        int root2Id = root2.getId();

        if (root1 == root2) {
            return;
        }

        if (subtreeSize[root1Id] >= subtreeSize[root2Id]) {
            parent[root2Id] = root1;
            subtreeSize[root1Id] += subtreeSize[root2Id];
        } else {
            parent[root1Id] = root2;
            subtreeSize[root2Id] += subtreeSize[root1Id];
        }
    }

    public boolean isSameComponent(Vertex v1, Vertex v2) {
        return findRootOfSubtree(v1) == findRootOfSubtree(v2);
    }

}
