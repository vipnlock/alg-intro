package com.skiena.chapter3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Java standard classes for:
 * Stack:
 * - java.util.Stack:       push, pop
 * - java.util.ArrayDeque:  push, pop
 * - java.util.LinkedList:  push, pop
 * Queue:
 * - java.util.LinkedList:  add, poll
 * PriorityQueue:
 * - java.util.PriorityQueue:   add, poll
 */
public class Containers {

    public static void main(String[] argv) {
        Containers main = new Containers();
        main.testQueue();
        main.testStack();
        main.testStackOnDeque();
        main.testStackOnLinkedList();
        main.testPriorityQueue();
    }

    private void testQueue() {
        System.out.println("Test Queue");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(1000);
        queue.add(10);
        queue.add(100);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
        queue.poll();
    }

    private void testStack() {
        System.out.println("Test Stack");
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(1000);
        stack.push(10);
        stack.push(100);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private void testStackOnDeque() {
        System.out.println("Test Stack based on Deque");
        Deque<Integer> deque = new ArrayDeque<>();

        deque.push(1);
        deque.push(1000);
        deque.push(10);
        deque.push(100);

        while (!deque.isEmpty()) {
            System.out.println(deque.pop());
        }
    }

    private void testStackOnLinkedList() {
        System.out.println("Test Stack based on a LinkedList");
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.push(1);
        linkedList.push(1000);
        linkedList.push(10);
        linkedList.push(100);

        while (!linkedList.isEmpty()) {
            System.out.println(linkedList.pop());
        }
    }

    private void testPriorityQueue() {
        System.out.println("Test Priority Queue");
        PriorityQueue<Item> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Item(1));
        priorityQueue.add(new Item(1000));
        priorityQueue.add(new Item(10));
        priorityQueue.add(new Item(100));
        System.out.println(priorityQueue);

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }

    private static class Item implements Comparable<Item> {
        private int value;

        public Item(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Item o) {
            return Integer.compare(this.value, o.value);
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

}
