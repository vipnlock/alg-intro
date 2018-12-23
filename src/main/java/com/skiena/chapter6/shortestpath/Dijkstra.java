package com.skiena.chapter6.shortestpath;

import com.skiena.chapter5.graph.Edge;
import com.skiena.chapter5.graph.Graph;
import com.skiena.chapter5.graph.Vertex;

public class Dijkstra {

    public Vertex[] dijkstra(Graph graph, Vertex vStart) {
        boolean[] inTree = new boolean[graph.getNumberOfVertices() + 1];
        int[] distanceFromTree = new int[graph.getNumberOfVertices() + 1];
        Vertex[] parent = new Vertex[graph.getNumberOfVertices() + 1];

        for (int i = 0; i <= graph.getNumberOfVertices(); i++) {
            inTree[i] = false;
            distanceFromTree[i] = Integer.MAX_VALUE;
            parent[i] = null;
        }

        Vertex current = vStart;
        distanceFromTree[current.getId()] = 0;

        while (!inTree[current.getId()]) {
            inTree[current.getId()] = true;

            Edge edge = graph.getEdges(current);
            while (edge != null) {
                int vCandidateId = edge.getToVertexId();

                if (distanceFromTree[vCandidateId] > distanceFromTree[current.getId()] + edge.getWeight()) {
                    distanceFromTree[vCandidateId] = distanceFromTree[current.getId()] + edge.getWeight();
                    parent[vCandidateId] = current;
                }
                edge = edge.getNext();
            }

            int bestDistance = Integer.MAX_VALUE;
            for (int i = 1; i <= graph.getNumberOfVertices(); i++) {
                if (!inTree[i] && bestDistance > distanceFromTree[i]) {
                    bestDistance = distanceFromTree[i];
                    current = graph.getVertex(i);
                }
            }
        }

        return parent;
    }

    public static void findPath(Vertex vStart, Vertex vEnd, Vertex[] parent) {
        if (vEnd == null || vStart.getId() == vEnd.getId()) {
            System.out.print("Path: " + vStart);
        } else {
            findPath(vStart, parent[vEnd.getId()], parent);
            System.out.print(" -> " + vEnd);
        }
    }

}
