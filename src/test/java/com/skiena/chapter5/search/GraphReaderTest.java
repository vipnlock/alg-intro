package com.skiena.chapter5.search;

import com.skiena.chapter5.dto.Edge;
import com.skiena.chapter5.dto.Graph;
import com.skiena.chapter5.dto.Vertex;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GraphReaderTest {

    @Test
    @DisplayName("Directed graph")
    void testDirected() throws IOException {
        Graph g = TestGraphSource.directedGraph();

        compareEdges(g, 1, 2, 6);
        compareEdges(g, 2, 3, 5);
        compareEdges(g, 3, 4);
        compareEdges(g, 4, 5);
        compareEdges(g, 5, 1);
        compareEdges(g, 6);
    }

    @Test
    @DisplayName("Undirected graph")
    void testUndirected() throws IOException {
        Graph g = TestGraphSource.undirectedGraph();

        compareEdges(g, 1, 2, 5, 6);
        compareEdges(g, 2, 1, 3, 5);
        compareEdges(g, 3, 2, 4);
        compareEdges(g, 4, 3, 5);
        compareEdges(g, 5, 2, 4, 1);
        compareEdges(g, 6, 1);
    }

    @Test
    @DisplayName("Not connected, directed")
    public void testNotConnectedDirected() throws IOException {
        Graph g = TestGraphSource.notConnectedDirectedGraph();

        compareEdges(g, 1, 2, 6);
        compareEdges(g, 2, 3, 5);
        compareEdges(g, 3, 4);
        compareEdges(g, 4, 5);
        compareEdges(g, 5, 1);
        compareEdges(g, 6);
        compareEdges(g, 7, 8);
        compareEdges(g, 8, 9, 10);
        compareEdges(g, 9);
        compareEdges(g, 10, 11, 12);
        compareEdges(g, 11);
        compareEdges(g, 12);
        compareEdges(g, 13, 14);
        compareEdges(g, 14);
    }

    @Test
    @DisplayName("Not connected, undirected")
    public void testNotConnectedUndirected() throws IOException {
        Graph g = TestGraphSource.notConnectedUndirectedGraph();

        compareEdges(g, 1, 2, 5, 6);
        compareEdges(g, 2, 1, 3, 5);
        compareEdges(g, 3, 2, 4);
        compareEdges(g, 4, 3, 5);
        compareEdges(g, 5, 2, 4, 1);
        compareEdges(g, 6, 1);
        compareEdges(g, 7, 8);
        compareEdges(g, 8, 7, 9, 10);
        compareEdges(g, 9, 8);
        compareEdges(g, 10, 8, 11, 12);
        compareEdges(g, 11, 10);
        compareEdges(g, 12, 10);
        compareEdges(g, 13, 14);
        compareEdges(g, 14, 13);
    }

    @Test
    @DisplayName("Cut node graph, undirected")
    public void testCutNodeGraph() throws IOException {
        Graph g = TestGraphSource.cutnodeGraph();

        compareEdges(g, 1, 2, 3, 7, 8);
        compareEdges(g, 2, 1, 3);
        compareEdges(g, 3, 2, 1, 4);
        compareEdges(g, 4, 3, 5, 6);
        compareEdges(g, 5, 4, 6);
        compareEdges(g, 6, 5, 4);
        compareEdges(g, 7, 1, 8);
        compareEdges(g, 8, 7, 1, 9, 10);
        compareEdges(g, 9, 8, 10);
        compareEdges(g, 10, 9, 8, 11);
        compareEdges(g, 11, 10);
    }

    private static void compareEdges(Graph g, int vertexId, int ... toVertices) {
        Vertex vertex = g.getVertex(vertexId);
        Edge edge = g.getEdges(vertex);

        int[] tmp = new int[g.getOutDegree(vertex)];
        int i = 0;
        while (edge != null) {
            tmp[i++] = edge.getToVertexId();
            edge = edge.getNext();
        }

        assertArrayEquals(toVertices, tmp);
    }

}
