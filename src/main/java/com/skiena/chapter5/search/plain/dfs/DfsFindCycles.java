package com.skiena.chapter5.search.plain.dfs;

import com.skiena.chapter5.dto.Vertex;
import com.skiena.chapter5.search.plain.SearchStructure;

import java.util.Arrays;

public class DfsFindCycles extends DfsAlgorithm {

    @Override
    protected void process_Vertex_Early(Vertex vertex) {

    }

    @Override
    protected void process_Vertex_Late(Vertex vertex) {

    }

    @Override
    protected void process_Edge_Early(Vertex v1, Vertex v2, EdgeType edgeType, SearchStructure state) {
        System.out.println("Edge: " + v1 + " -> " + v2);
        if (edgeType == EdgeType.BACK_EDGE) {
            System.out.println("Cycle found: ");
            state.findPath(v2, v1, state.getParent());
            System.out.println();
            System.out.println("Parent: " + Arrays.toString(state.getParent()));
            finished = true;
        }
    }

    @Override
    protected void process_Edge_Late(Vertex v1, Vertex v2) {

    }

}
