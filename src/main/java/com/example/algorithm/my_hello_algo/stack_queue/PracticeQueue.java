package com.example.algorithm.my_hello_algo.stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PracticeQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        queue.offer(3);
        queue.offer(2);
        queue.offer(5);
        queue.offer(4);

        System.out.println("queue = " + queue);

        int peek = queue.peek();
        System.out.println("peek = " + peek);

        int poll = queue.poll();
        System.out.println("poll = " + poll + ", queue = " + queue);

        int size = queue.size();
        System.out.println("size = " + size);

        boolean isEmpty = queue.isEmpty();
        System.out.println("Is the queue empty? = " + isEmpty);
    }
}
