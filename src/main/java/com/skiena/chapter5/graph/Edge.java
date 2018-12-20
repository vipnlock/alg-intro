package com.skiena.chapter5.graph;

import com.commons.Pair;

public class Edge {

    private final int toVertexId;

    private final int weight;

    private Edge next;

    public Edge(int toVertexId, int weight, Edge next) {
        this.toVertexId = toVertexId;
        this.weight = weight;
        this.next = next;
    }

    public int getToVertexId() {
        return toVertexId;
    }

    public int getWeight() {
        return weight;
    }

    public void setNext(Edge next) {
        this.next = next;
    }
    public Edge getNext() {
        return next;
    }

    /*
     * Helper methods.
     */
    public Edge invert() {
//        return invertRecurse(this).getFirst();
        return invertIteration(this);
    }

    private static Edge invertIteration(Edge firstElement) {
        Edge tmp = firstElement;
        if (tmp.getNext() == null) {
            return firstElement;
        }

        Edge tmpN = tmp.getNext();
        while (tmpN != null) {
            Edge tmpNN = tmpN.getNext();
            tmpN.setNext(tmp);
            tmp = tmpN;
            tmpN = tmpNN;
        }

        firstElement.setNext(null);
        return tmp;
    }

    private static Pair<Edge, Edge> invertRecurse(Edge firstElement) {
        if (firstElement.getNext() == null) {
            return Pair.of(firstElement, firstElement);
        } else {
            Pair<Edge, Edge> result = invertRecurse(firstElement.getNext());
            result.getSecond().setNext(firstElement);
            firstElement.setNext(null);
            return Pair.of(result.getFirst(), firstElement);
        }
    }

}
