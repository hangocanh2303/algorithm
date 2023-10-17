package com.example.algorithm.my_hello_algo.stack_queue;



import java.util.Arrays;

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
        return queueSize == 0;
    }

    public int peek() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return nums[front];
    }

    public int pop() {
        int num = peek();
        front = (front + 1) % capacity();
        queueSize--;
        return num;
    }

    public void push(int num) {
        if (queueSize == capacity()) {
            System.out.println("Queue is full");
            return;
        }
        int rear = (front + queueSize) % capacity();
        nums[rear] = num;
        queueSize++;
    }

    public int[] toArray(){
        int[] res = new int[queueSize];
        for (int i = 0, j = front; i < queueSize; i++, j++) {
            res[i] = nums[j % capacity()];
        }
        return res;
    }

}
public class practice_array_queue {
    public static void main(String[] args) {
        /* Initialize queue */
        int capacity = 10;
        PracticeArrayQueue queue = new PracticeArrayQueue(capacity);

        /*Enqueue elements */
        queue.push(1);
        queue.push(3);
        queue.push(2);
        queue.push(5);
        queue.push(4);
        System.out.println("queue = " + Arrays.toString(queue.toArray()));

        /* Access the leader element */
        int peek = queue.peek();
        System.out.println("peek = " + peek);

        /* Element dequeue */
        int pop = queue.pop();
        System.out.println("pop = " + pop + "，queue = " + Arrays.toString(queue.toArray()));

        /* Get the length of the queue */
        int size = queue.size();
        System.out.println("size = " + size);

        /* Determine whether the queue is empty */
        boolean isEmpty = queue.isEmpty();
        System.out.println("Is the queue empty? = " + isEmpty);

        /* Test circular array */
        for (int i = 0; i < 10; i++) {
            queue.push(i);
            queue.pop();
            System.out.println("The " + i + "th round enters the queue + after dequeue = " + Arrays.toString(queue.toArray()));
        }
    }
}
