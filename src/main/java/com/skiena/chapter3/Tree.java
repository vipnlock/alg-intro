package com.skiena.chapter3;

public class Tree {

    private Node root;

    public Tree() {
        // nothing
    }

    public Tree(Node root) {
        this.root = root;
    }

    Node search(int key) {
        return search(root, key);
    }

    Node min() {
        if (root == null) {
            return null;
        }

        Node minNode = root;
        while (minNode.left != null) {
            minNode = minNode.left;
        }
        return minNode;
    }

    void traverseTree() {
        this.traverseTree(root);
    }

    void insert(int value) {
        this.insert(root, value, null);
    }



    private Node search(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (root.value == key) {
            return root;
        } else if (key < root.value) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    private void traverseTree(Node root) {
        if (root != null) {
            traverseTree(root.left);
            System.out.println(root.value);
            traverseTree(root.right);
        }
    }

    private void insert(Node root, int value, Node parent) {
        if (root == null) {
            this.root = new Node(value);
            return;
        }

        if (value < root.value) {
            if (root.left != null) {
                insert(root.left, value, root);
            } else {
                root.left = new Node(value);
                root.left.parent = root;
            }
        } else {
            if (root.right != null) {
                insert(root.right, value, root);
            } else {
                root.right = new Node(value);
                root.right.parent = root;
            }
        }
    }

    public static class Node {
        private final int value;
        public Node parent;    // optional field
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + ": " + (left != null ? "/" : "x") + (right != null ? "\\" : "x");
        }
    }

}
