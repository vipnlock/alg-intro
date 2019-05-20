package com.study.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,
                new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode n1, ListNode n2) {
                        return Integer.compare(n1.val, n2.val);
                    }
                });

        for(ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        if (pq.isEmpty()) {
            return null;
        }
        ListNode root = pq.poll();
        if (root.next != null) {
            pq.add(root.next);
        }

        ListNode tmp = root;
        while (!pq.isEmpty()) {
            ListNode next = pq.poll();
            if (next.next != null) {
                pq.add(next.next);
            }
            tmp.next = next;
            tmp = tmp.next;
        }

        return root;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}