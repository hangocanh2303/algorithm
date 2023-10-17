package com.example.algorithm.my_hello_algo.stack_queue;


import com.example.algorithm.my_hello_algo.utils.PracticeListNode;

import java.util.Arrays;

class PracticeLinkedListQueue{
    private PracticeListNode front, rear;
    private int queueSize = 0;

    public PracticeLinkedListQueue() {
        front = null;
        rear = null;
    }

    public int size() {
        return queueSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int peek() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return front.val;
    }

    public int pop() {
        int num = peek();
        front = front.next;
        queueSize--;
        return num;
    }

    public void push(int num) {
       PracticeListNode node = new PracticeListNode(num);
       if (front == null) {
           front = node;
       }else {
           rear.next = node;
       }
        rear = node;
        queueSize++;
    }

    public int[] toArray() {
        PracticeListNode node = front;
        int[] res = new int[size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = node.val;
            node = node.next;
        }
        return res;
    }


}
public class practice_linklist_queue {
    public static void main(String[] args) {

        PracticeLinkedListQueue queue = new PracticeLinkedListQueue();

        queue.push(1);
        queue.push(3);
        queue.push(2);
        queue.push(5);
        queue.push(4);
        System.out.println("queue = " + Arrays.toString(queue.toArray()));

        int peek = queue.peek();
        System.out.println("peek = " + peek);


        int pop = queue.pop();
        System.out.println("pop = " + pop + "，queue = " + Arrays.toString(queue.toArray()));


        int size = queue.size();
        System.out.println("size = " + size);

        boolean isEmpty = queue.isEmpty();
        System.out.println("Is the queue empty? = " + isEmpty);
    }
}
