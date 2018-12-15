package com.skiena.chapter5.search.plain.bfs;

import com.skiena.chapter5.dto.EdgeNode;
import com.skiena.chapter5.dto.Graph;
import com.skiena.chapter5.dto.Vertex;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class BfsAlgorithm {

    public BfsStructure bfs(Graph g, Vertex firstVertex) {
        BfsStructure state = new BfsStructure(g);
        bfs(g, firstVertex, state);
        return state;
    }

    private void bfs(Graph g, Vertex firstVertex, BfsStructure state) {
        final Queue<Vertex> queue = new LinkedList<>();

        // first vertex
        state.markDiscovered(null, firstVertex);
        queue.add(firstVertex);

        // queue
        while (!queue.isEmpty()) {
            final Vertex vDiscoverer = queue.poll();

            process_Vertex_Early(vDiscoverer);
            state.markProcessed(vDiscoverer);

            EdgeNode edgeNode = g.getEdges(vDiscoverer);
            while (edgeNode != null) {
                final int vSuccessorId = edgeNode.getVertexId();
                final Vertex vSuccessor = g.getVertex(vSuccessorId);

                if (!state.isProcessed(vSuccessor) || g.isDirected()) {
                    process_Edge(vDiscoverer, vSuccessor);
                }
                if (state.isUndiscovered(vSuccessor)) {
                    state.markDiscovered(vDiscoverer, vSuccessor);
                    queue.add(vSuccessor);
                }

                edgeNode = edgeNode.getNext();
            }

            process_Vertex_Late(vDiscoverer);
        }
    }

    public void findPath(Vertex vStart, Vertex vEnd, Vertex[] parent) {
        if (vEnd == null || vStart.getId() == vEnd.getId()) {
            System.out.print("Path: " + vStart);
        } else {
            findPath(vStart, parent[vEnd.getId()], parent);
            System.out.print(" -> " + vEnd);
        }
    }

    public void connectedComponents(Graph g) {
        BfsAlgorithm alg = new BfsPrint();
        BfsStructure state = new BfsStructure(g);

        int counter = 0;
        for (int i = 1; i <= g.getVerticesCount(); i++) {
            Vertex vertex = g.getVertex(i);

            if (state.isUndiscovered(vertex)) {
                System.out.println("Component " + ++counter);
                alg.bfs(g, vertex, state);
                System.out.println();
            }
        }
    }

    /*
     * Technical.
     */

    public void printBfsTree(Graph g, Vertex firstVertex, Vertex[] parent) {
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

    protected abstract void process_Vertex_Early(Vertex vertex);

    protected abstract void process_Vertex_Late(Vertex vertex);

    protected abstract void process_Edge(Vertex v1, Vertex v2);

}
