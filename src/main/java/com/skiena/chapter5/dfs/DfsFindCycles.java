package com.skiena.chapter5.dfs;

import com.skiena.chapter5.graph.EdgeType;
import com.skiena.chapter5.graph.Vertex;

public class DfsFindCycles extends DFS {

    @Override
    protected void processVertexEarly(Vertex vertex, DfsDataStructure state) {
        // nothing
    }

    @Override
    protected void processVertexLate(Vertex vertex, DfsDataStructure state) {
        // nothing
    }

    @Override
    protected void processEdgeFirst(Vertex current, Vertex successor, EdgeType edgeType, DfsDataStructure state) {
        System.out.println("Edge: " + current + " -> " + successor);

        if (edgeType == EdgeType.BACK) {
            System.out.println("Cycle found: ");
            state.findPath(successor, current);
            state.finish();
        }
    }

    @Override
    protected void processEdgeSecond(Vertex v1, Vertex v2) {
        // nothing
    }

}
