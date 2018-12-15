package com.skiena.chapter5.search.plain.dfs;

import com.skiena.chapter5.dto.EdgeNode;
import com.skiena.chapter5.dto.Graph;
import com.skiena.chapter5.dto.Vertex;
import com.skiena.chapter5.search.plain.SearchStructure;

public abstract class DfsAlgorithm {

    public SearchStructure dfs(Graph graph, Vertex firstVertex) {
        final SearchStructure state = new SearchStructure(graph);
        dfs(graph, firstVertex, state);
        return state;
    }

    private void dfs(Graph g, Vertex vDiscoverer, SearchStructure state) {
        state.markDiscovered(vDiscoverer);

        process_Vertex_Early(vDiscoverer);

        EdgeNode edgeNode = g.getEdges(vDiscoverer);
        while (edgeNode != null) {
            final int vSuccessorId = edgeNode.getVertexId();
            final Vertex vSuccessor = g.getVertex(vSuccessorId);

            if (state.isUndiscovered(vSuccessor)) {
                state.setParent(vDiscoverer, vSuccessor);
                process_Edge_Early(vDiscoverer, vSuccessor, EdgeType.TREE_EDGE);
                dfs(g, vSuccessor, state);
            }
            else if ((!state.isProcessed(vSuccessor) && state.getParent(vDiscoverer) != vSuccessor) || g.isDirected()) {
                process_Edge_Early(vDiscoverer, vSuccessor, EdgeType.BACK_EDGE);
            } else {
                process_Edge_Late(vDiscoverer, vSuccessor);
            }

            edgeNode = edgeNode.getNext();
        }

        process_Vertex_Late(vDiscoverer);
        state.markProcessed(vDiscoverer);
    }

    protected abstract void process_Vertex_Early(Vertex vertex);

    protected abstract void process_Vertex_Late(Vertex vertex);

    protected abstract void process_Edge_Early(Vertex v1, Vertex v2, EdgeType edgeType);

    protected abstract void process_Edge_Late(Vertex v1, Vertex v2);

}
