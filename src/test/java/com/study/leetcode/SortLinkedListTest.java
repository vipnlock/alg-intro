package com.study.leetcode;

import com.study.leetcode.structure.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortLinkedListTest {

    private SortLinkedList alg = new SortLinkedList();

    @Test
    void sortList1() {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head = alg.sortList(head);
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

    @Test
    void sortList2() {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        head = alg.sortList(head);
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

}