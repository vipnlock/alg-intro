package com.skiena.chapter7;

public abstract class Backtracking<T> {

    /**
     * Flag used to allow for premature termination.
     * Can be set in any application specific routine.
     */
    protected boolean finished = false;

    public void backtrack(int[] partialSolution, int stepNr, T context) {
        if (isSolution(partialSolution, stepNr, context)) {
            processSolution(partialSolution, stepNr, context);
        } else {
            final int nextStepNr = stepNr + 1;
            final int[] candidates = constructCandidates(partialSolution, nextStepNr, context);

            for (int candidate : candidates) {
                partialSolution[nextStepNr] = candidate;
                makeMove(partialSolution, nextStepNr, context);
                backtrack(partialSolution, nextStepNr, context);
                unmakeMove(partialSolution, nextStepNr, context);
                if (finished) {
                    return;
                }
            }
        }
    }

    /**
     * Tests, whether the first stepNr elements of vector partialSolution
     * form a complete solution of the given problem.
     *
     * @param context - general information for this routine, e.g. n - the size of a target solution.
     * @return
     */
    protected abstract boolean isSolution(int[] partialSolution, int stepNr, T context);

    /**
     * Print, count or however process a complete solution, once it is constructed.
     */
    protected abstract void processSolution(int[] solution, int stepNr, T context);

    /**
     * Gets the complete set of possible candidates for the nextStepNr position of the partialSolution,
     * given the contents of the first nextStepNr - 1 positions.
     */
    protected abstract int[] constructCandidates(int[] partialSolution, int nextStepNr, T context);

    /**
     * Modify data structure in response to the latest move.
     */
    protected abstract void makeMove(int[] partialSolution, int nextStepNr, T context);

    /**
     * Clean up the data structure, when we take back the move.
     * Is more efficient than recreate the data structure from scratch,
     * because each move involves incremental changes that can easily be undone.
     */
    protected abstract void unmakeMove(int[] partialSolution, int nextStepNr, T context);

}
