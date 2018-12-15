package com.skiena.chapter5.search.java;

import com.skiena.chapter5.dto.Graph;
import com.skiena.chapter5.search.TestGraphSource;
import com.skiena.chapter5.search.java.pseudodfs.JavaPseudoDfsPrint;
import com.skiena.chapter5.search.java.pseudodfs.PseudoDfsStructure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class JavaPseudoDfsTest {

    @Test
    @DisplayName("DFS directed graph, java way")
    void dfsDirected() throws IOException {
        Graph g = TestGraphSource.directedGraph();
        final PseudoDfsStructure state = new JavaPseudoDfsPrint().dfs(g, g.getVertex(1));
        state.printOut(g.getVertices());
    }

    @Test
    @DisplayName("DFS undirected graph, java way")
    void dfsUndirected() throws IOException {
        Graph g = TestGraphSource.undirectedGraph();
        final PseudoDfsStructure state = new JavaPseudoDfsPrint().dfs(g, g.getVertex(1));
        state.printOut(g.getVertices());
    }

}