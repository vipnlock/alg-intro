package com.skiena.chapter5.search;

import com.skiena.chapter5.dto.Graph;
import com.skiena.chapter5.dto.Vertex;
import com.skiena.chapter5.dto.VertexState;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class SearchDataStructure {

    private final Vertex[] parent;
    private final VertexState[] state;

    private final int[] entryTime;
    private final int[] exitTime;
    private int time = 0;

    public SearchDataStructure(int numberOfVertices) {
        this.parent = new Vertex[numberOfVertices + 1];
        this.state = new VertexState[numberOfVertices + 1];

        this.entryTime = new int[numberOfVertices + 1];
        this.exitTime = new int[numberOfVertices + 1];

        for (int i = 0; i <= numberOfVertices; i++) {
            parent[i] = null;
            state[i] = VertexState.UNDISCOVERED;
        }
    }

    public Vertex getParent(Vertex vertex) {
        return parent[vertex.getId()];
    }

    public VertexState getState(Vertex vertex) {
        return state[vertex.getId()];
    }

    public void setParent(Vertex vCurrent, Vertex vParent) {
        parent[vCurrent.getId()] = vParent;
    }

    public void markAsDiscovered(Vertex vertex) {
        state[vertex.getId()] = VertexState.DISCOVERED;
        entryTime[vertex.getId()] = ++time;
    }

    public void markAsProcessed(Vertex vertex) {
        state[vertex.getId()] = VertexState.PROCESSED;
        exitTime[vertex.getId()] = ++time;
    }

    public int getEntryTime(Vertex vertex) {
        return entryTime[vertex.getId()];
    }

    /*
     * Helper methods.
     */
    public void findPath(Vertex vStart, Vertex vEnd) {
        if (vEnd == null || vStart.getId() == vEnd.getId()) {
            System.out.print("Path: " + vStart);
        } else {
            findPath(vStart, parent[vEnd.getId()]);
            System.out.print(" -> " + vEnd);
        }
    }

    public void printSearchTree(Graph g, Vertex firstVertex) {
        System.out.println("Search tree:");
        for (Vertex leaf : findAllLeaves(g.getVertices(), parent)) {
            findPath(firstVertex, leaf);
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
