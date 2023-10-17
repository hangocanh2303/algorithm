package com.example.algorithm.my_hello_algo.stack_queue;


import com.example.algorithm.my_hello_algo.utils.PracticeListNode;

import java.util.Arrays;

class PracticeBidirectionalListNode {
    PracticeBidirectionalListNode next;
    PracticeBidirectionalListNode pre;

    int val;

    PracticeBidirectionalListNode(int val) {
        this.val = val;
        next = pre = null;
    }
}

class PracticeLinkListDeque {
    private PracticeBidirectionalListNode front, rear;

    private int queueSize = 0;

    PracticeLinkListDeque(){
        front = rear = null;
    }

    public int size() {
        return queueSize;
    }
    public boolean isEmpty() {
        return size() == 0;
    }

    public int peekFirst() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return front.val;
    }

    public int peekLast() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return rear.val;
    }

    private int pop(boolean isFront) {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        int val;
        if (isFront){
            val = front.val;
            PracticeBidirectionalListNode frontNext = front.next;
            if (frontNext != null) {
                frontNext.pre = null;
                front.next = null;
            }
            front = frontNext;
        }else {
            val = rear.val;
            PracticeBidirectionalListNode rearPrev = rear.pre;
            if (rearPrev != null) {
                rearPrev.next = null;
                rear.pre = null;
            }
            rear = rearPrev;
        }
        queueSize --;
        return val;
    }

    public int popFirst() {
       return pop(true);
    }
    public int popLast() {
        return pop(false);
    }

    public void push(int num, boolean isFront){
        PracticeBidirectionalListNode node = new PracticeBidirectionalListNode(num);
        if (isEmpty()){
            front = rear = node;
        }else if (isFront){
            front.pre = node;
            node.next = front;
            front = node;
        }else {
            rear.next = node;
            node.pre = rear;
            rear = node;
        }
        queueSize++;
    }

    public void pushFirst(int num) {
        push(num, true);
    }
    public void pushLast(int num) {
        push(num, false);
    }

    public int[] toArray() {
        PracticeBidirectionalListNode node = front;
        int[] res = new int[size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = node.val;
            node = node.next;
        }
        return res;
    }

}
public class practice_linklist_deque {
    public static void main(String[] args) {

        PracticeLinkListDeque deque = new PracticeLinkListDeque();

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
        System.out.println("size = " + size);

        boolean isEmpty = deque.isEmpty();
        System.out.println("isEmpty = " + isEmpty);
    }
}
