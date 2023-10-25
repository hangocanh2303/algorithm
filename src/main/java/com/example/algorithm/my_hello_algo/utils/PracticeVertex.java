package com.example.algorithm.my_hello_algo.utils;


import java.util.ArrayList;
import java.util.List;

public class PracticeVertex {
    public int val;

    public PracticeVertex(int val) {
        this.val = val;
    }

    public static PracticeVertex[] valsToVets(int[] vals) {
        PracticeVertex[] vets = new PracticeVertex[vals.length];
        for (int i = 0; i < vals.length; i++) {
            vets[i] = new PracticeVertex(vals[i]);
        }
        return vets;
    }

    public static List<Integer> vetsToVals(List<PracticeVertex> vets) {
        List<Integer> vals = new ArrayList<>();
        for (PracticeVertex vet : vets) {
            vals.add(vet.val);
        }
        return vals;
    }
}
