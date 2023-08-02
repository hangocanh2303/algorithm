package com.example.algorithm;

import java.util.Arrays;

public class Recurrence {
    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(fibonacci(i));
//        }
//        System.out.println(sum(4));

        int[] arr = new int[]{ 9, 7, 2, 10, 6, 4, 5, 8, 3, 1};

        System.out.println("Result: " + binarySearch(arr, 0, arr.length - 1, 1));
        System.out.println("Result: " + Arrays.toString(selectionSort(arr)));

    }

    private static int fibonacci(int n){
        if (n <= 1) {
            return n;
        }else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    private static int sum(int n) {
        int sum = 0;
        if (n <= 1) return n;
        else {
            sum = n + sum(n -1);
        }
        return sum;
    }

    private static int gdc(int a, int b){
        return (b==0 ? a : gdc(b, a % b));
    }

//    private static int[] insertionSort(int[] arr, int k) {
//        int n = arr.length;
//        if (k == 0 || k == 1)
//            return arr;
//        for (int i = 1; i < k && k < n; i++) {
//            int j = i;
//            while(j > 0 && arr[j] < arr[j - 1]) {
//                int temp = 0;
//                temp = arr[j];
//                arr[j] = arr[j - 1];
//                arr[j - 1] = temp;
//                j = j - 1;
//            }
//        }
//        insertionSort(arr, k + 1);
//        return arr;
//    }

    private static int[] insertionSort(int[] arr, int k) {
        int n = arr.length;
        while (k < n) {
            for (int i = k ; i > 0; i--) {
                if (arr[i] < arr[i - 1]) {
                    int temp = 0;
                    temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                }
            }
            k = k + 1;
            insertionSort(arr, k);
        }
        return arr;
    }

   public static int[] recursiveInsertionSort(int[] arr, int n){
        if (n <= 1) {
            return arr;
        }
        recursiveInsertionSort(arr, n - 1);
        int val = arr[n - 1];
        int pos = n - 2;
        while (pos >= 0 && arr[pos] > val) {
            arr[pos + 1] = arr[pos];
            pos = pos - 1;
        }
        arr[pos + 1] = val;
        return arr;
   }

   public static int[] selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            // search in array from i to n - 1 -> min value -> place min value to
            int min_index = i;
            int j = i + 1;
            while (j < n) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
                j++;
            }
            // swap
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }
        return  arr;
   }


    private static int binarySearch(int[] arr, int l, int r, int x) {
//        if (right >= 1 && arr.length - 1 >= 1) {
//            int mid = (left + right) / 2;
//            if (arr[mid] == value) {
//                return mid;
//            } else if (arr[mid] < value) {
//                binarySearch(arr, mid + 1, right, value);
//            }else {
//                binarySearch(arr, left, mid -1, value);
//            }
//        }
//        return -1;

        // Restrict the boundary of right index
        // and the left index to prevent
        // overflow of indices
        if (r >= l && l <= arr.length - 1) {

            int mid = l + (r - l) / 2;

            // If the element is present
            // at the middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then it can
            // only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present in
        // array
        return -1;
    }
}
