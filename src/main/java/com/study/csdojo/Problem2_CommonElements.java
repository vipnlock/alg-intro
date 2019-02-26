package com.study.csdojo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * You are given two sorted arrays. They are sorted in the ascending order.
 * Write a function that takes these two arrays and returns an array of the common elements between them two.
 */
public class Problem2_CommonElements {

    Integer[] commonElements(int[] array1, int[] array2) {
        int p1 = 0;
        int p2 = 0;
        List<Integer> result = new LinkedList<>();

        while (p1 < array1.length && p2 < array2.length) {
            if (array1[p1] == array2[p2]) {
                result.add(array1[p1]);
                p1++;
                p2++;
            } else if (array1[p1] < array2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        return result.toArray(new Integer[0]);
    }

    Integer[] myCommonElements(int[] array1, int[] array2) {
        int[] first, second;
        if (array1.length >= array2.length) {
            first = array1;
            second = array2;
        } else {
            first = array2;
            second = array1;
        }
        int n = first.length;
        int m = second.length;

        List<Integer> result = new ArrayList<>();

        int j = 0;
        for (int firstElement : first) {
            while (j < m && firstElement > second[j]) {
                j++;
            }
            if (j == m) {
                break;
            } else if (firstElement == second[j]) {
                result.add(firstElement);
                j++;
            }
        }
        return result.toArray(new Integer[0]);
    }

}
