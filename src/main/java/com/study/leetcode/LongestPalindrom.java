package com.study.leetcode;

public class LongestPalindrom {

    public static String lp(String s) {
        //                            i <= j
        // str: abacdfgdcaba, X aa X
        // str: abac
        // str[i..j]
        // Pii = 1
        // Pii+1 = 1, Si = Si+1
        // Pij = Pi+1j-1, Si = Sj
        // Pij = 0, Si != Sj
        //
        // Build P:
        //   a b a c
        // a 1 0 1 0
        // b x 1 0 0
        // a x x 1 0
        // c x x x 1

        //   B A B A B
        // B 1 0 1 0 1
        // A x 1 0 1 0
        // B x x 1 0 1
        // A x x x 1 0
        // B x x x x 1

        int n = s.length();
        int[][] p = new int[n][n];
        for (int i = 0; i < n; i++) {
            p[i][i] = 1;
            if (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                p[i][i + 1] = 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i + 1; j--) {
                if (s.charAt(i) != s.charAt(j)) {
                    p[i][j] = 0;
                } else {
                    p[i][j] = p[i + 1][j - 1];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (p[i - j][n - 1 - j] == 1) {
                    return s.substring(i - j, n - j - 1 + 1);
                }
            }
        }

//        for (int i = 0; i < p.length; i++) {
//            System.out.println(Arrays.toString(p[i]));
//        }
        return "";
    }

    public static void main(String[] argv) {
        System.out.println(lp("abacdfgdcaba"));
    }

}
