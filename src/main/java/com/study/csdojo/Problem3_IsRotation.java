package com.study.csdojo;

public class Problem3_IsRotation {

    boolean isRotation(int[] array1, int[] array2) {
        int n = array1.length;
        if (n != array2.length) {
            return false;
        }
        int key = array1[0];
        int keyIndex = -1;
        for (int i = 0; i < n; i++) {
            if (key == array2[i]) {
                keyIndex = i;
                break;
            }
        }
        if (keyIndex == -1) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            int j = (i + keyIndex) % n;
            if (array1[i] != array2[j]) {
                return false;
            }
        }
        return true;
    }

    boolean myIsRotation(int[] array1, int[] array2) {
        int n = array1.length;
        if (n != array2.length) {
            return false;
        }
        int p1 = 0;
        int p2 = 0;

        while (array1[p1] != array2[p2]) {
            p1++;
        }
        while (p1 < n) {
            if (array1[p1] != array2[p2]) {
                return false;
            }
            p1++;
            p2++;
        }
        p1 = 0;
        while (p2 < n) {
            if (array1[p1] != array2[p2]) {
                return false;
            }
            p1++;
            p2++;
        }
        return true;
    }



}
