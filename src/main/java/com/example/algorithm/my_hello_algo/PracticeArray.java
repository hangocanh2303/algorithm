package com.example.algorithm.my_hello_algo;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class PracticeArray {


    static int randomAccess(int[] nums) {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, nums.length);
        return nums[randomIndex];
    }

    static int[] extend(int[] nums, int extendRange) {
        int[] newArray = new int[nums.length + extendRange];
        for (int i = 0; i < nums.length; i++) {
            newArray[i] = nums[i];
        }
        return newArray;
    }

    static void insert(int[] nums, int value, int index){
        // shift value from index to the right
        for (int i = nums.length - 1 ; i > index; i--) {
            nums[i] = nums[i-1];
        }
        nums[index] = value;
    }

    static void remove(int[] nums, int indexRemove) {
        // shift value from index to the left
        for (int i = indexRemove; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }

    static void traverse(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count ++;
        }
        for (int num: nums) {
            count ++;
        }
    }

    static int find(int[] nums, int valueFind) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == valueFind)
                return i;
        }
        return -1;
    }
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
