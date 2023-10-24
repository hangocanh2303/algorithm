/**
 * File: top_k.java
 * Created Time: 2023-06-12
 * Author: Krahets (krahets@163.com)
 */

package com.example.hello_algo.chapter_heap;

import com.example.hello_algo.utils.PrintUtil;

import java.util.*;

public class top_k {
    /* 基于堆查找数组中最大的 k 个元素 */
    static Queue<Integer> topKHeap(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<Integer>();
        // 将数组的前 k 个元素入堆
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        // Starting from the k+1 th element, keep the length of the heap at k
        for (int i = k; i < nums.length; i++) {
            // If the current element is larger than the top element of the heap, remove the top element from the heap and put the current element into the heap.
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
        System.out.println("最大的 " + k + " 个元素为");
        PrintUtil.printHeap(res);
    }
}
