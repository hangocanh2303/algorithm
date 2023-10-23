package com.example.algorithm.my_hello_algo.heap;


import java.util.ArrayList;
import java.util.List;

class PracticeMyHeap {
    private List<Integer> maxHeap;

    public PracticeMyHeap(List<Integer> nums) {
        maxHeap = new ArrayList<>(nums);
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
}
public class practice_my_heap {
}
