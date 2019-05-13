package com.skiena.chapter4;

public class IntegerMinHeap {

    private int[] array;
    private int count = 0;

    public IntegerMinHeap(int capacity) {
        this.array = new int[capacity];
    }

    // O(n * log(n))
    public static IntegerMinHeap makeHeap(int[] array) {
        final IntegerMinHeap result = new IntegerMinHeap(array.length);
        for (int i : array) {
            result.insert(i);
        }
        return result;
    }

    // O(n)
    public static IntegerMinHeap makeHeapFaster(int[] array) {
        final IntegerMinHeap result = new IntegerMinHeap(array.length);
        for (int i = 0; i < array.length; i++) {
            result.array[i] = array[i];
        }
        result.count = result.array.length;
        for (int i = result.array.length - 1; i >= 0; i--) {
            result.bubbleDown(i);
        }
        return result;
    }

    public static void heapSort(int [] array) {
        final IntegerMinHeap heap = makeHeapFaster(array);

        for (int i = 0; i < array.length; i++) {
            array[i] = heap.extractMin();
        }
    }

    public int compare(int k, int x) {
        return compare(0, k, x);
    }

    private int compare(int index, int k, int x) {
        if (k <= 0 || index >= count) {
            return k;
        }

        if (array[index] < x) {
            k--;
            int leftChild = leftChild(index);
            int rightChild = rightChild(index);
            if (leftChild != -1) {
                k = compare(leftChild, k, x);
            }
            if (rightChild != -1) {
                k = compare(rightChild, k, x);
            }
        }
        return k;
    }

    // O(log(n)), because height of heap is log(n).
    public void insert(int value) {
        if (count >= array.length) {
            throw new IllegalStateException("Warning: priority queue overflow insert x = " + value);
        }
        array[count] = value;
        bubbleUp(count);
        count++;
    }

    // O(log(n)), because height of heap is log(n).
    public int extractMin() {
        if (count == 0) {
            throw new IllegalStateException("Empty priority queue.");
        }

        int min = array[0];
        array[0] = array[--count];
        bubbleDown(0);
        return min;
    }

    private void bubbleUp(int index) {
        int parentIndex = parentIndex(index);
        if (parentIndex == -1) {
            // at root of heap, no parent
            return;
        }

        if (compareValues(parentIndex, index) > 0) {
            swapValues(parentIndex, index);
            bubbleUp(parentIndex);
        }
    }

    // a.k.a. heapify
    private void bubbleDown(int index) {
        int leftChild = leftChild(index);
        int rightChild = rightChild(index);

        int minIndex = index;
        if (leftChild != -1 && array[minIndex] > array[leftChild]) {
            minIndex = leftChild;
        }
        if (rightChild != -1 && array[minIndex] > array[rightChild]) {
            minIndex = rightChild;
        }

        if (minIndex != index) {
            swapValues(minIndex, index);
            bubbleDown(minIndex);
        }
    }

    private int parentIndex(int i) {
        if (i == 0) {
            return -1;
        }
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        int result = 2 * i + 1;
        return result < count ? result : -1;
    }

    private int rightChild(int i) {
        int result = 2 * i + 2;
        return result < count ? result : -1;
    }

    private int compareValues(int index1, int index2) {
        return Integer.compare(array[index1], array[index2]);
    }

    private void swapValues(int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

}
