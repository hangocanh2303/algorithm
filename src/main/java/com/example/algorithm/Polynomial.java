package com.example.algorithm;

import java.util.Arrays;

public class Polynomial {
    public static void main(String[] args) {
        int[] arr = new int[]{  1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = new int[]{  1, 2, 3};
//        System.out.println("Result 1: " + polynomial(arr, 2, 9));
//        System.out.println("Result 2: " + polynomial2(arr, 2, 9));
//        System.out.println("Result 3: " + polynomial3(arr, 2, 9));
//        System.out.println("Result 4: " + polynomial4(arr, 2, 9));
//        System.out.println("Horner 1: " + horner(arr, 2, 9));
        System.out.println("Horner 2: " + horner2(arr2, 1, 2));

    }

    public static int polynomial(int[] coefficient, int x, int n) {
        int result = 0;
        for (int i = 0; i <= n; i++) {
            result += coefficient[i] * exp(x, i);
        }
        return result;
    }

    public static int polynomial2(int[] coefficient, int x, int n) {
        if (n == 0)
            return coefficient[0];
        return coefficient[0] + x * polynomial2(Arrays.copyOfRange(coefficient, 1, n + 1), x, n - 1);
    }

    public static int polynomial3(int[] coefficient, int x, int n) {
        int result = 0;
        int p = 1;
        for (int i = 0; i <= n; i++) {
            result += coefficient[i] * p;
            p = p * x;
        }
        return result;
    }

    public static int polynomial4(int[] coefficient, int x, int n) {
        if (n == 0)
            return coefficient[0];
        else {
            return coefficient[0] + x * polynomial2(Arrays.copyOfRange(coefficient, 1, n + 1), x, n - 1);
        }
    }

    public static int horner(int[] coefficient, int x, int n) {
        int result = coefficient[n];
        for (int i = n - 1; i >= 0; i--) {
            result = result * x + coefficient[i];
        }
        return result;
    }
    public static int horner2(int[] coefficient, int x, int n) {
        if (n == 0) {
            return coefficient[0];
        }
        return coefficient[n] * x + horner2(coefficient, n - 1, x);
    }


    public static int exp(int a, int n) {
       if (n == 1)
           return a;
       if (n == 0)
           return 1;
       return a * exp(a, n -1);
    }
}
