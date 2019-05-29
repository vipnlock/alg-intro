package com.study.leetcode;

import java.util.LinkedList;

class SlidingWindowMax {

    public int[] maxSlidingWindow(int[] nums, int k) {
        // We create a Deque, Qi of capacity k
        // IT stores only useful elements of current window of k elements.
        // An element is useful if it is in current window
        // and is greater than all other elements on left side of it
        // in current window.
        if (nums == null || nums.length == 0 || nums.length < k) {
            return new int[0];
        }
        int n = nums.length;
        
        int[] result = new int[n - k + 1];
        
        LinkedList<Integer> deque = new LinkedList<>();
        
        // Process first k (or first window) elements of array
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        
        int slidingCount = 0;
        // Process rest of the elements, i.e., from arr[k] to arr[n-1] 
        for (int i = k; i < n; i++) {
            result[slidingCount++] = nums[deque.peekFirst()];
            
            // Remove the elements which are out of this window
            if (deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }
            
            // Remove all useless elements (which are smeller that the current one)
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }
            
            // Add current element at the rear of Qi 
            deque.addLast(i);
        }
        result[slidingCount++] = nums[deque.peekFirst()];
        
        return result;
    }

}