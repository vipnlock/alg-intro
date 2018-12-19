package com.skiena.chapter5.search.dfs;

import com.skiena.chapter5.dto.Edge;
import com.skiena.chapter5.dto.EdgeType;
import com.skiena.chapter5.dto.Vertex;

public class DfsArticulationVertices extends DFS {

    private final Vertex[] reachableAncestor;   // earliest reachable ancestor of each Vertex
    private final int[] treeOutDegree;          // Out degree of each Vertex

    public DfsArticulationVertices(int numberOfVertices) {
        this.reachableAncestor = new Vertex[numberOfVertices + 1];
        this.treeOutDegree = new int[numberOfVertices + 1];
    }

    @Override
    void processVertexEarly(Vertex vertex, DfsDataStructure state) {
        reachableAncestor[vertex.getId()] = vertex;
    }

    @Override
    void processVertexLate(Vertex vertex, DfsDataStructure state) {
        Vertex vParent = state.getParent(vertex);

        // Root of the search tree
        if (vParent == null) {
            if (treeOutDegree[vertex.getId()] > 1) {
                System.out.println("Root articulation vertex: " + vertex);
            }
            return;
        }

        boolean parentIsRoot = state.getParent(vParent) == null;

        // Parent
        if (reachableAncestor[vertex.getId()] == vParent && !parentIsRoot) {
            System.out.println("Parent articulation vertex: " + vParent);
        }

        // Bridge
        if (reachableAncestor[vertex.getId()] == vertex) {
            if (!parentIsRoot) {
                System.out.println("Bridge articulation vertex: " + vParent);
            }

            if (treeOutDegree[vertex.getId()] > 0) {
                System.out.println("Bridge articulation vertex: " + vertex);
            }
        }

        // update parent's reachable ancestor
        int parentTime = state.getEntryTime(reachableAncestor[vParent.getId()]);
        int vertexTime = state.getEntryTime(reachableAncestor[vertex.getId()]);
        if (parentTime > vertexTime) {
            reachableAncestor[vParent.getId()] = reachableAncestor[vertex.getId()];
        }

        // detect bridges - single edges, whose deletion disconnects the graph
        Edge treeEdge = state.getTreeEdges(vertex);
        while (treeEdge != null) {
            if (state.getEntryTime(reachableAncestor[treeEdge.getToVertexId()]) > state.getEntryTime(vertex)) {
                System.out.println("Bridge: " + vertex + " -> " + treeEdge.getToVertexId());
            }
            treeEdge = treeEdge.getNext();
        }
    }

    @Override
    void processEdgeFirst(Vertex current, Vertex successor, EdgeType edgeType, DfsDataStructure state) {
        if (edgeType == EdgeType.TREE_EDGE) {
            treeOutDegree[current.getId()]++;
            state.addTreeEdge(current, successor);
        } else if (edgeType == EdgeType.BACK_EDGE) {
            if (state.getEntryTime(successor) < state.getEntryTime(reachableAncestor[current.getId()])) {
                reachableAncestor[current.getId()] = successor;
            }
        }
    }

    @Override
    void processEdgeSecond(Vertex current, Vertex successor) {
        // nothing
    }

}
