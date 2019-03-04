package com.study.csdojo;

public class Problem9_NthElement {

    private static class Node {
        private int value;
        private Node child;

        public Node(int value, Node child) {
            this.value = value;
            this.child = child;
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }

    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        Node current = new Node(1, null);
        for (int i = 2; i < 8; i++) {
            current = new Node(i, current);
        }
        Node head = current;
        // head = 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (null)

        Node current2 = new Node(4, null);
        for (int i = 3; i > 0; i--) {
            current2 = new Node(i, current2);
        }
        Node head2 = current2;
        // head2 = 1 -> 2 -> 3 -> 4 -> (null)

        System.out.println("should return 1: " + nthFromLast(head, 1));
        System.out.println("should return 5: " + nthFromLast(head, 5));
        System.out.println("should return 3: " + nthFromLast(head2, 2));
        System.out.println("should return 1: " + nthFromLast(head2, 4));
        System.out.println("should return null: " + nthFromLast(head2, 5));
        System.out.println("should return null: " + nthFromLast(null, 1));
    }


    // Implement your function below.
    public static Node nthFromLast(Node head, int n) {
        Node left = head;
        Node right = head;
        for (int i = 0; i < n; i++) {
            if (right == null) {
                return null;
            }
            right = right.child;
        }
        while (right != null) {
            left = left.child;
            right = right.child;
        }
        return left;
    }

    public static Node myNthFromLast(Node head, int n) {
        if (head == null) {
            return null;
        }
        int count = 0;
        Node tmp = head;
        while (tmp != null) {
            count++;
            tmp = tmp.child;
        }
        if (count < n) {
            return null;
        }
        tmp = head;
        for (int i = 0; i < count - n; i++) {
            tmp = tmp.child;
        }
        return tmp;
    }


    //  NOTE: Feel free to use the following function for testing.
    //  It converts the given linked list into an easy-to-read string format.
    //  Example: 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (null)
    public static String linkedListToString(Node head) {
        Node current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.value);
            sb.append(" -> ");
            current = current.child;
        }
        sb.append("(null)");
        return sb.toString();
    }

}
