package com.example.algorithm;

import java.util.Arrays;

public class StringMatching {
    public static void main(String[] args) {
        System.out.println("Result: " + stringMatching("ha ngoc anh", "n"));

    }

    public static int stringMatching(String text, String key){
        int n = text.length();
        int m = key.length();

        for (int k = 0; k <= n-m; k++) {
            if (key.equals(text.substring(k, k + m))) {
                return k;
            }
        }
        return -1;
    }
}
