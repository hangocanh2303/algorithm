package com.example.algorithm.my_hello_algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PracticeList {

    public static void main(String[] args) {
        /* Initialization list */
        // Note that the element type of the array is the wrapper class Integer[] of int[]
        Integer[] numbers = new Integer[] { 1, 3, 2, 5, 4 };
        List<Integer> nums = new ArrayList<>(Arrays.asList(numbers));
        System.out.println("list nums = " + nums);

        /* Access elements */
        int x = nums.get(1);
        System.out.println("Accessing the element at index 1 gives x = " + x);

        /* Update element */
        nums.set(1, 0);
        System.out.println("Update the element at index 1 to 0 , giving nums = " + nums);

        /* clear the list */
        nums.clear();
        System.out.println("After clearing the list nums = " + nums);

        /* Add elements at the end */
        nums.add(1);
        nums.add(3);
        nums.add(2);
        nums.add(5);
        nums.add(4);
        System.out.println("After adding elements nums = " + nums);

        /* Insert element in the middle */
        nums.add(3, 6);
        System.out.println("Inserting the number 6 at index 3 gives us nums = " + nums);

        /* Delete element */
        nums.remove(3);
        System.out.println("Delete the element at index 3 and get nums = " + nums);

        /* Traverse the list by index */
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            count++;
        }

        /* Directly traverse the list elements */
        count = 0;
        for (int num : nums) {
            count++;
        }

        /* Splice two lists */
        List<Integer> nums1 = new ArrayList<>(Arrays.asList(new Integer[] { 6, 8, 7, 10, 9 }));
        nums.addAll(nums1);
        System.out.println("After concatenating the list nums1 to nums, we get nums = " + nums);

        /* Sort list */
        Collections.sort(nums);
        System.out.println("After sorting the list nums = " + nums);
    }
}
