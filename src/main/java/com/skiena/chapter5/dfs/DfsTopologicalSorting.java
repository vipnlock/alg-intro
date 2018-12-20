package com.skiena.chapter5.dfs;

import com.skiena.chapter5.graph.EdgeType;
import com.skiena.chapter5.graph.Graph;
import com.skiena.chapter5.graph.Vertex;
import com.skiena.chapter5.graph.VertexState;

import java.util.LinkedList;

public class DfsTopologicalSorting extends DFS {

    private LinkedList<Vertex> stack;

    public void topSort(Graph graph) {
        stack = new LinkedList<>();

        final DfsDataStructure state = new DfsDataStructure(graph.getNumberOfVertices());
        for (int i = 1; i <= graph.getNumberOfVertices(); i++) {
            Vertex vertex = graph.getVertex(i);
            if (state.getState(vertex) == VertexState.UNDISCOVERED) {
                dfs(graph, vertex, state);
            }
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    @Override
    void processVertexEarly(Vertex vertex, DfsDataStructure state) {
    }

    @Override
    void processVertexLate(Vertex vertex, DfsDataStructure state) {
        stack.push(vertex);
    }

    @Override
    void processEdgeFirst(Vertex current, Vertex successor, EdgeType edgeType, DfsDataStructure state) {
        if (edgeType == EdgeType.BACK) {
            System.out.println("Warning: directed cycle found, not a DAG");
        }
    }

    @Override
    void processEdgeSecond(Vertex current, Vertex successor) {

    }
}
