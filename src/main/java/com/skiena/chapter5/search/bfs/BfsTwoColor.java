package com.skiena.chapter5.search.bfs;

import com.skiena.chapter5.dto.Graph;
import com.skiena.chapter5.dto.Vertex;
import com.skiena.chapter5.dto.VertexState;
import com.skiena.chapter5.search.SearchDataStructure;

public class BfsTwoColor extends BFS {

    private Color[] color;

    private boolean bipartide = true;

    public void twoColor(Graph graph) {
        color = new Color[graph.getNumberOfVertices() + 1];
        for (int i = 0; i <= graph.getNumberOfVertices(); i++) {
            color[i] = Color.UNCOLORED;
        }
        bipartide = true;

        SearchDataStructure state = new SearchDataStructure(graph.getNumberOfVertices());
        for (int i = 1; i <= graph.getNumberOfVertices(); i++) {
            Vertex vertex = graph.getVertex(i);

            if (state.getState(vertex) == VertexState.UNDISCOVERED) {
                color[i] = Color.WHITE;
                bfs(graph, vertex, state);
            }
        }

        for (int i = 0; i <= graph.getNumberOfVertices(); i++) {
            System.out.println(i + ": " + color[i]);
        }
    }

    public boolean isBipartide() {
        return bipartide;
    }

    @Override
    protected void processVertexEarly(Vertex vertex, SearchDataStructure state) {
        // nothing
    }

    @Override
    protected void processVertexLate(Vertex vertex) {
        // nothing
    }

    @Override
    protected void processEdge(Vertex current, Vertex successor) {
        if (color[current.getId()] == color[successor.getId()]) {
            bipartide = false;
            System.out.println("Warning");
        }
        color[successor.getId()] = color[current.getId()] == Color.WHITE ? Color.BLACK : Color.WHITE;
    }

    public enum Color {
        UNCOLORED,
        WHITE,
        BLACK;
    }

}
