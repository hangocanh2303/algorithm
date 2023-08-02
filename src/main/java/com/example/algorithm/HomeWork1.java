package com.example.algorithm;

import java.util.ArrayList;
import java.util.List;

public class HomeWork1 {
    public static void main(String[] args) {
        int[] arr = new int[]{ 9, 7, 2, 10, 6, 4, 5, 8, 3, 13, 2};
        System.out.println("Result: " + linearSearch(arr, 1));
    }

    /**
     * Linear search algorithm
     * @param arr array of value
     * @param value value to search
     * @return index of value in array
     */
    public static List<Integer> linearSearch(int[] arr, int value) {
        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n ; i++)  {
            if (arr[i] == value)
                result.add(i);
        }
        return result;
    }
}
