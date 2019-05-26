package com.study.leetcode;

import com.study.leetcode.structure.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class SortLinkedList {

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fake = new ListNode(0);
        fake.next = head;

        int step = 1;

        while (true) {
            int iter = 0;
            ListNode prevList = fake;
            ListNode listNext = fake.next;

            while (listNext != null) {
                ListNode list1 = listNext;
                ListNode list2 = listNext;

                int count = 0;
                do {
                    list2 = list2.next;
                } while (list2 != null && ++count < step);

                listNext = list2;
                if (list2 != null) {
                    count = 0;
                    do {
                        listNext = listNext.next;
                    } while (listNext != null && ++count < step);
                } else if (iter == 0) {
                    return fake.next;
                }

                prevList.next = merge(list1, list2, listNext);
                while (prevList.next != listNext) {
                    prevList = prevList.next;
                }
                iter++;
            }
            step <<= 1;
        }
    }

    private ListNode merge(ListNode list1, ListNode list2, ListNode next) {
        if (list2 == null) {
            return list1;
        }
        ListNode head;
        head = list1;

        int count = 0;
        do {
            count++;
            head = head.next;
        } while (head != list2);

        int count1 = 0;
        int count2 = 0;

        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
            count1 = 1;
        } else {
            head = list2;
            list2 = list2.next;
            count2 = 1;
        }

        ListNode tmp = head;

        while (count1 < count && count2 < count && list2 != null) {
            if (list1.val < list2.val) {
                tmp.next = list1;
                list1 = list1.next;
                count1++;
            } else {
                tmp.next = list2;
                list2 = list2.next;
                count2++;
            }
            tmp = tmp.next;
        }
        while (count1 < count) {
            tmp.next = list1;
            tmp = tmp.next;
            list1 = list1.next;
            count1++;
        }
        while (count2 < count && list2 != null) {
            tmp.next = list2;
            tmp = tmp.next;
            list2 = list2.next;
            count2++;
        }

        tmp.next = next;
        return head;
    }
}