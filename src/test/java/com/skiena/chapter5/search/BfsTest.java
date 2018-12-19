package com.skiena.chapter5.search;

import com.skiena.chapter5.dto.Graph;
import com.skiena.chapter5.dto.Vertex;
import com.skiena.chapter5.search.bfs.BfsConnectedComponents;
import com.skiena.chapter5.search.bfs.BfsPrint;
import com.skiena.chapter5.search.bfs.BfsTwoColor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BfsTest {

    @Test
    @DisplayName("BFS directed")
    void bfsDirected() throws IOException {
        final Graph graph = TestGraphSource.directedGraph();
        final Vertex firstVertex = graph.getVertex(1);

        final SearchDataStructure state = new BfsPrint().bfs(graph, firstVertex);
        state.printSearchTree(graph, firstVertex);
    }

    @Test
    @DisplayName("BFS undirected")
    void bfsUndirected() throws IOException {
        final Graph graph = TestGraphSource.undirectedGraph();
        final Vertex firstVertex = graph.getVertex(1);

        final SearchDataStructure state = new BfsPrint().bfs(graph, firstVertex);
        state.printSearchTree(graph, firstVertex);
    }

    @Test
    @DisplayName("Connected components, directed")
    void connectedComponentsDirectedGraph() throws IOException {
        final Graph graph = TestGraphSource.notConnectedDirectedGraph();
        new BfsConnectedComponents().connectedComponents(graph);
    }

    @Test
    @DisplayName("Connected components, undirected")
    void connectedComponentsUndirectedGraph() throws IOException {
        final Graph graph = TestGraphSource.notConnectedUndirectedGraph();
        new BfsConnectedComponents().connectedComponents(graph);
    }

    @Test
    @DisplayName("Two color, undirected, not bipartide")
    void notTwoColorTest() throws IOException {
        final Graph graph = TestGraphSource.undirectedGraph();
        BfsTwoColor alg = new BfsTwoColor();
        alg.twoColor(graph);
        assertFalse(alg.isBipartide());
    }

    @Test
    @DisplayName("Two color, undirected, bipartide")
    void twoColorTest() throws IOException {
        final Graph graph = TestGraphSource.twoColorGraph();
        BfsTwoColor alg = new BfsTwoColor();
        alg.twoColor(graph);
        assertTrue(alg.isBipartide());
    }

}