package com.skiena.chapter5.search.bfs;

import com.skiena.chapter5.dto.Edge;
import com.skiena.chapter5.dto.Graph;
import com.skiena.chapter5.dto.Vertex;
import com.skiena.chapter5.dto.VertexState;
import com.skiena.chapter5.search.SearchDataStructure;

import java.util.LinkedList;
import java.util.Queue;

public abstract class BFS {

    public SearchDataStructure bfs(Graph graph, Vertex first) {
        final SearchDataStructure state = new SearchDataStructure(graph.getNumberOfVertices());
        bfs(graph, first, state);
        return state;
    }

    protected void bfs(Graph graph, Vertex firstVertext, SearchDataStructure state) {
        final Queue<Vertex> discoveredQueue = new LinkedList<>();

        // first vertex
        state.markAsDiscovered(firstVertext);
        state.setParent(firstVertext, null);
        discoveredQueue.add(firstVertext);

        // queue
        while (!discoveredQueue.isEmpty()) {
            final Vertex current = discoveredQueue.poll();

            processVertexEarly(current, state);
            state.markAsProcessed(current);

            Edge edge = graph.getEdges(current);
            while (edge != null) {
                Vertex successor = graph.getVertex(edge.getToVertexId());
                VertexState successorState = state.getState(successor);

                if (successorState != VertexState.PROCESSED || graph.isDirected()) {
                    processEdge(current, successor);
                }
                if (successorState == VertexState.UNDISCOVERED) {
                    state.markAsDiscovered(successor);
                    state.setParent(successor, current);
                    discoveredQueue.add(successor);
                }

                edge = edge.getNext();
            }

            processVertexLate(current);
        }
    }

    abstract void processVertexEarly(Vertex vertex, SearchDataStructure state);

    abstract void processVertexLate(Vertex vertex);

    abstract void processEdge(Vertex current, Vertex successor);

}
