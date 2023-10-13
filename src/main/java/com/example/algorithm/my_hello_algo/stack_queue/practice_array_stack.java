package com.example.algorithm.my_hello_algo.stack_queue;



import java.util.ArrayList;
import java.util.Arrays;

class PracticeArrayStack {
    private ArrayList<Integer> stack;

    public PracticeArrayStack() {
        stack = new ArrayList<>();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int peek() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return stack.get(size() - 1);
    }

    public void push(int value) {
        stack.add(value);
    }

    public int pop() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return stack.remove(size() - 1);
    }

    public Object[] toArray() {
        return stack.toArray();
    }

}
public class practice_array_stack {
    public static void main(String[] args) {
        /* Initialization stack */
        PracticeArrayStack stack = new PracticeArrayStack();

        /* Push elements onto the stack */

        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(4);

        System.out.println(" stack = " + Arrays.toString(stack.toArray()));

        /* Access the top element of the stack */
        int peek = stack.peek();
        System.out.println(" Top element of stack peek = " + peek);

        /*Pop the element from the stack */
        int pop = stack.pop();
        System.out.println(" Pop element pop = " + pop + "，After popping stack = " + Arrays.toString(stack.toArray()));

        /* Get the length of the stack */
        int size = stack.size();
        System.out.println("stack length size = " + size);

        /* Determine whether it is empty */
        boolean isEmpty = stack.isEmpty();
        System.out.println("Is the stack empty? = " + isEmpty);
    }
}
