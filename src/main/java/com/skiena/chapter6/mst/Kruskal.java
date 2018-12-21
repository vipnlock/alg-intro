package com.skiena.chapter6.mst;

import com.skiena.chapter5.graph.FullEdge;
import com.skiena.chapter5.graph.Graph;

import java.util.Arrays;
import java.util.Comparator;

public class Kruskal {

    public void kruskal(Graph graph) {
        final UnionSet unionSet = new UnionSet(graph);

        FullEdge[] allEdges = graph.getAllEdges();
        Arrays.sort(allEdges, Comparator.comparingInt(FullEdge::getWeight));

        for (int i = 0; i < allEdges.length; i++) {
            FullEdge edge = allEdges[i];
            if (!unionSet.isSameComponent(edge.getV1(), edge.getV2())) {
                System.out.println("Edge in MST: " + edge);
                unionSet.unionSubtrees(edge.getV1(), edge.getV2());
            }
        }
    }

}
