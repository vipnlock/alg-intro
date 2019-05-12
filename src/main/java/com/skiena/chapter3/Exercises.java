package com.skiena.chapter3;

import java.util.LinkedList;

public class Exercises {

    /*
     * Ex. 3.1.
     */
    public boolean checkParenthesis(String str) {
        final LinkedList<Character> stack = new LinkedList();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                stack.push('(');
            } else if (stack.isEmpty()) {
                return false;
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    /*
     * Ex. 3.2.
     */
    public Node reverseLinkedList(Node head) {
        return reverseLinkedList(head, null);
    }

    public Node reverseLinkedListWithoutRecursion(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void printLinkedList(Node node) {
        if (node == null) {
            System.out.print("Null");
        }
        Node tmp = node;
        while (tmp != null) {
            System.out.print(tmp.value + " -> ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    private Node reverseLinkedList(Node head, Node predecessor) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            head.next = predecessor;
            return head;
        }

        Node node = reverseLinkedList(head.next, head);
        head.next = predecessor;
        return node;
    }

    public static class Node {
        public final int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }


}
