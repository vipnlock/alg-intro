package com.skiena.chapter7;

import java.util.Arrays;

public class TspSimulatedAnnealing extends SimulatedAnnealing<int[]> {

    private final int[][] cities;

    public TspSimulatedAnnealing(int[][] cities) {
        this.cities = cities;
    }

    public void tsp() {
        int[] solution = anneal();
        System.out.println(Arrays.toString(solution));
        System.out.println("Cost = " + cost(solution));
    }

    @Override
    int[] initSolution() {
        int[] solution = new int[getSolutionSize()];
        for (int i = 0; i < getSolutionSize(); i++) {
            solution[i] = i;
        }
        return solution;
    }

    @Override
    int getSolutionSize() {
        return cities.length;
    }

    @Override
    double cost(int[] solution) {
        double cost = 0.0;
        for (int i = 0; i < solution.length; i++) {
            cost += cities[solution[i]][solution[(i + 1) % solution.length]];
        }
        return cost;
    }

    @Override
    double transition(int[] solution, int ind1, int ind2) {
        int n = getSolutionSize();
        double delta = -cities[solution[(ind1 + n - 1) % n]][solution[ind1]];
        delta -= cities[solution[ind1]][solution[(ind1 + 1) % n]];
        delta -= cities[solution[(ind2 + n - 1) % n]][solution[ind2]];
        delta -= cities[solution[ind2]][solution[(ind2 + 1) % n]];
        int tmp = solution[ind1];
        solution[ind1] = solution[ind2];
        solution[ind2] = tmp;
        delta += cities[solution[(ind1 + n - 1) % n]][solution[ind1]];
        delta += cities[solution[ind1]][solution[(ind1 + 1) % n]];
        delta += cities[solution[(ind2 + n - 1) % n]][solution[ind2]];
        delta += cities[solution[ind2]][solution[(ind2 + 1) % n]];

        return delta;
    }

}
