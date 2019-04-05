package com.skiena.chapter7;

import java.util.Random;

public abstract class SimulatedAnnealing<S> {

    private static final int COOLING_STEPS = 15_000;
    private static final double COOLING_FRACTION = 0.95;
    private static final int STEPS_PER_TEMPERATURE = 500;
    private static final double K = 1.0;

    private final Random random = new Random(System.nanoTime());

    S anneal() {
        double temperature = 1.0;   // the current system temperature

        S solution = initSolution();
        double currentCost = cost(solution);

        for (int i = 1; i <= COOLING_STEPS; i++) {
            temperature *= COOLING_FRACTION;

            double startCost = currentCost;

            for (int j = 1; j <= STEPS_PER_TEMPERATURE; j++) {
                int ind1 = random.nextInt(getSolutionSize());   // pick indexes of elements to swap
                int ind2 = random.nextInt(getSolutionSize());

                double delta = transition(solution, ind1, ind2);
                double merit = Math.exp((-delta / currentCost) / (K * temperature));  // energy function

                if (delta < 0) {                         // ACCEPT-WIN
                    currentCost += delta;
                    if (currentCost != cost(solution)) {
                        throw new IllegalStateException("Can't be: " + currentCost + " != " + cost(solution));
                    }

                } else if (merit > random.nextFloat()) { // ACCEPT-LOSS
                    currentCost += delta;
                    if (currentCost != cost(solution)) {
                        throw new IllegalStateException("Can't be: " + currentCost + " != " + cost(solution));
                    }
                } else {                                 // REJECT
                    transition(solution, ind1, ind2);
                }
            }

            // Restore temprerature if progress has been made
            if (currentCost - startCost < 0) {
                temperature /= COOLING_FRACTION;
            }
        }
        return solution;
    }

    abstract S initSolution();
    abstract int getSolutionSize();

    abstract double cost(S solution);

    abstract double transition(S solution, int ind1, int ind2);

}
