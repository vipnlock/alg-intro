package com.study.algolicious;

import com.skiena.chapter5.graph.Graph;

public class TarjanAlgorithm {

    public void tarjan(Graph g) {
        if (!g.isDirected()) {
            throw new IllegalStateException("Graph must be directed.");
        }

        int unvisited = -1;

        int id = 0; // used to give each node an id
        int sccCount = 0;   // used to count number of SCCs found


    }

}
