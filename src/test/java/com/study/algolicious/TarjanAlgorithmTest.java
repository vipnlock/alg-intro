package com.study.algolicious;

import com.skiena.chapter5.TestGraphSource;
import com.skiena.chapter5.graph.Graph;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TarjanAlgorithmTest {

    @Test
    void execute() throws IOException {
        Graph g = TestGraphSource.stronglyConnectedGraphAlgolicious();
        System.out.println(Arrays.toString(new TarjanAlgorithm(g).execute()));
    }

    @Test
    void execute2() throws IOException {
        Graph g = TestGraphSource.stronglyConnectedGraph();
        System.out.println(Arrays.toString(new TarjanAlgorithm(g).execute()));
    }

}