package com.skiena.chapter5.graph;

public class FullEdge {

    private final Vertex v1;

    private final Vertex v2;

    private final boolean isDirected;

    private final int weight;

    public FullEdge(Vertex v1, Vertex v2, boolean isDirected, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.isDirected = isDirected;
        this.weight = weight;
    }

    public Vertex getV1() {
        return v1;
    }

    public Vertex getV2() {
        return v2;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Edge: (" + v1 + (isDirected ? " -> " : " <-> ") + v2 + ") : " + weight;
    }

}
