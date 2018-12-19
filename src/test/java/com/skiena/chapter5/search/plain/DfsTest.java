package com.skiena.chapter5.search.plain;

import com.skiena.chapter5.dto.Graph;
import com.skiena.chapter5.dto.Vertex;
import com.skiena.chapter5.search.TestGraphSource;
import com.skiena.chapter5.search.plain.dfs.DfsArticulationVertices;
import com.skiena.chapter5.search.plain.dfs.DfsFindCycles;
import com.skiena.chapter5.search.plain.dfs.DfsPrint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class DfsTest {

    @Test
    @DisplayName("DFS directed")
    void dfsDirected() throws IOException {
        final Graph graph = TestGraphSource.directedGraph();
        final DfsPrint alg = new DfsPrint();

        Vertex firstVertex = graph.getVertex(1);
        final SearchStructure state = alg.dfs(graph, firstVertex);
        state.printSearchTree(graph, firstVertex);
    }

    @Test
    @DisplayName("DFS undirected")
    void dfsUndirected() throws IOException {
        final Graph graph = TestGraphSource.undirectedGraph();
        final DfsPrint alg = new DfsPrint();

        Vertex firstVertex = graph.getVertex(1);
        final SearchStructure state = alg.dfs(graph, firstVertex);
        state.printSearchTree(graph, firstVertex);
    }

    @Test
    @DisplayName("Find cycle = find any BACK edge")
    void findCycle() throws IOException {
        final Graph graph = TestGraphSource.undirectedGraph();
        new DfsFindCycles().dfs(graph, graph.getVertex(1));
    }

    @Test
    @DisplayName("Find articulation vertices")
    void findArticulationVertices() throws IOException {
        final Graph graph = TestGraphSource.cutnodeGraph();
        SearchStructure state = new DfsArticulationVertices(graph).dfs(graph, graph.getVertex(1));
    }

}
