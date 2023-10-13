package com.example.algorithm.my_hello_algo.stack_queue;


import com.example.algorithm.my_hello_algo.utils.PracticeListNode;

import java.util.Arrays;

class PracticeLinkedListStack {
    PracticeListNode stackPeek;

    private int stackSize = 0;

    public PracticeLinkedListStack() {
        stackPeek = null;
    }

    public int size() {
        return stackSize;
    }
    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(int value){
        PracticeListNode node = new PracticeListNode(value);
        node.next = stackPeek;
        stackPeek = node;
        stackSize++;
    }
    public int pop() {
        int num = peek();
        stackPeek = stackPeek.next;
        stackSize--;
        return num;
    }
    public int peek() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return stackPeek.val;
    }

    public int[] toArray() {
        int[] arr = new int[size()];
        PracticeListNode node = stackPeek;
        for (int i = arr.length - 1; i >= 0; i --) {
            arr[i] = node.val;
            node = node.next;
        }
        return arr;
    }

}
public class practice_linklist_stack {
    public static void main(String[] args) {
        /* Initialization stack */
        PracticeLinkedListStack stack = new PracticeLinkedListStack();

        /* Push elements onto the stack */
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(4);
        System.out.println("stack = " + Arrays.toString(stack.toArray()));

        /* Access the top element of the stack */
        int peek = stack.peek();
        System.out.println("Top element of stack peek = " + peek);

        /*Pop the element from the stack */
        int pop = stack.pop();
        System.out.println("Pop element pop = " + pop + "，After popping stack = " + Arrays.toString(stack.toArray()));

        /* Get the length of the stack */
        int size = stack.size();
        System.out.println("stack length size = " + size);

        /* Determine whether it is empty */
        boolean isEmpty = stack.isEmpty();
        System.out.println("Is the stack empty? = " + isEmpty);
    }
}
