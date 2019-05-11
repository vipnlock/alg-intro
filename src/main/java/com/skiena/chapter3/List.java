package com.skiena.chapter3;

public class List {
    ListItem head;

    public static void main(String[] argv) {
        List list = new List();
        list.insert(1);
        list.insert(10);
        list.insert(100);
        System.out.println(list.search(1).item);
        System.out.println(list.search(10).item);
        System.out.println(list.search(100).item);
        list.delete(100);
        System.out.println("Deleted 100: " + (list.search(100) == null));
        list.delete(1);
        System.out.println("Deleted 1: " + (list.search(1) == null));
        list.delete(1000);
    }

    ListItem search(int value) {
        return this.search(head, value);
    }

    private ListItem search(ListItem head, int value) {
        if (head == null) {
            return null;
        }
        if (head.item == value) {
            return head;
        }
        return search(head.next, value);
    }

    void insert(int value) {
        ListItem list = new ListItem();
        list.item = value;
        list.next = this.head;
        this.head = list;
    }

    void delete(int value) {
        ListItem item = search(value);
        if (item == null) {
            return;
        }
        ListItem predecessor = findPredecessor(head, value);

        if (predecessor == null) {
            head = item.next;
        } else {
            predecessor.next = item.next;
        }
    }

    private ListItem findPredecessor(ListItem head, int value) {
        if (head == null || head.next == null) {
            return null;
        }
        if (head.next.item == value) {
            return head;
        } else {
            return findPredecessor(head.next, value);
        }
    }

}

class ListItem {
    int item;
    ListItem next;
}
