package com.skiena.chapter5.search.dfs;

import com.skiena.chapter5.dto.Edge;
import com.skiena.chapter5.dto.EdgeType;
import com.skiena.chapter5.dto.Graph;
import com.skiena.chapter5.dto.Vertex;
import com.skiena.chapter5.dto.VertexState;

public abstract class DFS {

    public DfsDataStructure dfs(Graph graph, Vertex first) {
        DfsDataStructure state = new DfsDataStructure(graph.getNumberOfVertices());
        dfs(graph, first, state);
        return state;
    }

    protected void dfs(Graph graph, Vertex current, DfsDataStructure state) {
        if (state.isFinished()) {
            return;
        }
        state.markAsDiscovered(current);

        processVertexEarly(current, state);

        Edge edge = graph.getEdges(current);
        while (edge != null) {
            final Vertex successor = graph.getVertex(edge.getToVertexId());
            final VertexState successorState = state.getState(successor);

            if (successorState == VertexState.UNDISCOVERED) {
                state.setParent(successor, current);
                processEdgeFirst(current, successor, EdgeType.TREE, state);
                dfs(graph, successor, state);

            } else if (successorState != VertexState.PROCESSED && (state.getParent(current) != successor || graph.isDirected())) {
                processEdgeFirst(current, successor, EdgeType.BACK, state);

            } else if (successorState == VertexState.PROCESSED && graph.isDirected()) {
                if (state.getEntryTime(successor) > state.getEntryTime(current)) {
                    processEdgeFirst(current, successor, EdgeType.FORWARD, state);
                }
                if (state.getEntryTime(successor) < state.getEntryTime(current)) {
                    processEdgeFirst(current, successor, EdgeType.CROSS, state);
                }

            } else {
                processEdgeSecond(current, successor);
            }

            if (state.isFinished()) {
                return;
            }
            edge = edge.getNext();
        }

        processVertexLate(current, state);
        state.markAsProcessed(current);
    }

    abstract void processVertexEarly(Vertex vertex, DfsDataStructure state);
    abstract void processVertexLate(Vertex vertex, DfsDataStructure state);

    abstract void processEdgeFirst(Vertex current, Vertex successor, EdgeType edgeType, DfsDataStructure state);
    abstract void processEdgeSecond(Vertex current, Vertex successor);

}
