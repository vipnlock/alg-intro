package com.skiena.chapter5.search.java;

import com.skiena.chapter5.dto.Graph;
import com.skiena.chapter5.search.TestGraphSource;
import com.skiena.chapter5.search.java.bfs.BfsStructure;
import com.skiena.chapter5.search.java.bfs.JavaBfsPrint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class JavaBfsTest {

    @Test
    @DisplayName("BFS directed graph, implemented first java way")
    void bfsDirected() throws IOException {
        Graph graph = TestGraphSource.readDirectedGraph();
        final BfsStructure state = new JavaBfsPrint().bfs(graph, graph.getVertex(1));
        state.printOut(graph.getVertices());
    }

    @Test
    @DisplayName("BFS directed graph, implemented first java way")
    void bfsUndirected() throws IOException {
        Graph graph = TestGraphSource.readUndirectedGraph();
        final BfsStructure state = new JavaBfsPrint().bfs(graph, graph.getVertex(1));
        state.printOut(graph.getVertices());
    }

}