package com.study.algolicious;

import com.skiena.chapter5.graph.Edge;
import com.skiena.chapter5.graph.Graph;

import java.util.Stack;

public class TarjanAlgorithm {

    private final static int UNVISITED = -1;

    private Graph g;

    private int id = 0;         // used to give each node an id
    private int sccCount = 0;   // used to count number of SCCs found

    private int[] ids;
    private int[] low;
    private boolean[] onStack;
    private Stack<Integer> stack;

    public TarjanAlgorithm(Graph g) {
        if (!g.isDirected()) {
            throw new IllegalStateException("Graph must be directed.");
        }

        this.g = g;
        // auxiliary information about the nodes in the graph
        this.ids = new int[g.getNumberOfVertices()];            // stores the id of each node
        this.low = new int[g.getNumberOfVertices()];            // stores the low-link values
        this.onStack = new boolean[g.getNumberOfVertices()];    // trackes, whethe the node is on the stack
        this.stack = new Stack<>();                             // stack itself

        for (int i = 0; i < g.getNumberOfVertices(); i++) {
            ids[i] = UNVISITED;
        }
    }

    public int[] execute() {
        for (int i = 0; i < g.getNumberOfVertices(); i++) {
            if (ids[i] == UNVISITED) {
                dfs(i);
            }
        }

        return low;
    }

    private void dfs(int idAt) {
        // housekeeping staff
        stack.push(idAt);
        onStack[idAt] = true;
        ids[idAt] = low[idAt] = id++;

        Edge nextEdge = g.getEdges(g.getVertex(idAt));
        while (nextEdge != null) {
            int to = nextEdge.getToVertexId();
            if (ids[to] == UNVISITED) {
                dfs(to);
            }
            // callback of DFS
            if (onStack[to]) {
                low[idAt] = Math.min(low[idAt], low[to]);
            }
            nextEdge = nextEdge.getNext();
        }

        // After having visited all the neighbours of 'at'
        // if we are at the start of a SCC,
        // empty the seen stack until we are back until start of the SCC.
        if (ids[idAt] == low[idAt]) {
            Integer node;
            while (true) {
                node = stack.pop();
                onStack[node] = false;
                low[node] = ids[idAt];
                if (node.equals(idAt)) {
                    break;
                }
            }
            sccCount++;
        }
    }

}
