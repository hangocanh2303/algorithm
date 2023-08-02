package com.example.algorithm;

import java.util.Arrays;

public class Polynomial {
    public static void main(String[] args) {
        int[] arr = new int[]{  1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Result: " + polynomial(arr, 2, 9));
        System.out.println("Result: " + polynomial2(arr, 2, 9));
//        System.out.println("Result: " + exp(2, 3));
    }

    public static int polynomial(int[] coefficient, int x, int n) {
        int result = 0;
        for (int i = 0; i <= n; i++) {
            //System.out.println(coefficient[i] + "|" + exp(x, i));
            result += coefficient[i] * exp(x, i);
        }
        return result;
    }

    public static int polynomial2(int[] coefficient, int x, int n) {
        if (n == 0)
            return coefficient[0];
        return coefficient[0] + x * polynomial2(Arrays.copyOfRange(coefficient, 1, n + 1), x, n - 1);
    }

    public static int exp(int a, int n) {
       if (n == 1)
           return a;
       if (n == 0)
           return 1;
       return a * exp(a, n -1);
    }
}
