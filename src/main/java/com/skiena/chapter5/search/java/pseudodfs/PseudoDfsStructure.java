package com.skiena.chapter5.search.java.pseudodfs;

import com.skiena.chapter5.dto.Vertex;
import com.skiena.chapter5.search.java.CommonSearchStructure;

import java.util.Stack;

public class PseudoDfsStructure extends CommonSearchStructure {

    private final Stack<Vertex> stack;

    PseudoDfsStructure(Vertex vStart, int verticesCount) {
        super(vStart, verticesCount);

        stack = new Stack<>();
    }

    @Override
    protected void rememberVertex(Vertex vertex) {
        stack.push(vertex);
    }

    @Override
    protected boolean isDone() {
        return stack.isEmpty();
    }

    @Override
    protected Vertex getNextDiscoverer() {
        return stack.pop();
    }

}
