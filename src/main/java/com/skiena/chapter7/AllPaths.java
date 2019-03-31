package com.skiena.chapter7;

import java.util.Arrays;

import com.skiena.chapter5.graph.Edge;
import com.skiena.chapter5.graph.Graph;
import com.skiena.chapter5.graph.Vertex;

public class AllPaths extends Backtracking<Integer> {

    private final Graph g;
    private final Vertex start;
    private final Vertex target;

    private int solutionsCount = 0;

    public AllPaths(Graph g, Vertex start, Vertex target) {
        this.g = g;
        this.start = start;
        this.target = target;
    }

    public int getAllPaths() {
        int[] partialSolution = new int[g.getNumberOfVertices() + 1];
        backtrack(partialSolution, 0, start.getId());
        return solutionsCount;
    }

    @Override
    protected boolean isSolution(int[] partialSolution, int stepNr, Integer context) {
        return target.getId() == partialSolution[stepNr];
    }

    @Override
    protected void processSolution(int[] solution, int stepNr, Integer context) {
        System.out.println(++solutionsCount + ". " + Arrays.toString(solution));
    }

    @Override
    protected int[] constructCandidates(int[] partialSolution, int nextStepNr, Integer startVertex) {
        final int n = g.getNumberOfVertices();
        int[] candidates = new int[n + 1];
        boolean[] inSolution = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            inSolution[i] = false;
        }
        for (int i = 1; i < nextStepNr; i++) {
            inSolution[partialSolution[i]] = true;
        }

        if (nextStepNr == 1) {
            return new int[] {startVertex};   // always start from vertex 1.
        } else {
            Edge e = g.getEdges(g.getVertex(partialSolution[nextStepNr - 1]));
            int index = 0;
            while (e != null) {
                if (!inSolution[e.getToVertexId()]) {
                    candidates[index++] = e.getToVertexId();
                }
                e = e.getNext();
            }
            return Arrays.copyOf(candidates, index);
        }
    }

    @Override
    protected void makeMove(int[] partialSolution, int nextStepNr, Integer context) {

    }

    @Override
    protected void unmakeMove(int[] partialSolution, int nextStepNr, Integer context) {

    }

}
