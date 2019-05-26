package com.study.leetcode;

import com.study.leetcode.structure.Node;

import java.util.LinkedList;
import java.util.Queue;

/*
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
*/
class PopulatingNextRightPointers {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node curr = root;
        while (curr != null) {
            Node prev = curr;
            if (prev.left == null) {
                break;
            }
            while (prev != null) {
                prev.left.next = prev.right;
                if (prev.next != null) {
                    prev.right.next = prev.next.left;
                }
                prev = prev.next;
            }

            curr = curr.left;
        }


        return root;
    }

    public Node connectBFS(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int levelCount = 1;

        int nextCount = 0;
        while (!queue.isEmpty()) {
            if (levelCount == 0) {
                levelCount = nextCount;
                nextCount = 0;
            }
            Node tmp = queue.poll();
            levelCount--;

            Node next = null;
            if (!queue.isEmpty()) {
                next = queue.peek();
            }
            if (levelCount != 0) {
                tmp.next = next;
            }

            if (tmp.left != null) {
                queue.add(tmp.left);
                queue.add(tmp.right);
                nextCount += 2;
            }
        }
        return root;
    }
}