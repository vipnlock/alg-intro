package com.study.algolicious;

import java.io.File;
import java.io.IOException;

import com.skiena.chapter5.GraphReader;
import com.skiena.chapter5.graph.Graph;

public class TestGraphSource {

    public static Graph stronglyConnectedGraphAlgolicious() throws IOException {
        Graph g = new GraphReader().read(new File("src/test/resources/algolicious/strongly_connected_components.txt"));
        System.out.println(g.toString());
        return g;
    }

    public static Graph oddPath() throws IOException {
        Graph g = new GraphReader().read(new File("src/test/resources/algolicious/odd_path.txt"));
        System.out.println(g.toString());
        return g;
    }

    public static Graph oddPath_1() throws IOException {
        Graph g = new GraphReader().read(new File("src/test/resources/algolicious/odd_path_1.txt"));
        System.out.println(g.toString());
        return g;
    }

}
