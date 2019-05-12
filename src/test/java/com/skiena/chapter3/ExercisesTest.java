package com.skiena.chapter3;

import org.junit.jupiter.api.Test;

class ExercisesTest {

    private Exercises alg = new Exercises();

    @Test
    void checkParenthesis() {
        System.out.println(alg.checkParenthesis("((())())()") + " should be true");
        System.out.println(alg.checkParenthesis(")()(") + " should be false");
        System.out.println(alg.checkParenthesis("())") + " should be false");
    }

    @Test
    void reverseLinkedList() {
        Exercises.Node head = new Exercises.Node(1);
        head.next = new Exercises.Node(2);
        head.next.next = new Exercises.Node(3);

        alg.printLinkedList(head);

        alg.printLinkedList(alg.reverseLinkedList(null));
        alg.printLinkedList(alg.reverseLinkedList(new Exercises.Node(1)));
        alg.printLinkedList(alg.reverseLinkedList(head));

        System.out.println("Without recursion: ");
        alg.printLinkedList(alg.reverseLinkedListWithoutRecursion(null));
        alg.printLinkedList(alg.reverseLinkedListWithoutRecursion(new Exercises.Node(1)));

        head = new Exercises.Node(1);
        head.next = new Exercises.Node(2);
        head.next.next = new Exercises.Node(3);
        alg.printLinkedList(alg.reverseLinkedListWithoutRecursion(head));
    }

}