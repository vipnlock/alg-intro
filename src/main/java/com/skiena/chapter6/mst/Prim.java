package com.skiena.chapter6.mst;

import com.skiena.chapter5.graph.Edge;
import com.skiena.chapter5.graph.Graph;
import com.skiena.chapter5.graph.Vertex;

public class Prim {

    public Vertex[] prim(Graph graph, Vertex vStart) {
        boolean[] inTree = new boolean[graph.getNumberOfVertices() + 1];
        int[] distanceFromTree = new int[graph.getNumberOfVertices() + 1];
        Vertex[] parentInTree = new Vertex[graph.getNumberOfVertices() + 1];

        for (int i = 0; i <= graph.getNumberOfVertices(); i++) {
            inTree[i] = false;
            distanceFromTree[i] = Integer.MAX_VALUE;
            parentInTree[i] = null;
        }

        Vertex current = vStart;
        distanceFromTree[current.getId()] = 0;

        while (!inTree[current.getId()]) {
            inTree[current.getId()] = true;

            Edge edge = graph.getEdges(current);
            while (edge != null) {
                int vCandidateId = edge.getToVertexId();

                if (!inTree[vCandidateId]) {
                    if (distanceFromTree[vCandidateId] > edge.getWeight()) {
                        distanceFromTree[vCandidateId] = edge.getWeight();
                        parentInTree[vCandidateId] = current;
                    }
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

        return parentInTree;
    }

}
