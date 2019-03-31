package com.skiena.chapter7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.skiena.chapter5.graph.Graph;

class AllPathsTest {

    @Test
    void getAllPaths() throws IOException {
        Graph g = TestGraphSource.allPathsGraph();
        assertEquals(7, new AllPaths(g, g.getVertex(1), g.getVertex(3)).getAllPaths());
    }

}