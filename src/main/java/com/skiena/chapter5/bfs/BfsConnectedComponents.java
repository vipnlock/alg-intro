package com.skiena.chapter5.bfs;

import com.skiena.chapter5.graph.Graph;
import com.skiena.chapter5.graph.Vertex;
import com.skiena.chapter5.graph.VertexState;
import com.skiena.chapter5.SearchDataStructure;

public class BfsConnectedComponents extends BFS {

    public void connectedComponents(Graph g) {
        SearchDataStructure state = new SearchDataStructure(g.getNumberOfVertices());

        int counter = 0;
        for (int i = 1; i <= g.getNumberOfVertices(); i++) {
            Vertex vertex = g.getVertex(i);

            if (state.getState(vertex) == VertexState.UNDISCOVERED) {
                System.out.println("Component " + ++counter);
                bfs(g, vertex, state);
                System.out.println();
            }
        }
    }


    @Override
    protected void processVertexEarly(Vertex vertex, SearchDataStructure state) {
        System.out.println(vertex);
    }

    @Override
    protected void processVertexLate(Vertex vertex) {

    }

    @Override
    protected void processEdge(Vertex v1, Vertex v2) {

    }

}
