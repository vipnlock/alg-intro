package com.skiena.chapter5.search.bfs;

import com.skiena.chapter5.dto.Vertex;
import com.skiena.chapter5.search.SearchDataStructure;

import java.util.LinkedList;

public class BfsPrint extends BFS {

    private static final String SYMBOL = "/";

    private LinkedList<String> vertices = new LinkedList<>();

    @Override
    protected void processVertexEarly(Vertex vertex, SearchDataStructure state) {
        vertices.add(vertex.getId() + SYMBOL + state.getEntryTime(vertex) + "");
    }

    @Override
    protected void processVertexLate(Vertex vertex) {
        String tmp = vertices.removeLast();
        int tmpId = Integer.parseInt(tmp.substring(0, tmp.indexOf(SYMBOL)));
        if (tmpId != vertex.getId()) {
            throw new IllegalStateException("Wrong vertex on stack " + tmp + ", expected: " + vertex);
        }
    }

    @Override
    protected void processEdge(Vertex v1, Vertex v2) {
        System.out.println(String.join(".", vertices) + " : " + v1 + " -> " + v2);
    }

}
