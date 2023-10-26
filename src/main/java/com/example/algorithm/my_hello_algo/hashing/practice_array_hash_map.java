package com.example.algorithm.my_hello_algo.hashing;



import java.util.ArrayList;
import java.util.List;

class Pair {
    public int key;
    public String val;

    public Pair(int key, String val) {
        this.key = key;
        this.val = val;
    }
}

class PracticeArrayHashMap {
    private List<Pair> buckets;

    public PracticeArrayHashMap() {
        buckets = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            buckets.add(null);
        }
    }

    private int hashFunc(int key) {
        return key % 100;
    }

    public void put(int key, String val) {
        int index = hashFunc(key);
        buckets.set(index, new Pair(index, val));
    }

    public String get(int key){
        int index = hashFunc(key);
        Pair pair = buckets.get(index);
        if (pair == null)
            return null;
        return pair.val;
    }

    public void remove(int key){
        int index = hashFunc(key);
        buckets.set(index, null);
    }

    public List<Pair> pairSet() {
        List<Pair> pairs = new ArrayList<>();
        for (Pair pair: buckets) {
            if (pair != null)
                pairs.add(pair);
        }
        return pairs;
    }

    public List<Integer> keySet() {
        List<Integer> keySet = new ArrayList<>();
        for (Pair pair: buckets) {
            if (pair != null)
                keySet.add(pair.key);
        }
        return keySet;
    }

    public List<String> valueSet() {
        List<String> valueSet = new ArrayList<>();
        for (Pair pair: buckets) {
            if (pair != null)
                valueSet.add(pair.val);
        }
        return valueSet;
    }

    public void print() {
        for (Pair kv : pairSet()) {
            System.out.println(kv.key + " -> " + kv.val);
        }
    }

}
public class practice_array_hash_map {
    public static void main(String[] args) {

        PracticeArrayHashMap map = new PracticeArrayHashMap();


        map.put(12836, "a");
        map.put(15937, "b");
        map.put(16750, "c");
        map.put(13276, "d");
        map.put(10583, "e");
        System.out.println("\nAfter the addition is completed, the hash table is\nKey -> Value");
        map.print();

        /* Query operation */
        // Enter the key into the hash table and get the value
        String name = map.get(15937);
        System.out.println("\nEnter student number 15937 to find the name " + name);

        /* Delete operation */
        // Delete the key-value pair (key, value) in the hash table
        map.remove(10583);
        System.out.println("\nAfter deleting 10583, the hash table is\nKey -> Value");
        map.print();

        /* Traverse the hash table */
        System.out.println("\nTraverse key-value pairs Key->Value");
        for (Pair kv : map.pairSet()) {
            System.out.println(kv.key + " -> " + kv.val);
        }
        System.out.println("\nIterate over keys individually Key");
        for (int key : map.keySet()) {
            System.out.println(key);
        }
        System.out.println("\nIterate over values individually Value");
        for (String val : map.valueSet()) {
            System.out.println(val);
        }
    }
}
