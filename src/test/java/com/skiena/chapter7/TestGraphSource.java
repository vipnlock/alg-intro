package com.skiena.chapter7;

import java.io.File;
import java.io.IOException;

import com.skiena.chapter5.GraphReader;
import com.skiena.chapter5.graph.Graph;

public class TestGraphSource {

    public static Graph allPathsGraph() throws IOException {
        Graph g = new GraphReader().read(new File("src/test/resources/chapter7/all_paths.txt"));
        System.out.println(g.toString());
        return g;
    }

}
