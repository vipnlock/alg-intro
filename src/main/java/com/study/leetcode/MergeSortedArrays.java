package com.study.leetcode;

/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

    The number of elements initialized in nums1 and nums2 are m and n respectively.
    You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.

Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 */
class MergeSortedArrays {
    public void merge(int[] a, int m, int[] b, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (a[i] > b[j]) {
                a[k--] = a[i--];
            } else {
                a[k--] = b[j--];
            }
        }
        while (j >= 0) {
            a[k--] = b[j--];
        }
    }

    public void mergeMy(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        int i1 = 0;
        int i2 = 0;

        //     3, 2, 3, 1, 2, 2
        // i1:          |
        //     2, 5, 6
        // i2:    |

        int target = m;
        int iter = 0;
        boolean flag = true;
        while (i1 < m && i2 < n) {
            if (nums1[i1] <= nums2[i2]) {
                nums1[target++] = nums1[i1++];
            } else {
                nums1[target++] = nums2[i2++];
            }
            iter++;
            if (flag && iter == n) {
                target = 0;
                flag = false;
            }
        }
        while (i1 < m) {
            nums1[target++] = nums1[i1++];
            iter++;
            if (flag && iter == n) {
                target = 0;
                flag = false;
            }
        }
        while (i2 < n) {
            nums1[target++] = nums2[i2++];
            iter++;
            if (flag && iter == n) {
                target = 0;
                flag = false;
            }
        }
        System.arraycopy(nums1, m, nums2, 0, n);
        for (int i = n + m - 1; i > n - 1; i--) {
            nums1[i] = nums1[i - n];
        }
        System.arraycopy(nums2, 0, nums1, 0, n);
    }

}