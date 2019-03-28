package com.skiena.chapter7;

public class AllPermutations extends Backtracking<Integer> {

    private int index = 0;

    public void generatePermutations(int n) {
        int[] solution = new int[n + 1];
        backtrack(solution, 0, n);
    }

    @Override
    protected boolean isSolution(int[] partialSolution, int stepNr, Integer n) {
        return n.equals(stepNr);
    }

    @Override
    protected void processSolution(int[] solution, int stepNr, Integer n) {
        StringBuilder sb = new StringBuilder();
        String prefix = "";
        for (int i = 1; i <= stepNr; i++) {
            sb.append(prefix).append(solution[i]);
            prefix = ", ";
        }
        System.out.println(++index + ". " + sb.toString());
    }

    @Override
    protected int[] constructCandidates(int[] partialSolution, int nextStepNr, Integer n) {
        int[] candidates = new int[n - nextStepNr + 1];

        // set up a bit-vector data structure to maintain which elements are in the partial solution.
        // This gives a constant-time legality check.
        boolean[] inPerm = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            inPerm[i] = false;
        }
        for (int i = 0; i < nextStepNr; i++) {
            inPerm[partialSolution[i]] = true;
        }

        int candIndex = -1;
        for (int i = 1; i <= n; i++) {
            if (!inPerm[i]) {
                candidates[++candIndex] = i;
            }
        }
        return candidates;
    }

    @Override
    protected void makeMove(int[] partialSolution, int nextStepNr, Integer n) {

    }

    @Override
    protected void unmakeMove(int[] partialSolution, int nextStepNr, Integer n) {

    }

}
