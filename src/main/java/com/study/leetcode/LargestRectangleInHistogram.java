package com.study.leetcode;

import java.util.LinkedList;

class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int max = 0, n = heights.length;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            int h = i < n ? heights[i] : -1;
            while (!stack.isEmpty() && heights[stack.peek()] > h) {
                int prevIdx = stack.pop();
                int prevh = heights[prevIdx];
                int width = stack.isEmpty() ? i : i - 1 - stack.peek();
                max = Math.max(max, prevh * width);
            }
            stack.push(i);
        }

        return max;
    }

    public int largestRectangleAreaMy(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int n = heights.length;

        int totalMax = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);

        for (int i = 1; i <= n; i++) {
            int h = (i < n) ? heights[i] : -1;

            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int prevI = stack.pop();
                int prevH = heights[prevI];
                int width = (stack.isEmpty()) ? i : i - stack.peek() - 1;

                totalMax = Math.max(totalMax, prevH * width);
            }
            stack.push(i);
        }

        return totalMax;
    }

}