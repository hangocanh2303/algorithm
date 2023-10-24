package com.example.algorithm.my_hello_algo.heap;


import com.example.hello_algo.utils.PrintUtil;

import java.util.*;

class PracticeMaxHeap {
    private List<Integer> maxHeap;

    public PracticeMaxHeap(List<Integer> nums) {
        // Add the list elements to the heap unchanged
        maxHeap = new ArrayList<>(nums);
        // Heap all nodes except leaf nodes
        for (int i = parent(size() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private void swap(int i, int j){
        int tmp = maxHeap.get(i);
        maxHeap.set(i, maxHeap.get(j));
        maxHeap.set(j, tmp);
    }

    public int size() {
        return maxHeap.size();
    }

    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    public int peek() {
        return maxHeap.get(0);
    }

    private void siftUp(int i){
        while (true){
            int p = parent(i);
            if (p < 0 || maxHeap.get(i) <= maxHeap.get(p))
                break;
            swap(i, p);
            i = p;
        }
    }

    public void push(int val) {
        maxHeap.add(val);
        siftUp(size() - 1);
    }

    public int pop() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        swap(0, size() - 1);
        int val = maxHeap.remove(size() - 1);
        siftDown(0);
        return val;
    }

    /* Starting from node i, stack from top to bottom */
    private void siftDown(int i) {
        while (true) {
            // Determine the node with the largest value among nodes i, l, r, recorded as max
            int l = left(i), r = right(i), max = i;
            if (l < size() && maxHeap.get(l) > maxHeap.get(max))
                max = l;
            if (r < size() && maxHeap.get(r) > maxHeap.get(max))
                max = r;
            // If node i is the largest or index l, r is out of bounds, there is no need to continue heaping and jump out
            if (max == i)
                break;
            //Exchange two nodes
            swap(i, max);
            // Loop down the heap
            i = max;
        }
    }


    public void print() {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> { return b - a; });
        queue.addAll(maxHeap);
        PrintUtil.printHeap(queue);
    }

}
public class practice_my_heap {
    public static void main(String[] args) {
        /* Initialize the big heap */
        PracticeMaxHeap maxHeap = new PracticeMaxHeap(Arrays.asList(9, 8, 6, 6, 7, 5, 2, 1, 4, 3, 6, 2));
        System.out.println("\nAfter inputting the list and building the heap");
        maxHeap.print();

        /* Get the top element of the heap */
        int peek = maxHeap.peek();
        System.out.format("\nThe top element of the heap is %d\n", peek);

        /* Put elements into the heap */
        int val = 7;
        maxHeap.push(val);
        System.out.format("\nAfter element %d is put into the heap\n", val);
        maxHeap.print();

        /* Remove the top element from the heap */
        peek = maxHeap.pop();
        System.out.format("\nAfter the top element %d is removed from the heap\n", peek);
        maxHeap.print();

        /* Get the heap size */
        int size = maxHeap.size();
        System.out.format("\nThe number of heap elements is %d\n", size);

        /* Determine whether the heap is empty */
        boolean isEmpty = maxHeap.isEmpty();
        System.out.format("\nIs the heap empty %b\n", isEmpty);
    }
}
