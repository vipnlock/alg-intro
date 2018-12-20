package com.skiena.chapter5.dfs;

import com.skiena.chapter5.graph.EdgeType;
import com.skiena.chapter5.graph.Vertex;

import java.util.LinkedList;

public class DfsPrint extends DFS {

    private static final String SYMBOL = "#";

    private LinkedList<String> vertices = new LinkedList<>();

    @Override
    protected void processVertexEarly(Vertex vertex, DfsDataStructure state) {
        vertices.add(vertex.getId() + SYMBOL + state.getEntryTime(vertex));
    }

    @Override
    protected void processVertexLate(Vertex vertex, DfsDataStructure state) {
        String tmp = vertices.removeLast();
        int tmpId = Integer.parseInt(tmp.substring(0, tmp.indexOf(SYMBOL)));
        if (tmpId != vertex.getId()) {
            throw new IllegalStateException("Wrong vertex on stack " + tmp + ", expected: " + vertex);
        }
    }

    @Override
    protected void processEdgeFirst(Vertex current, Vertex successor, EdgeType edgeType, DfsDataStructure state) {
        System.out.println(String.join(".", vertices) + " > " + current
                + " -" + (edgeType == EdgeType.BACK ? "BACK-" : "") + "> " + successor);
    }

    @Override
    protected void processEdgeSecond(Vertex current, Vertex successor) {
        System.out.println("| " + successor + "<-" + current + " ignored edge: " + vertices.getLast());
    }

}
