package com.skiena.chapter5.search.dfs;

import com.skiena.chapter5.dto.EdgeType;
import com.skiena.chapter5.dto.Graph;
import com.skiena.chapter5.dto.Vertex;
import com.skiena.chapter5.dto.VertexState;

import java.util.LinkedList;

public class DfsStrongComponents extends DFS {

    private final Vertex reachableAncestor[];    // oldest vertex (mit entryTime) surely in component for each Vertex
    private final int scc[];    // strong component number for each Vertex

    private int componentsFound = 0;

    private LinkedList<Vertex> stack = new LinkedList<>();

    public DfsStrongComponents(int numberOfVertices) {
        reachableAncestor = new Vertex[numberOfVertices + 1];
        scc = new int[numberOfVertices + 1];
    }

    public void strongComponents(Graph graph) {
        for (int i = 0; i <= graph.getNumberOfVertices(); i++) {
            reachableAncestor[i] = graph.getVertex(i);
            scc[i] = -1;
        }

        final DfsDataStructure state = new DfsDataStructure(graph.getNumberOfVertices());

        for (int i = 1; i <= graph.getNumberOfVertices(); i++) {
            Vertex vertex = graph.getVertex(i);
            if (state.getState(vertex) == VertexState.UNDISCOVERED) {
                dfs(graph, vertex, state);
            }
        }
    }

    public void printResult() {
        for (int i = 1; i < scc.length; i++) {
            System.out.println(i + "-th vertex belongs to SCC#" + scc[i]);
        }
    }

    @Override
    void processVertexEarly(Vertex vertex, DfsDataStructure state) {
        stack.push(vertex);
    }

    @Override
    void processVertexLate(Vertex vertex, DfsDataStructure state) {
        // A new strongly connected component is found whenever the lowest reachable vertex from v is v.
        // - edge (parent[vertex], vertex) cuts off scc
        if (reachableAncestor[vertex.getId()] == vertex) {
            popComponent(vertex);
        }

        // update parent's reachable ancestor
        Vertex vParent = state.getParent(vertex);
        if (vParent != null) {
            int parentTime = state.getEntryTime(reachableAncestor[vParent.getId()]);
            int vertexTime = state.getEntryTime(reachableAncestor[vertex.getId()]);
            if (parentTime > vertexTime) {
                reachableAncestor[vParent.getId()] = reachableAncestor[vertex.getId()];
            }
        }
    }

    private void popComponent(Vertex vertex) {
        componentsFound++;

        scc[vertex.getId()] = componentsFound;
        Vertex t;
        while ((t = stack.pop()) != vertex) {
            scc[t.getId()] = componentsFound;
        }
    }

    @Override
    void processEdgeFirst(Vertex current, Vertex successor, EdgeType edgeType, DfsDataStructure state) {
        if (edgeType == EdgeType.BACK
                || (edgeType == EdgeType.CROSS && scc[successor.getId()] == -1 /* component is not yes assigned */)) {
            // cross edges (from a vertex back to an nonancestor but previously discovered vertex)
            // - that point vertices from previous strongly connected components of the graph cannot help us,
            //   because there can be no way back from them to v, but otherwise cross edges are fair game

            if (state.getEntryTime(successor) < state.getEntryTime(reachableAncestor[current.getId()])) {
                reachableAncestor[current.getId()] = successor;
            }
        }

        // forward edges (from a vertex to a descendant):
        // - have no impact on reachability over the depth-first tree edges, and hence can be disregarded:
    }

    @Override
    void processEdgeSecond(Vertex current, Vertex successor) {
        // nothing
    }

}
