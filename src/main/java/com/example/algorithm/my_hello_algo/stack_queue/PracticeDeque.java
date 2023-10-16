package com.example.algorithm.my_hello_algo.stack_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class PracticeDeque {

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        deque.offerLast(3);
        deque.offerLast(2);
        deque.offerLast(5);

        System.out.println("bidirectional queue deque = " + deque);

        int peekFirst = deque.peekFirst();
        System.out.println("leader element peekFirst = " + peekFirst);
        int peekLast = deque.peekLast();
        System.out.println("tail element peekLast = " + peekLast);

        deque.offerLast(4);
        System.out.println("Element 4 After the tail of the team joins the team deque = " + deque);
        deque.offerFirst(1);
        System.out.println("Element 1 After the leader of the team joins the team deque = " + deque);

        int popLast = deque.pollLast();
        System.out.println("Dequeue element at the end of the queue = " + popLast + "，After the end of the queue leaves the queue deque = " + deque);
        int popFirst = deque.pollFirst();
        System.out.println("The first element of the team = " + popFirst + "，After the team leader leaves the team deque = " + deque);


        int size = deque.size();
        System.out.println("Bidirectional queue length size = " + size);

        boolean isEmpty = deque.isEmpty();
        System.out.println("Is the deque queue empty? = " + isEmpty);

    }
}
