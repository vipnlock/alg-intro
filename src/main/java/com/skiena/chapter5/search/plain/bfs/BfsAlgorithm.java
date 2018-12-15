package com.skiena.chapter5.search.plain.bfs;

import com.skiena.chapter5.dto.EdgeNode;
import com.skiena.chapter5.dto.Graph;
import com.skiena.chapter5.dto.Vertex;
import com.skiena.chapter5.search.plain.SearchStructure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class BfsAlgorithm {

    public SearchStructure bfs(Graph g, Vertex firstVertex) {
        final SearchStructure state = new SearchStructure(g);
        bfs(g, firstVertex, state);
        return state;
    }

    protected void bfs(Graph g, Vertex firstVertex, SearchStructure state) {
        final Queue<Vertex> queue = new LinkedList<>();

        // first vertex
        state.markDiscovered(firstVertex);
        state.setParent(null, firstVertex);
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
                    state.markDiscovered(vSuccessor);
                    state.setParent(vDiscoverer, vSuccessor);
                    queue.add(vSuccessor);
                }

                edgeNode = edgeNode.getNext();
            }

            process_Vertex_Late(vDiscoverer);
        }
    }

    public void connectedComponents(Graph g) {
        BfsAlgorithm alg = new BfsPrint();
        SearchStructure state = new SearchStructure(g);

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

    protected abstract void process_Vertex_Early(Vertex vertex);

    protected abstract void process_Vertex_Late(Vertex vertex);

    protected abstract void process_Edge(Vertex v1, Vertex v2);

}
