package com.skiena.chapter2;

public class Exercise {

    public static void main(String[] argv) {
        System.out.println(new Exercise().function(1) + " " + new Exercise().function2(1));
        System.out.println(new Exercise().function(2) + " " + new Exercise().function2(2));
        System.out.println(new Exercise().function(3) + " " + new Exercise().function2(3));
        System.out.println(new Exercise().function(4) + " " + new Exercise().function2(4));
        System.out.println(new Exercise().function(5) + " " + new Exercise().function2(5));
        System.out.println(new Exercise().function(6) + " " + new Exercise().function2(6));
        System.out.println(new Exercise().function(7) + " " + new Exercise().function2(7));
    }

    int function(int n) {
        int r = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = i + j - 1; k <= n; k++){
                    r++;
                }
            }
        }
        return r;
    }

    int function2(int n) {
        return n * (n - 1) / 2;
    }

}
