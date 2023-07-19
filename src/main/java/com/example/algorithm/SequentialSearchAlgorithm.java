package com.example.algorithm;

public class SequentialSearchAlgorithm {

    public static void main(String[] args) {
        int[] arr = new int[]{ 9, 7, 2, 10, 6, 4, 5, 8, 3, 1};
        int[] arrJumpSearch = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Result: " + linearSearch(arr, 1));
        System.out.println("Result: " + sentinelSearch(arr, 1));
        System.out.println("Result: " + jumpSearch(arrJumpSearch, 9));
    }

    /**
     * Linear search algorithm
     * @param arr array of value
     * @param value value to search
     * @return index of value in array
     */
    public static int linearSearch(int[] arr, int value) {
        int n = arr.length;
        for (int i = 0; i < n ; i++)  {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    /**
     * Sentinel search algorithm
     * @param arr array of value
     * @param value value to search
     * @return index of value in array
     */
    public static int sentinelSearch(int[] arr, int value) {
      int n = arr.length;
      // save last
      int last = arr[n - 1];
      int i = 0;
      while (arr[i] != value) {
          i++;
      }
      arr[n-1] = last;
      if (i < n - 1 || arr[n-1] == value) {
          return i;
      }else {
          return -1;
      }

    }

    /**
     * Jump to search algorithm
     *
     * @param arr array of value
     * @param value value to search
     * @return index of value in array
     */
    public static int jumpSearch(int[] arr, int value) {
        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(n));
        int last = step - 1;
        while (last < n && value > arr[last]) {
            last += step;
        }
        for (int i = last - step + 1; i <= last && i < n; i++){
            if (arr[i] == value) {
                return i;
            }

        }
        return -1;
    }
}
