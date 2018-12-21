package com.skiena.chapter5.graph;

public class Graph {

    private static final int MAX_VERTEX_COUNT = 1000;

    // Vertices
    private int numberOfVertices;
    private final Vertex[] vertices = new Vertex[MAX_VERTEX_COUNT + 1];
    private final int[] outDegree = new int[MAX_VERTEX_COUNT + 1];

    // Edges
    private int numberOfEdges;
    private final Edge[] edges = new Edge[MAX_VERTEX_COUNT + 1];

    // Graph
    private final boolean isDirected;

    public Graph(final boolean isDirected) {
        this.isDirected = isDirected;
    }

    public void insertVertex(final int id, final Vertex vertex) {
        if (id > MAX_VERTEX_COUNT) {
            throw new IllegalStateException("Vertex is out of bounds: id = " + id + " (limit: " + MAX_VERTEX_COUNT + ")");
        }
        vertices[id] = vertex;
        numberOfVertices++;
    }

    public void insertEdge(final int fromVertexId, final int toVertexId, final int weight) {
        this.insertEdge(fromVertexId, toVertexId, weight, isDirected);
    }

    private void insertEdge(final int v1Id, final int v2Id, final int weight, final boolean directed) {
        edges[v1Id] = new Edge(v2Id,weight, edges[v1Id]);

        outDegree[v1Id]++;

        if (directed) {
            numberOfEdges++;
        } else {
            insertEdge(v2Id, v1Id, weight, true);
        }
    }

    public Vertex getVertex(int id) {
        return vertices[id];
    }

    public Edge getEdges(Vertex vertex) {
        return edges[vertex.getId()];
    }

    public int getOutDegree(Vertex vertex) {
        return outDegree[vertex.getId()];
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public boolean isDirected() {
        return isDirected;
    }

    /*
     * Technical.
     */

    public Vertex[] getVertices() {
        return vertices;
    }

    public FullEdge[] getAllEdges() {
        FullEdge[] allEdges = new FullEdge[numberOfEdges];
        int index = 0;

        for (int i = 1; i <= numberOfVertices; i++) {
            Vertex current = getVertex(i);

            Edge edge = getEdges(current);
            while (edge != null) {
                if (current.getId() <= edge.getToVertexId() || isDirected) {
                    allEdges[index++] = new FullEdge(current, getVertex(edge.getToVertexId()), isDirected, edge.getWeight());
                }

                edge = edge.getNext();
            }
        }

        if (index != numberOfEdges) {
            throw new IllegalStateException("Incorrect amount of edges found: " + index + ", registered in graph parameter: " + numberOfEdges);
        }
        return allEdges;
    }

    public void invertEdgesOrder() {
        for (int i = 1; i <= numberOfEdges; i++) {
            if (edges[i] != null) {
                edges[i] = edges[i].invert();
            }
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Graph [")
                .append(numberOfVertices).append(";")
                .append(numberOfEdges).append("; ")
                .append(isDirected ? "directed" : "undirected")
                .append("]\n");
        for (int i = 1; i <= numberOfVertices; i++) {
            sb.append(i).append("[").append(outDegree[i]).append("]: ");
            var edge = edges[i];
            while (edge != null) {
                sb.append("[").append(edge.getWeight()).append("] ");
                sb.append("V_").append(vertices[edge.getToVertexId()]).append(" -> ");
                edge = edge.getNext();
            }
            if (sb.lastIndexOf(" -> ") == sb.length() - 4) {
                sb.replace(sb.length() - 4, sb.length(), "\n");
            } else {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

}
