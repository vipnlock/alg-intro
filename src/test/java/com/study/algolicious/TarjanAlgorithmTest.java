package com.study.algolicious;

import java.io.IOException;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.skiena.chapter5.graph.Graph;

class TarjanAlgorithmTest {

    @Test
    void execute() throws IOException {
        Graph g = TestGraphSource.stronglyConnectedGraphAlgolicious();
        System.out.println(Arrays.toString(new TarjanAlgorithm(g).execute()));
    }

    @Test
    void execute2() throws IOException {
        Graph g = com.skiena.chapter5.TestGraphSource.stronglyConnectedGraph();
        System.out.println(Arrays.toString(new TarjanAlgorithm(g).execute()));
    }

}