package com.example.algorithm;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{  1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Result: " + binarySearch(arr, 8));

    }

    public static int binarySearch(int[] arr, int value) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == value) {
                return mid;
            }else if (arr[mid] < value) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
