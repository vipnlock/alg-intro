package com.study.algolicious;

import com.skiena.chapter5.SearchDataStructure;
import com.skiena.chapter5.bfs.BfsPrint;
import com.skiena.chapter5.graph.FullEdge;
import com.skiena.chapter5.graph.Graph;
import com.skiena.chapter5.graph.Vertex;

public class Question1_OddPath {

    public void isThereAnOddPath(Graph g, Vertex s, Vertex t) {
        Graph g2 = duplicateGraph(g);

        BfsPrint alg = new BfsPrint();
        SearchDataStructure res = alg.bfs(g2, s);

        System.out.println("Look for path: " + s.getId() + " -> " + t.getId());
        res.findPath(s, new Vertex(t.getId() + g.getNumberOfVertices(), t.getValue1(), t.getValue2()));
    }

    private Graph duplicateGraph(Graph g) {
        Graph result = new Graph(true);
        final int n = g.getNumberOfVertices();

        for (int i = 1; i <= n; i++) {
            final Vertex vertex = g.getVertex(i);
            result.insertVertex(vertex.getId(), new Vertex(vertex));
            result.insertVertex(vertex.getId() + n, new Vertex(vertex.getId() + n, vertex.getValue1(), vertex.getValue2()));
        }

        for (FullEdge edge : g.getAllEdges()) {
            if (edge.getWeight() % 2 == 0) {
                result.insertEdge(edge.getV1().getId(), edge.getV2().getId(), edge.getWeight());
                result.insertEdge(edge.getV1().getId() + n, edge.getV2().getId() + n, edge.getWeight());
            } else {
                result.insertEdge(edge.getV1().getId() + n, edge.getV2().getId(), edge.getWeight());
                result.insertEdge(edge.getV1().getId(), edge.getV2().getId() + n, edge.getWeight());
            }
        }

        return result;
    }

}
