package com.skiena.chapter5.search.plain;

import com.skiena.chapter5.dto.Graph;
import com.skiena.chapter5.dto.Vertex;
import com.skiena.chapter5.dto.VertexState;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class SearchStructure {

    private final VertexState[] state;
    private final Vertex[] parent;

    public SearchStructure(Graph g) {
        this.state = new VertexState[g.getVerticesCount() + 1];
        this.parent = new Vertex[g.getVerticesCount() + 1];

        // initialize
        for (int i = 0; i <= g.getVerticesCount(); i++) {
            state[i] = VertexState.UNDISCOVERED;
            parent[i] = null;
        }
    }

    public void setParent(Vertex discoverer, Vertex vertex) {
        parent[vertex.getId()] = discoverer;
    }
    public void markDiscovered(Vertex vertex) {
        state[vertex.getId()] = VertexState.DISCOVERED;
    }

    public void markProcessed(Vertex vertex) {
        state[vertex.getId()] = VertexState.PROCESSED;
    }

    public boolean isUndiscovered(Vertex vertex) {
        return state[vertex.getId()] == VertexState.UNDISCOVERED;
    }

    public boolean isProcessed(Vertex vertex) {
        return state[vertex.getId()] == VertexState.PROCESSED;
    }

    public Vertex[] getParent() {
        return parent;
    }
    public Vertex getParent(Vertex v) {
        return parent[v.getId()];
    }

    /*
     * Helper
     */

    public void findPath(Vertex vStart, Vertex vEnd, Vertex[] parent) {
        if (vEnd == null || vStart.getId() == vEnd.getId()) {
            System.out.print("Path: " + vStart);
        } else {
            findPath(vStart, parent[vEnd.getId()], parent);
            System.out.print(" -> " + vEnd);
        }
    }

    public void printSearchTree(Graph g, Vertex firstVertex) {
        for (Vertex leaf : findAllLeaves(g.getVertices(), parent)) {
            findPath(firstVertex, leaf, parent);
            System.out.println();
        }
    }

    private Set<Vertex> findAllLeaves(Vertex[] allVertices, Vertex[] parent) {
        Set<Integer> allParents = new HashSet<>();
        Arrays.stream(parent)
                .filter(Objects::nonNull)
                .forEach(vertex -> allParents.add(vertex.getId()));
        return Arrays.stream(allVertices)
                .filter(Objects::nonNull)
                .filter(vertex -> !allParents.contains(vertex.getId()))
                .collect(Collectors.toSet());
    }
}
