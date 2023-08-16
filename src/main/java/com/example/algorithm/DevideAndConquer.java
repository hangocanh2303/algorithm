package com.example.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class DevideAndConquer {

    public static void main(String[] args) {
        int[] arr = new int[]{  1, 3, 2, 4, 6, 5, 7, 9, 8, 10};
//        System.out.println("Binary search: " + binarySearch(arr, 0, arr.length - 1, 10));
//        System.out.println("Exp: " + exp(2, 3));
//        System.out.println("MinMax: " + minMax(arr, 0, 9));
//
//        int[] arr1 = new int[]{  1, 2, 3, 4};
//        int[] arr2 = new int[]{  5, 6, 7, 9, 8, 10};
//        System.out.println("Merge: " + Arrays.toString(merge(arr1, arr2)));
//        System.out.println("MergeSort: " + Arrays.toString(mergeSort(arr)));
//        System.out.println("Merge2: " + Arrays.toString(merge2(arr, 0, 4, 9)));
//        System.out.println("MergeSort2: " + Arrays.toString(mergeSort2(arr, 0, 9)));
//        mergeSort3(arr, 0, 9);
//        System.out.println("MergeSort3: " + Arrays.toString(arr));
        quickSort(arr, 0, 9);
        System.out.println("Partition: " + Arrays.toString(arr));


    }

    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // This function takes last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller to left
    // of pivot and all greater elements to right of pivot
    static int partition(int[] arr, int low, int high)
    {
        // Choosing the pivot
        int pivot = arr[high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller than the pivot
            if (arr[j] < pivot) {

                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    public static int[] mergeSort(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return arr;
        else {
            int k = n / 2;
            int[] arr1 = mergeSort(Arrays.copyOfRange(arr, 0, k));
            int[] arr2 = mergeSort(Arrays.copyOfRange(arr, k , n));
            return merge(arr1, arr2);
        }

    }

    public static int[] mergeSort2(int[] arr, int left, int right) {
        if (left < right) {
           int mid = (left + right) / 2;
           mergeSort2(arr, left, mid);
           mergeSort2(arr, mid + 1, right);
           return merge2(arr, left, mid, right);
        }
        return null;
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] result = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
           if (arr1[i] < arr2[j]) {
               result[k] = arr1[i];
               i = i + 1;
           }else {
               result[k] = arr2[j];
               j = j + 1;
           }
            k = k + 1;
        }
        if (i == m) {
            while (j < n) {
                result[k] = arr2[j];
                j = j + 1;
                k = k + 1;
            }
        } else {
            while (i < m) {
                result[k] = arr1[j];
                i = i + 1;
                k = k + 1;
            }
        }
        return result;
    }

    public static int[] merge2(int[] arr, int l, int m, int r) {
        // Merges two sub arrays of arr[].
        // First subarray is arr[l -> m]
        // Second subarray is arr[m+1 -> r]
        int i = l;
        int j = m + 1;
        int k = l;

        int[] result = new int[arr.length];

        while (i < m && j < r) {
            if (arr[i] < arr[j]) {
                result[k] = arr[i];
                i++;
            }else {
                result[k] = arr[j];
                j++;
            }
            k++;
        }

        if (i == m) {
            while (j < r) {
                result[k] = arr[j];
                j++;
                k++;
            }
        }else{
            while (i < m) {
                result[k] = arr[i];
                i++;
                k++;
            }
        }
        return result;
    }


    static void mergeSort3(int arr[], int l, int r)
    {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort3(arr, l, m);
            mergeSort3(arr, m + 1, r);

            // Merge the sorted halves
            merge3(arr, l, m, r);
        }
    }

    static void merge3(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static int binarySearch(int[] arr, int left , int right , int searchValue) {
      if (left <= right) {
          int mid = (left + right) / 2;
          if (arr[mid] == searchValue)
              return mid;
          else if (arr[mid] < searchValue)
              return binarySearch(arr, mid + 1, right, searchValue);
          else
              return binarySearch(arr, left , mid - 1, searchValue);
      }else
        return -1;
    }

    public static int exp(int a, int n) {
        if (n == 0)
            return 1;
        else{
            int b = exp(a, n/2);
            if (n % 2 == 0)
                return b * b;
            else
                return a * b * b;
        }
    }

    public static ArrayList<Integer> minMax(int[] arr, int left, int right) {
        ArrayList<Integer> result = new ArrayList<>();
        int min = 0;
        int max = 0;
        if (left == right){
            min = arr[left];
            max = arr[left];
        }else if (left == right - 1) {
            if (arr[left] < arr[right]) {
                min = arr[left];
                max = arr[right];
            }else {
                min = arr[right];
                max = arr[left];
            }
        }else {
            int mid = (left + right) / 2;
            ArrayList<Integer> minMax1 = minMax(arr, left, mid);
            ArrayList<Integer> minMax2 = minMax(arr, mid + 1, right);
            int min1 = minMax1.get(0);
            int max1 = minMax1.get(1);
            int min2 = minMax2.get(0);
            int max2 = minMax2.get(1);

            min = Math.min(min1, min2);
            max = Math.max(max1, max2);
            System.out.println(min + "|" + max);
        }
        result.add(0, min);
        result.add(1, max);
        return result;
    }
}
