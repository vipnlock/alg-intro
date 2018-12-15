package com.skiena.chapter5.search;

import com.skiena.chapter5.GraphReader;
import com.skiena.chapter5.dto.Graph;

import java.io.File;
import java.io.IOException;

public class TestGraphSource {

    public static Graph directedGraph() throws IOException {
        Graph g = new GraphReader().read(new File("src/test/resources/chapter5/directed.txt"));
        System.out.println(g.toString());
        return g;
    }

    public static Graph undirectedGraph() throws IOException {
        Graph g = new GraphReader().read(new File("src/test/resources/chapter5/undirected.txt"));
        System.out.println(g.toString());
        return g;
    }

    public static Graph notConnectedDirectedGraph() throws IOException {
        Graph g = new GraphReader().read(new File("src/test/resources/chapter5/not_connected_directed.txt"));
        System.out.println(g.toString());
        return g;
    }

    public static Graph notConnectedUndirectedGraph() throws IOException {
        Graph g = new GraphReader().read(new File("src/test/resources/chapter5/not_connected_undirected.txt"));
        System.out.println(g.toString());
        return g;
    }

}
