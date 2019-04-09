package com.skiena.chapter8;

public class ApproximateStringMatching {

    private static final int MATCH = 0;
    private static final int INSERT = 1;
    private static final int DELETE = 2;

    private static final int MAXLEN = 100;

    /*
     * 1. Recursive approach - exponential.
     */
    int stringCompareRecursion(String pattern, String text, int j, int i) {
        int[] optionsCosts = new int[3];

        if (j == -1) {
            return (i + 1) * indel(' ');
        }
        if (i == -1) {
            return (j + 1) * indel(' ');
        }

        optionsCosts[MATCH] = stringCompareRecursion(pattern, text, j - 1, i - 1) + match(pattern.charAt(j), text.charAt(i));
        optionsCosts[INSERT] = stringCompareRecursion(pattern, text, j, i - 1) + indel(text.charAt(i));
        optionsCosts[DELETE] = stringCompareRecursion(pattern, text, j - 1, i) + indel(pattern.charAt(j));

        int lowestCost = Math.min(optionsCosts[MATCH], optionsCosts[INSERT]);
        lowestCost = Math.min(lowestCost, optionsCosts[DELETE]);

        return lowestCost;
    }

    /**
     * The functions match(c,d) presents the costs for transforming character c to d.
     * For standard edit distance, match should cost nothing if the characters are identical,
     * and 1 otherwise.
     * @param c
     * @param d
     * @return
     */
    private int match(char c, char d) {
        return (c == d) ? 0 : 1;
    }

    /**
     * The function presents the costs for inserting/deleting character c.
     * indel returns 1 regardless of what the argument is.
     * @param c
     * @return
     */
    private int indel(char c) {
        return 1;
    }

    /*
     * 2. Table-based DP implementation.
     */

    int stringCompareDP(String pattern, String text) {
        final Cell[][] table = new Cell[MAXLEN + 1][MAXLEN + 1]; // DP table
        int[] optionsCosts = new int[3];                         // cost of the three options

        for (int i = 0; i <= MAXLEN; i++) {
            table[0][i] = new Cell(i, (i > 0) ? INSERT : -1);   // row init
            table[i][0] = new Cell(i, (i > 0) ? DELETE : -1);   // column init
        }
        // First, it gets its intermediate values using table lookup instead of recursive calls.
        for (int j = 1; j < pattern.length(); j++) {
            for (int i = 1; i < text.length(); i++) {
                optionsCosts[MATCH] = table[j - 1][i - 1].cost + match(pattern.charAt(j), text.charAt(i));
                optionsCosts[INSERT] = table[j][i - 1].cost + indel(text.charAt(i));
                optionsCosts[DELETE] = table[j - 1][i].cost + indel(pattern.charAt(j));

                table[j][i] = new Cell(optionsCosts[MATCH], MATCH);
                for (int k = INSERT; k <= DELETE; k++) {
                    if (optionsCosts[k] < table[j][i].cost) {
                        table[j][i].cost = optionsCosts[k];
                        // Second, it updates the parent field of each cell, which will enable us to reconstruct the edit sequence later.
                        table[j][i].parent = k;
                    }
                }
            }
        }
        // Third, it is implemented using a more general goal cell() function instead of just returning m[|P|][|T|].cost
        return table[pattern.length() - 1][text.length() - 1].cost;
    }

    private static class Cell {
        private int cost;   // cost of reaching this cell
        private int parent; // parent cell

        public Cell(int cost, int parent) {
            this.cost = cost;
            this.parent = parent;
        }
    }

}
