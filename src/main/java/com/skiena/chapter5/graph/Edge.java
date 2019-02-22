package com.skiena.chapter5.graph;

import com.commons.Pair;

public class Edge {

    private final int toVertexId;

    private final int weight;
    // alternative flow-approach
    private final int capacity;
    private int flowCapacity;
    private int residualCapacity;

    private Edge next;

    public Edge(int toVertexId, int weight, Edge next) {
        this.toVertexId = toVertexId;

        this.weight = weight;
        this.capacity = weight;
        this.flowCapacity = 0;
        this.residualCapacity = 0;

        this.next = next;
    }

    public int getToVertexId() {
        return toVertexId;
    }

    public int getWeight() {
        return weight;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setFlowCapacity(int flowCapacity) {
        this.flowCapacity = flowCapacity;
    }
    public int getFlowCapacity() {
        return flowCapacity;
    }

    public void setResidualCapacity(int residualCapacity) {
        this.residualCapacity = residualCapacity;
    }
    public int getResidualCapacity() {
        return residualCapacity;
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
