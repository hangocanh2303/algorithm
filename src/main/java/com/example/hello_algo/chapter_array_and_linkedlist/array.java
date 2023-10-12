/**
 * File: array.java
 * Created Time: 2022-11-25
 * Author: Krahets (krahets@163.com)
 */

package com.example.hello_algo.chapter_array_and_linkedlist;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class array {
    /* Randomly access elements */
    static int randomAccess(int[] nums) {
        // Randomly select a number from the interval [0, nums.length)
        int randomIndex = ThreadLocalRandom.current().nextInt(0, nums.length);
        // Get and return a random element
        int randomNum = nums[randomIndex];
        return randomNum;
    }

    /* Extend array length */
    static int[] extend(int[] nums, int enlarge) {
        // Initialize an array with extended length
        int[] res = new int[nums.length + enlarge];
        // Copy all elements in the original array to the new array
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }
        // Returns the expanded new array
        return res;
    }

    /* Insert element num at index of the array */
    static void insert(int[] nums, int num, int index) {
        // Move index and all elements after its one position backward
        for (int i = nums.length - 1; i > index; i--) {
            nums[i] = nums[i - 1];
        }
        // Assign num to the element at index
        nums[index] = num;
    }

    /* Delete the element at index index */
    static void remove(int[] nums, int index) {
        //Move all elements after index  forward one position
        for (int i = index; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }

    /* Traverse the array */
    static void traverse(int[] nums) {
        int count = 0;
        // Iterate through the array by index
        for (int i = 0; i < nums.length; i++) {
            count++;
        }
        // directly traverse the array
        for (int num : nums) {
            count++;
        }
    }

    /* Find the specified element in the array */
    static int find(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
        }
        return -1;
    }

    /* Driver Code */
    public static void main(String[] args) {
        /* Initialize array */
        int[] arr = new int[5];
        System.out.println("array arr = " + Arrays.toString(arr));
        int[] nums = { 1, 3, 2, 5, 4 };
        System.out.println("array nums = " + Arrays.toString(nums));

        /* Random access */
        int randomNum = randomAccess(nums);
        System.out.println("Get random elements in nums " + randomNum);

        /* length extension */
        nums = extend(nums, 3);
        System.out.println("Extending the array length to 8 gives nums = " + Arrays.toString(nums));

        /* Insert element */
        insert(nums, 6, 3);
        System.out.println("Inserting the number 6 at index 3 gives us nums = " + Arrays.toString(nums));

        /* Delete element */
        remove(nums, 2);
        System.out.println("Delete the element at index 2 and get nums = " + Arrays.toString(nums));

        /* Traverse the array */
        traverse(nums);

        /* Find element */
        int index = find(nums, 3);
        System.out.println("Find element 3 in nums, get index =" + index);
    }
}
