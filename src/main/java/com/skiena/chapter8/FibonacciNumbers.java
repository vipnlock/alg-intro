package com.skiena.chapter8;

public class FibonacciNumbers {

    private static final int MAX_NUMBER = 45;
    private static final int UNKNOWN = -1;

    /*
     * Recursive approach.
     */
    int simpleFib(int a) {
        if (a == 0) {
            return 0;
        }
        if (a == 1) {
            return 1;
        }
        return simpleFib(a - 1) + simpleFib(a - 2);
    }

    /*
     * Caching recursive approach.
     */
    private int[] cache;
    int cachingFib(int a) {
        cache = new int[MAX_NUMBER];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i < MAX_NUMBER; i++) {
            cache[i] = UNKNOWN;
        }

        return fib_Cached(a);
    }
    private int fib_Cached(int a) {
        if (cache[a] == UNKNOWN) {
            cache[a] = fib_Cached(a - 1) + fib_Cached(a - 2);
        }
        return cache[a];
    }

    /*
     * DP approach.
     */
    int fib_DP(int a) {
        int cache[] = new int[MAX_NUMBER];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i <= a; i++) {
            cache[i] = cache[i - 2] + cache[i - 1];
        }
        return cache[a];
    }

    int fib_DP_ultimate(int a) {
        int back2 = 0;
        int back1 = 1;
        int next;
        if (a == 0) {
            return 0;
        }
        for (int i = 2; i < a; i++) {
            next = back1 + back2;
            back2 = back1;
            back1 = next;
        }
        return back1 + back2;
    }

}
