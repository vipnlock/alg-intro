package com.skiena.chapter5.search;

import com.skiena.chapter5.GraphReader;
import com.skiena.chapter5.dto.Graph;

import java.io.File;
import java.io.IOException;

public class TestGraphSource {

    public static Graph readDirectedGraph() throws IOException {
        return new GraphReader().read(new File("src/test/resources/chapter5/test_directed_graph.txt"));
    }

    public static Graph readUndirectedGraph() throws IOException {
        return new GraphReader().read(new File("src/test/resources/chapter5/test_undirected_graph.txt"));
    }

}
