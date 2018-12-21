package com.skiena.chapter6;

import com.skiena.chapter5.GraphReader;
import com.skiena.chapter5.graph.Graph;

import java.io.File;
import java.io.IOException;

public class TestGraphSource {

    public static Graph minSpanningTreeGraph() throws IOException {
        Graph g = new GraphReader().read(new File("src/test/resources/chapter6/min_span_tree.txt"));
        System.out.println(g.toString());
        return g;
    }

}
