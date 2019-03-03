package com.study.csdojo;

public class Problem8_RotatingArray {

    int[][] rotate(int[][] givenArray, int n) {
        for (int i = 0; i < n / 2 + 1; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int[] current = {i, j};
                int[] next1 = {j, n - i - 1};
                int[] next2 = {n - i - 1, n - j - 1};
                int[] next3 = {n - j - 1, i};

                int value = givenArray[current[0]][current[1]];
                givenArray[current[0]][current[1]] = givenArray[next3[0]][next3[1]];
                givenArray[next3[0]][next3[1]] = givenArray[next2[0]][next2[1]];
                givenArray[next2[0]][next2[1]] = givenArray[next1[0]][next1[1]];
                givenArray[next1[0]][next1[1]] = value;
            }
        }
        return givenArray;
    }

}
