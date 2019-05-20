package com.study.leetcode;

import java.util.LinkedList;

class TrappingRainWater {

    /*
     * Two pointers approach.
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;

        int area = 0;

        int left = 0;
        int leftMax = height[0];
        int right = n - 1;
        int rightMax = height[n - 1];

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < leftMax) {
                    area += leftMax - height[left];
                } else if (height[left] > leftMax) {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (height[right] < rightMax) {
                    area += rightMax - height[right];
                } else if (height[right] > rightMax) {
                    rightMax = height[right];
                }
                right--;
            }
        }

        return area;
    }

    /*
     * Stack of array's indeces.
     */
    public int trapStack(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;

        int area = 0;
        LinkedList<Integer> stack = new LinkedList<>();

        int i = 0;
        //
        //        П
        //    П xxПП П
        // _ПxППxПППППП
        // 010210132121
        //
        // 012345678901
        while (i < n) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int prev = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                area += (Math.min(height[stack.peek()], height[i]) - height[prev])
                        * (i - stack.peek() - 1);
            }
            stack.push(i++);
        }

        return area;
    }

    /*
     * Stack of (value, position)
     */
    public int trap_my(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;

        int i = 0;
        while (i < n && height[i] == 0) {
            i++;
        }

        int area = 0;
        LinkedList<Pair> stack = new LinkedList<>();

        while (i < n) {
            if (stack.isEmpty()) {
                stack.push(new Pair(height[i], i));

            } else if (stack.peek().val < height[i]) {
                Pair prev = stack.pop();
                while (!stack.isEmpty() && stack.peek().val <= height[i]) {
                    Pair before = stack.peek();
                    if (before.val != prev.val) {
                        int deltaH = Math.min(before.val, height[i]) - prev.val;
                        int deltaW = i - before.pos - 1;
                        area += deltaH * deltaW;
                    }

                    prev = stack.pop();
                }
                if (!stack.isEmpty() && stack.peek().val > height[i]
                        && height[i] > prev.val) {
                    int deltaH = height[i] - prev.val;
                    int deltaW = i - stack.peek().pos - 1;
                    area += deltaH * deltaW;
                    stack.push(new Pair(height[i], i));
                } else {
                    stack.push(new Pair(height[i], i));
                }
                // otherwise: forget about prev
            } else if (stack.peek().val >= height[i]) {
                stack.push(new Pair(height[i], i));
            }
            i++;
        }

        return area;
    }
    
    private static class Pair {
        private int val;
        private int pos;
        public Pair(int val, int pos) {
            this.val = val;
            this.pos = pos;
        }
    }
}