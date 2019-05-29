package com.study.leetcode;

import com.study.leetcode.structure.ListNode;

import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == headB) {
            return headA;
        } else if (headA == null) {
            return headB;
        } else if (headB == null) {
            return headA;
        }
        
        ListNode listALast = headA;
        while (listALast.next != null) {
            listALast = listALast.next;
        }
        listALast.next = headB;
        
        ListNode slow = headA;
        ListNode fast = headA.next;
        
        while (slow != null && fast != null && slow != fast) {
            slow = slow.next;
            if (fast.next == null) {
                fast = null;
                break;
            } else {
                fast = fast.next.next;
            }
        }
        if (slow == null || fast == null) {
            listALast.next = null;
            return null;
        }

        int count = 0;
        do {
            count++;
            slow = slow.next;
        } while (slow != fast);
        
        slow = headA;
        while (count-- > 0) {
            slow = slow.next;
        }
        fast = headA;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        listALast.next = null;
        return fast;
    }
    
}