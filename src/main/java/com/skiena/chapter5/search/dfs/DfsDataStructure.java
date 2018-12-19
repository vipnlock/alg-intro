package com.skiena.chapter5.search.dfs;

import com.skiena.chapter5.dto.Edge;
import com.skiena.chapter5.dto.Vertex;
import com.skiena.chapter5.search.SearchDataStructure;

public class DfsDataStructure extends SearchDataStructure {

    private boolean finished = false;

    private Edge[] treeEdges;

    public DfsDataStructure(int numberOfVertices) {
        super(numberOfVertices);

        this.treeEdges = new Edge[numberOfVertices + 1];
    }

    public boolean isFinished() {
        return finished;
    }
    public void finish() {
        this.finished = true;
    }

    public void addTreeEdge(Vertex current, Vertex successor) {
        treeEdges[current.getId()] = new Edge(successor.getId(), 0, treeEdges[current.getId()]);
    }

    public Edge getTreeEdges(Vertex vertex) {
        return treeEdges[vertex.getId()];
    }

}
