package com.example.algorithm;

import java.util.Arrays;

public class ExponentialAlgorithm {
    public static void main(String[] args) {
        System.out.println("Result: " + Exp(2, 2));
    }
    public static int Exp(int a, int n) {
        int exp = 1;
        for (int i = 0 ; i < n ; i++) {
            exp = exp * a;
        }
        return exp;
    }
}
