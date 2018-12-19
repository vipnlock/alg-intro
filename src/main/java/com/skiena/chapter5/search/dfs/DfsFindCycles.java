package com.skiena.chapter5.search.dfs;

import com.skiena.chapter5.dto.EdgeType;
import com.skiena.chapter5.dto.Vertex;

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

        if (edgeType == EdgeType.BACK_EDGE) {
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
