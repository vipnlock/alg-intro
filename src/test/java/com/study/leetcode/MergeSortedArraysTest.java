package com.study.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedArraysTest {

    private MergeSortedArrays alg = new MergeSortedArrays();

    @Test
    void merge() {
//        int[] nums1 = new int[] {1,2,4,5,6,0};
//        alg.merge(nums1, 5, new int [] {3}, 1);
//        int[] nums1 = new int[] {4,0,0,0,0,0};
//        alg.merge(nums1, 1, new int [] {1,2,3,5,6}, 5);
//        int[] nums1 = new int[] {1,2,3,0,0,0};
//        alg.merge(nums1, 3, new int [] {4,5,6}, 3);
        int[] nums1 = new int[] {1,3,5,0,0,0};
        alg.merge(nums1, 3, new int [] {2,4,6}, 3);
        System.out.println(Arrays.toString(nums1));
    }

}