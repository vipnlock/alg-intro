package com.skiena.chapter5.search.plain;

import com.skiena.chapter5.dto.Graph;
import com.skiena.chapter5.dto.Vertex;
import com.skiena.chapter5.search.TestGraphSource;
import com.skiena.chapter5.search.plain.bfs.BfsPrint;
import com.skiena.chapter5.search.plain.bfs.BfsStructure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class BfsTest {

    @Test
    @DisplayName("BFS directed")
    void bfsDirected() throws IOException {
        final Graph graph = TestGraphSource.readDirectedGraph();
        final BfsPrint alg = new BfsPrint();
        final Vertex firstVertex = graph.getVertex(1);

        final BfsStructure state = alg.bfs(graph, firstVertex);
        alg.printBfsTree(graph, firstVertex, state.getParent());
    }

    @Test
    @DisplayName("BFS undirected")
    void bfsUndirected() throws IOException {
        final Graph graph = TestGraphSource.readUndirectedGraph();
        final BfsPrint alg = new BfsPrint();
        final Vertex firstVertex = graph.getVertex(1);

        final BfsStructure state = alg.bfs(graph, firstVertex);
        alg.printBfsTree(graph, firstVertex, state.getParent());
    }

    @Test
    void findPath() {
    }

    @Test
    void connectedComponents() throws IOException {
        final Graph graph = TestGraphSource.readUndirectedGraph();
        new BfsPrint().connectedComponents(graph);
    }

}