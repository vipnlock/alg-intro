package com.skiena.chapter5.search.plain.bfs;

import com.skiena.chapter5.dto.Graph;
import com.skiena.chapter5.dto.Vertex;
import com.skiena.chapter5.search.plain.SearchStructure;

public class BfsConnectedComponents extends BfsAlgorithm {

    public void connectedComponents(Graph g) {
        SearchStructure state = new SearchStructure(g);

        int counter = 0;
        for (int i = 1; i <= g.getVerticesCount(); i++) {
            Vertex vertex = g.getVertex(i);

            if (state.isUndiscovered(vertex)) {
                System.out.println("Component " + ++counter);
                bfs(g, vertex, state);
                System.out.println();
            }
        }
    }


    @Override
    protected void process_Vertex_Early(Vertex vertex) {
        System.out.println(vertex);
    }

    @Override
    protected void process_Vertex_Late(Vertex vertex) {

    }

    @Override
    protected void process_Edge(Vertex v1, Vertex v2) {

    }

}
