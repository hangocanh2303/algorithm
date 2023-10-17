package com.example.algorithm.my_hello_algo.stack_queue;


import java.util.Arrays;

class PracticeArrayDeque {
    private int[] nums;

    private int queueSize;

    private int front;

    public PracticeArrayDeque(int capacity){
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
        return size() == 0;
    }

    private int index(int i) {
        return (i + capacity()) % capacity();
    }

    public void pushFirst(int num) {
        if(queueSize == capacity()){
            System.out.println("The bidirectional queue is full");
            return;
        }
        front = index(front - 1);
        nums[front] = num;
        queueSize++;
    }

    public void pushLast(int num){
        if(queueSize == capacity()){
            System.out.println("The bidirectional queue is full");
            return;
        }
        int rear = index(front + queueSize);
        nums[rear] = num;
        queueSize++;
    }

    public int peekFirst() {
        if(isEmpty())
            throw new IndexOutOfBoundsException();
        return nums[front];
    }

    public int peekLast() {
        if(isEmpty())
            throw new IndexOutOfBoundsException();
        int last = index(front + queueSize - 1);
        return nums[last];
    }

    public int popFirst() {
        int num = peekFirst();
        front = index(front + 1);
        queueSize--;
        return num;
    }

    public int popLast() {
        int num = peekLast();
        queueSize--;
        return num;
    }

    public int[] toArray() {
        int[] res = new int[queueSize];
        for (int i = 0, j = front; i < queueSize; i++, j++) {
            res[i] = nums[index(j)];
        }
        return res;
    }
}

public class practice_array_deque {
    public static void main(String[] args) {

        PracticeArrayDeque deque = new PracticeArrayDeque(10);

        deque.pushLast(3);
        deque.pushLast(2);
        deque.pushLast(5);
        System.out.println("deque = " + Arrays.toString(deque.toArray()));


        int peekFirst = deque.peekFirst();
        System.out.println("peekFirst = " + peekFirst);
        int peekLast = deque.peekLast();
        System.out.println("peekLast = " + peekLast);


        deque.pushLast(4);
        System.out.println("Element 4 deque after the end of the queue enters the queue = " + Arrays.toString(deque.toArray()));
        deque.pushFirst(1);
        System.out.println("Element 1 deque after the leader of the team joins the team = " + Arrays.toString(deque.toArray()));


        int popLast = deque.popLast();
        System.out.println("Dequeue element at the end of the queue = " + popLast + "，After the end of the queue leaves the queue deque = " + Arrays.toString(deque.toArray()));
        int popFirst = deque.popFirst();
        System.out.println("The first element of the team = " + popFirst + "，After the team leader leaves the team deque = " + Arrays.toString(deque.toArray()));


        int size = deque.size();
        System.out.println("Bidirectional queue length size = " + size);


        boolean isEmpty = deque.isEmpty();
        System.out.println("Is the deque queue empty? = " + isEmpty);
    }

}
