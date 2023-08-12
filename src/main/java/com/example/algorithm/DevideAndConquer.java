package com.example.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class DevideAndConquer {

    public static void main(String[] args) {
        int[] arr = new int[]{  1, 3, 2, 4, 6, 5, 7, 9, 8, 10};
        System.out.println("Binary search: " + binarySearch(arr, 0, arr.length - 1, 10));
        System.out.println("Exp: " + exp(2, 3));
        System.out.println("MinMax: " + minMax(arr, 0, 9));
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
