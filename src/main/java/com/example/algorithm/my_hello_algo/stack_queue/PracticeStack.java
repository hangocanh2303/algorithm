package com.example.algorithm.my_hello_algo.stack_queue;

import java.util.Stack;

public class PracticeStack {

    public static void main(String [] args){

        Stack<Integer> stack = new Stack<>();
        /* Push elements onto the stack */
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(4);
        System.out.println("stack = " + stack);

        int peek = stack.peek();
        System.out.println("Top element of stack peek = " + peek);

        /*Pop the element from the stack */
        int pop = stack.pop();
        System.out.println("Pop element pop = " + pop + "，After popping stack = " + stack);

        /* Get the length of the stack */
        int size = stack.size();
        System.out.println("The length of the stack size = " + size);

        /* Determine whether it is empty */
        boolean isEmpty = stack.isEmpty();
        System.out.println("Whether the stack is empty = " + isEmpty);
    }
}
