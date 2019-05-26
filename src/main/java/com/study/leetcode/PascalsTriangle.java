package com.study.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new LinkedList<>();

        int[] tmp1 = new int[numRows];
        int[] tmp2 = new int[numRows];
        tmp1[0] = 1;
        
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new LinkedList<>();            
            for (int j = 0; j < i; j++) {
                tmp2[j] = j > 0 ? tmp1[j - 1] + tmp1[j] : tmp1[j];
                list.add(tmp2[j]);
            }
            res.add(list);
            int[] tmp3 = tmp2;
            tmp2 = tmp1;
            tmp1 = tmp3;
        }
        return res;
    }
}