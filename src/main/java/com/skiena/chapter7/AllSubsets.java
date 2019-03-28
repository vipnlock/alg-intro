package com.skiena.chapter7;

public class AllSubsets extends Backtracking<Integer> {

    private static final int TRUE = 1;
    private static final int FALSE = 0;

    private int index = 0;

    public void generateSubsets(int n) {
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
            if (solution[i] == TRUE) {
                sb.append(prefix).append(i);
                prefix = ", ";
            }
        }
        System.out.println(++index + ". " + sb.toString());
    }

    /**
     * Defines the order of generated subsets.
     */
    @Override
    protected int[] constructCandidates(int[] partialSolution, int nextStepNr, Integer n) {
        return new int[] {TRUE, FALSE};
    }

    @Override
    protected void makeMove(int[] partialSolution, int nextStepNr, Integer n) {

    }

    @Override
    protected void unmakeMove(int[] partialSolution, int nextStepNr, Integer n) {

    }

}
