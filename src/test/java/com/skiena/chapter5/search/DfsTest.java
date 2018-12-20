package com.skiena.chapter5.search;

import com.skiena.chapter5.dto.Graph;
import com.skiena.chapter5.dto.Vertex;
import com.skiena.chapter5.search.dfs.DfsArticulationVertices;
import com.skiena.chapter5.search.dfs.DfsDataStructure;
import com.skiena.chapter5.search.dfs.DfsFindCycles;
import com.skiena.chapter5.search.dfs.DfsPrint;
import com.skiena.chapter5.search.dfs.DfsStrongComponents;
import com.skiena.chapter5.search.dfs.DfsTopologicalSorting;
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
        final DfsDataStructure state = alg.dfs(graph, firstVertex);
        state.printSearchTree(graph, firstVertex);
    }

    @Test
    @DisplayName("DFS undirected")
    void dfsUndirected() throws IOException {
        final Graph graph = TestGraphSource.undirectedGraph();
        final DfsPrint alg = new DfsPrint();

        Vertex firstVertex = graph.getVertex(1);
        final DfsDataStructure state = alg.dfs(graph, firstVertex);
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
        DfsDataStructure state = new DfsArticulationVertices(graph.getNumberOfVertices()).dfs(graph, graph.getVertex(1));
    }

    @Test
    @DisplayName("Find articulation vertices in line graph")
    void findArticulationVerticesTwoNodes() throws IOException {
        final Graph graph = TestGraphSource.lineGraph();
        DfsDataStructure state = new DfsArticulationVertices(graph.getNumberOfVertices()).dfs(graph, graph.getVertex(1));
    }

    @Test
    @DisplayName("Topological sorting")
    void topSort() throws IOException {
        final Graph graph = TestGraphSource.topSortGraph();
        new DfsTopologicalSorting().topSort(graph);
    }

    @Test
    @DisplayName("Strongly connected graph")
    void stronglyConnectedGraph() throws IOException {
        final Graph graph = TestGraphSource.stronglyConnectedGraph();
        DfsStrongComponents alg = new DfsStrongComponents(graph.getNumberOfVertices());
        alg.strongComponents(graph);
        alg.printResult();
    }

    @Test
    @DisplayName("Strongly connected graph 2")
    void stronglyConnectedGraph2() throws IOException {
        final Graph graph = TestGraphSource.stronglyConnectedGraph2();
        DfsStrongComponents alg = new DfsStrongComponents(graph.getNumberOfVertices());
        alg.strongComponents(graph);
        alg.printResult();
    }

}
