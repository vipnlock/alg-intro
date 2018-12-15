package com.skiena.chapter5.search.plain.bfs;

import com.skiena.chapter5.dto.Graph;
import com.skiena.chapter5.dto.Vertex;
import com.skiena.chapter5.search.plain.SearchStructure;

public class BfsTwoColor extends BfsAlgorithm {

    private Color[] color;

    private boolean bipartide = true;

    public void twoColor(Graph graph) {
        color = new Color[graph.getVerticesCount() + 1];
        for (int i = 0; i <= graph.getVerticesCount(); i++) {
            color[i] = Color.UNCOLORED;
        }
        bipartide = true;

        SearchStructure state = new SearchStructure(graph);
        for (int i = 1; i <= graph.getVerticesCount(); i++) {
            Vertex vertex = graph.getVertex(i);

            if (state.isUndiscovered(vertex)) {
                color[i] = Color.WHITE;
                bfs(graph, vertex, state);
            }
        }

        for (int i = 0; i <= graph.getVerticesCount(); i++) {
            System.out.println(i + ": " + color[i]);
        }
    }

    @Override
    protected void process_Vertex_Early(Vertex vertex) {
        // nothing
    }

    @Override
    protected void process_Vertex_Late(Vertex vertex) {
        // nothing
    }

    @Override
    protected void process_Edge(Vertex v1, Vertex v2) {
        if (color[v1.getId()] == color[v2.getId()]) {
            bipartide = false;
            System.out.println("Warning");
        }
        color[v2.getId()] = color[v1.getId()] == Color.WHITE ? Color.BLACK : Color.WHITE;
    }

    public enum Color {
        UNCOLORED,
        WHITE,
        BLACK;
    }

}
