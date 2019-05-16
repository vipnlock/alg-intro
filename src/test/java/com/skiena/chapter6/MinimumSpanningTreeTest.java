package com.skiena.chapter6;

import com.skiena.chapter5.graph.Graph;
import com.skiena.chapter5.graph.Vertex;
import com.skiena.chapter6.shortestpath.Dijkstra;
import com.skiena.chapter6.mst.Kruskal;
import com.skiena.chapter6.mst.Prim;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MinimumSpanningTreeTest {

    @Test
    @DisplayName("Prim for MST")
    void testPrim() throws IOException {
        Graph graph = TestGraphSource.minSpanningTreeGraph();
        Vertex[] parent = new Prim().prim(graph, graph.getVertex(1));
        System.out.println(Arrays.toString(parent));
        assertNull(parent[1]);
        assertEquals(1, parent[2].getId());
        assertEquals(4, parent[3].getId());
        assertEquals(1, parent[4].getId());
        assertEquals(6, parent[5].getId());
        assertEquals(4, parent[6].getId());
        assertEquals(6, parent[7].getId());
    }

    @Test
    @DisplayName("Kruskal for MST")
    void testKruskal() throws IOException {
        Graph graph = TestGraphSource.minSpanningTreeGraph();
        new Kruskal().kruskal(graph);
    }

    @Test
    @DisplayName("Dijkstra algorithm, find shortest path")
    void testDijkstra() throws IOException {
        Graph graph = TestGraphSource.minSpanningTreeGraph();
        Vertex[] parent = new Dijkstra().dijkstra(graph, graph.getVertex(1));
        Dijkstra.findPath(graph.getVertex(1), graph.getVertex(6), parent);
        System.out.println();
        Dijkstra.findPath(graph.getVertex(1), graph.getVertex(3), parent);
    }

}