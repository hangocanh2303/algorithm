package com.example.algorithm;

public class Recurrence {
    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(fibonacci(i));
//        }
//        System.out.println(sum(4));

        int[] arr = new int[]{  1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Result: " + binarySearch(arr, 0, arr.length - 1, 1));

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
