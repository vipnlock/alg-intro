package com.skiena.chapter5.search.plain;

import com.skiena.chapter5.dto.Graph;
import com.skiena.chapter5.dto.Vertex;
import com.skiena.chapter5.search.TestGraphSource;
import com.skiena.chapter5.search.plain.bfs.BfsPrint;
import com.skiena.chapter5.search.plain.dfs.DfsPrint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DfsTest {

    @Test
    @DisplayName("DFS directed")
    void dfsDirected() throws IOException {
        final Graph graph = TestGraphSource.readDirectedGraph();
        final DfsPrint alg = new DfsPrint();

        Vertex firstVertex = graph.getVertex(1);
        final Vertex[] parent = alg.dfs(graph, firstVertex);
        new BfsPrint().printBfsTree(graph, firstVertex, parent);
    }

    @Test
    @DisplayName("DFS undirected")
    void dfsUndirected() throws IOException {
        final Graph graph = TestGraphSource.readUndirectedGraph();
        final DfsPrint alg = new DfsPrint();

        Vertex firstVertex = graph.getVertex(1);
        final Vertex[] parent = alg.dfs(graph, firstVertex);
        new BfsPrint().printBfsTree(graph, firstVertex, parent);
    }

}