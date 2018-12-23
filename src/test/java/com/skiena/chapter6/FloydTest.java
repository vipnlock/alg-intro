package com.skiena.chapter6;

import com.skiena.chapter6.shortestpath.AdjacencyMatrix;
import com.skiena.chapter6.shortestpath.Floyd;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FloydTest {

    @Test
    @DisplayName("Floyd-Warshall algorithm")
    void testFloyd() {
        AdjacencyMatrix graph = createTestGraph();
        System.out.println(graph);
        new Floyd().floyd(graph);
        System.out.println(graph);
    }

    private AdjacencyMatrix createTestGraph() {
        AdjacencyMatrix graph = new AdjacencyMatrix(7);

        graph.setWeightUndirected(1, 2, 5);
        graph.setWeightUndirected(1, 3, 12);
        graph.setWeightUndirected(1, 4, 7);
        graph.setWeightUndirected(2, 4, 9);
        graph.setWeightUndirected(2, 5, 7);
        graph.setWeightUndirected(3, 4, 4);
        graph.setWeightUndirected(3, 6, 7);
        graph.setWeightUndirected(4, 5 ,4);
        graph.setWeightUndirected(4, 6, 3);
        graph.setWeightUndirected(5, 6, 2);
        graph.setWeightUndirected(5, 7, 5);
        graph.setWeightUndirected(6, 7, 2);

        return graph;
    }

}
