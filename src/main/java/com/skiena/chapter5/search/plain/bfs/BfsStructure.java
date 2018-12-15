package com.skiena.chapter5.search.plain.bfs;

import com.skiena.chapter5.dto.Graph;
import com.skiena.chapter5.dto.Vertex;
import com.skiena.chapter5.dto.VertexState;

public class BfsStructure {

    private final VertexState[] state;
    private final Vertex[] parent;

    public BfsStructure(Graph g) {
        this.state = new VertexState[g.getVerticesCount() + 1];
        this.parent = new Vertex[g.getVerticesCount() + 1];

        // initialize
        for (int i = 0; i <= g.getVerticesCount(); i++) {
            state[i] = VertexState.UNDISCOVERED;
            parent[i] = null;
        }
    }

    void markDiscovered(Vertex discoverer, Vertex vertex) {
        state[vertex.getId()] = VertexState.DISCOVERED;
        parent[vertex.getId()] = discoverer;
    }

    void markProcessed(Vertex vertex) {
        state[vertex.getId()] = VertexState.PROCESSED;
    }

    boolean isUndiscovered(Vertex vertex) {
        return state[vertex.getId()] == VertexState.UNDISCOVERED;
    }

    boolean isProcessed(Vertex vertex) {
        return state[vertex.getId()] == VertexState.PROCESSED;
    }

    public Vertex[] getParent() {
        return parent;
    }

}
