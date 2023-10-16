package com.example.algorithm.my_hello_algo.stack_queue;


class PracticeArrayQueue {
    private int[] nums;

    private int front;

    private int queueSize;

    public PracticeArrayQueue(int capacity) {
        nums = new int[capacity];
        front = queueSize = 0;
    }

    public int capacity() {
        return nums.length;
    }
    public int size() {
        return queueSize;
    }

    public boolean isEmpty() {
        return false;
    }

}
public class practice_array_queue {

}
