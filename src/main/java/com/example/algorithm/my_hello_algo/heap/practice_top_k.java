package com.example.algorithm.my_hello_algo.heap;

import com.example.hello_algo.utils.PrintUtil;

import java.util.PriorityQueue;
import java.util.Queue;

public class practice_top_k {

    /* Find the largest k elements in the array based on the heap */
    static Queue<Integer> topKHeap(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>();
        //Queue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        // Put the first k elements of the array into the heap
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > heap.peek()) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        return heap;
    }


    public static void main(String[] args) {
        int[] nums = { 1, 7, 6, 3, 2 };
        int k = 3;

        Queue<Integer> res = topKHeap(nums, k);
        System.out.println("The largest " + k + " elements are");
        PrintUtil.printHeap(res);
    }
}
