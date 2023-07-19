package com.example.algorithm;

import java.util.Arrays;

public class SortAlgorithm {

    public static void main(String[] args) {
        int[] arr = new int[]{  1, 3, 2, 4, 6, 5, 7, 9, 8, 10};
        System.out.println("Result: " + Arrays.toString(defaultSort(arr)));
        System.out.println("Result: " + Arrays.toString(insertionSortMethod1(arr)));
        System.out.println("Result: " + Arrays.toString(insertionSortMethod2(arr)));
        System.out.println("Result: " + Arrays.toString(selectionSort(arr)));
        System.out.println("Result: " + Arrays.toString(bubbleSort(arr)));

    }

    public static int[] defaultSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n ; i ++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
    public static int[] insertionSortMethod1(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                // swap value
                int temp = arr[j - 1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                // decrease j
                j = j - 1;
            }
        }
        return arr;
    }

    public static int[] insertionSortMethod2(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < n; j ++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            if (min_index != i) {
                int temp = arr[i];
                arr[i] = arr[min_index];
                arr[min_index] = temp;
            }
        }
        return arr;
    }

    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

}
