package com.example.algorithm.my_hello_algo.heap;

import com.example.hello_algo.utils.PrintUtil;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class practice_heap {
    public static void testPush(Queue<Integer> heap, int val) {
        heap.offer(val); // put elements into heap
        System.out.format("\nAfter element %d is put into the heap\n", val);
        PrintUtil.printHeap(heap);
    }

    public static void testPop(Queue<Integer> heap) {
        int val = heap.poll(); //The top element of the heap is removed from the heap
        System.out.format("\nAfter the top element %d is removed from the heap\n", val);
        PrintUtil.printHeap(heap);
    }

    public static void main(String [] args){
        /* Initialize heap */
        //Initialize the small top heap
        Queue<Integer> minHeap = new PriorityQueue<>();
        // Initialize the big heap (just use lambda expression to modify Comparator)
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        System.out.println("\nThe following test sample is a large top stack");

        /* Put elements into the heap */
        testPush(maxHeap, 1);
        testPush(maxHeap, 3);
        testPush(maxHeap, 2);
        testPush(maxHeap, 5);
        testPush(maxHeap, 4);

        /* Get the top element of the heap */
        int peek = maxHeap.peek();
        System.out.format("\nThe top element of the heap is %d\n", peek);

        /* Remove the top element from the heap */
        testPop(maxHeap);
        testPop(maxHeap);
        testPop(maxHeap);
        testPop(maxHeap);
        testPop(maxHeap);

        /* Get the heap size */
        int size = maxHeap.size();
        System.out.format("\nThe number of heap elements is %d\n", size);

        /* Determine whether the heap is empty */
        boolean isEmpty = maxHeap.isEmpty();
        System.out.format("\nIs the heap empty? %b\n", isEmpty);

        /* Input list and build heap */
        // Time complexity is O(n), not O(nlogn)
        minHeap = new PriorityQueue<>(Arrays.asList(1, 3, 2, 5, 4));
        System.out.println("\nAfter inputting the list and creating a small top heap");
        PrintUtil.printHeap(minHeap);
    }
}
