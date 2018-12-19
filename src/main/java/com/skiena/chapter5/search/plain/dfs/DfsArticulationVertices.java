package com.skiena.chapter5.search.plain.dfs;

import com.skiena.chapter5.dto.EdgeNode;
import com.skiena.chapter5.dto.Graph;
import com.skiena.chapter5.dto.Vertex;
import com.skiena.chapter5.search.plain.SearchStructure;

public class DfsArticulationVertices extends DfsAlgorithm {

    private final Vertex[] reachableAncestor;

    private final int[] treeOutDegree;

    public DfsArticulationVertices(Graph graph) {
        this.reachableAncestor = new Vertex[graph.getVerticesCount() + 1];
        this.treeOutDegree = new int[graph.getVerticesCount() + 1];
    }

    @Override
    protected void process_Vertex_Early(Vertex vertex) {
        reachableAncestor[vertex.getId()] = vertex;
    }

    @Override
    protected void process_Vertex_Late(Vertex vertex, SearchStructure state) {
        // check if root of the search tree
        if (state.getParent(vertex) == null) {
            if (treeOutDegree[vertex.getId()] > 1) {
                System.out.println("Root articulation vertex: " + vertex);
                return;
            }
        }

        // check if only parent is reachable
        Vertex vParent = state.getParent(vertex);
        boolean isParentRoot = state.getParent(vParent) == null;
        if (reachableAncestor(vertex) == vParent && !isParentRoot) {
            System.out.println("Parent articulation vertex: " + vParent);
        }

        // check if only self is reachable
        if (reachableAncestor(vertex) == vertex) {
            System.out.println("Bridge articulation vertex: " + vParent);

            if (treeOutDegree[vertex.getId()] > 0) {
                // vertex is not a leaf
                System.out.println("Bridge articulation vertex: " + vertex);
            }
        }

        // update parent's reachable ancestor
        int vTime = state.getEntryTime(reachableAncestor(vertex));
        int vParentTime = state.getEntryTime(reachableAncestor(state.getParent(vertex)));

        if (vTime < vParentTime) {
            reachableAncestor[vParent.getId()] = reachableAncestor(vertex);
        }

        // detect bridges - single edges, whose deletion disconnects the graph
        EdgeNode treeEdge = state.getTreeEdges(vertex);
        while (treeEdge != null) {
            if (state.getEntryTime(reachableAncestor[treeEdge.getVertexId()]) > state.getEntryTime(vertex)) {
                System.out.println("Bridge: " + vertex + " -> " + treeEdge.getVertexId());
            }
            treeEdge = treeEdge.getNext();
        }
    }

    @Override
    protected void process_Edge_Early(Vertex x, Vertex y, EdgeType edgeType, SearchStructure state) {
        if (edgeType == EdgeType.TREE_EDGE) {
            treeOutDegree[x.getId()]++;
            state.addTreeEdge(x, y);
        }

        if (edgeType == EdgeType.BACK_EDGE) {
            if (state.getEntryTime(y) < state.getEntryTime(reachableAncestor[x.getId()])) {
                reachableAncestor[x.getId()] = y;
            }
        }
    }

    @Override
    protected void process_Edge_Late(Vertex v1, Vertex v2) {

    }

    private Vertex reachableAncestor(Vertex vertex) {
        return reachableAncestor[vertex.getId()];
    }

}
