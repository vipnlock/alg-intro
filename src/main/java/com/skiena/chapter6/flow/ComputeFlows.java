package com.skiena.chapter6.flow;

import com.skiena.chapter5.SearchDataStructure;
import com.skiena.chapter5.bfs.BfsPrint;
import com.skiena.chapter5.graph.Edge;
import com.skiena.chapter5.graph.Graph;
import com.skiena.chapter5.graph.Vertex;

public class ComputeFlows {

    /*
     * We use a BFS to look for any path from source to sink that increases the total flow,
     * and use it to augment the total.
     * We terminate with the optimal flow when no such augmenting path exists.
     */
    public void netFlow(Graph graph, Vertex source, Vertex sink) {
        final BfsPrint bfs = new BfsPrint();

        SearchDataStructure state = bfs.bfs(graph, source);
        int volume = pathVolume(graph, source, sink, state);

        while (volume > 0) {
            augmentPath(graph, source, sink, state, volume);
            state = bfs.bfs(graph, source);
            volume = pathVolume(graph, source, sink, state);
        }
    }

    private boolean validEdge(Edge edge, Vertex start, Vertex end, SearchDataStructure state) {
        return edge.getResidualCapacity() > 0;
    }

    private int pathVolume(Graph graph, Vertex start, Vertex end, SearchDataStructure state) {
        if (state.getParent(end) == null) {
            return 0;
        }

        final Vertex endParent = state.getParent(end);
        Edge edge = findEdge(graph, endParent, end);
        if (edge == null) {
            return 0;
        }

        if (endParent.getId() == start.getId()) {
            return edge.getResidualCapacity();
        } else {
            return Math.min(pathVolume(graph, start, endParent, state), edge.getResidualCapacity());
        }
    }

    private Edge findEdge(Graph graph, Vertex start, Vertex end) {
        Edge edge = graph.getEdges(start);

        while (edge != null) {
            if (edge.getToVertexId() == end.getId()) {
                return edge;
            }
            edge = edge.getNext();
        }

        return null;
    }

    private void augmentPath(Graph graph, Vertex start, Vertex end, SearchDataStructure state, int volume) {
        if (start.getId() == end.getId()) {
            return;
        }

        Edge edge = findEdge(graph, state.getParent(end), end);
        if (edge == null) {
            return;
        }
        edge.setFlowCapacity(edge.getFlowCapacity() + volume);
        edge.setResidualCapacity(edge.getResidualCapacity() - volume);

        edge = findEdge(graph, end, state.getParent(end));
        if (edge == null) {
            return;
        }
        edge.setResidualCapacity(edge.getResidualCapacity() + volume);

        augmentPath(graph, start, state.getParent(end), state, volume);
    }

}
