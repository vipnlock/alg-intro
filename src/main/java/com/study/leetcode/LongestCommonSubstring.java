package com.study.leetcode;

public class LongestCommonSubstring {

    public static String lcs(String s1, String s2) {
        // s1: abab
        // s2: baba
        // Sij = Si-1,j-1 + 1, Si == Sj
        // Sij = 0, Si != Sj
        // Si0 = 0
        // S0j = 0

        //     1 2 3 4
        //     A B A B
        //   0 0 0 0 0
        // B 0 0 1 0 1
        // A 0 1 0 2 0
        // B 0 0 2 0 3
        // A 0 1 0 3 0
        int[][] m = new int[s1.length() + 1][s2.length() + 1];
        int max = 0;
        int maxI = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    m[i][j] = m[i-1][j-1] + 1;
                } else {
                    m[i][j] = 0;
                }
                if (m[i][j] > max) {
                    max = m[i][j];
                    maxI = i;
                }
            }
        }
        return s1.substring(maxI - max, maxI);
    }

    public static void main(String[] argv) {
        System.out.println(lcs("ABAB", "BABA"));
    }

}
