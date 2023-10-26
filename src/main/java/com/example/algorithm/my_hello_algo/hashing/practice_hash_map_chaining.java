package com.example.algorithm.my_hello_algo.hashing;


import java.util.ArrayList;
import java.util.List;

class PracticeHashMapChaining {
    int size;
    int capacity;

    double loadThres;

    int extendRatio;

    List<List<Pair>> buckets;

    public PracticeHashMapChaining() {
        size = 0;
        capacity = 4;
        loadThres = 2.0 / 3.0;
        extendRatio = 2;

        buckets = new ArrayList<>(capacity);

        for (int i = 0; i < capacity; i++){
            buckets.add(new ArrayList<>());
        }
    }

    private int hashFunc(int key) {
        return key % capacity;
    }

    double loadFactor() {
        return (double) size / capacity;
    }

    String get(int key){
        int index = hashFunc(key);
        List<Pair> bucket = buckets.get(index);
        for (Pair pair: bucket) {
            if (pair.key == key)
                return pair.val;
        }
        return null;
    }

    void put(int key, String val) {
        if (loadFactor() > loadThres) {
            extend();
        }
        int index = hashFunc(key);
        List<Pair> bucket = buckets.get(index);
        for (Pair pair: bucket) {
            if (pair.key == key) {
                pair.val = val;
                return;
            }
        }
        Pair pair = new Pair(key, val);
        bucket.add(pair);
        size++;
    }

    void remove(int key) {
        int index = hashFunc(key);
        List<Pair> bucket = buckets.get(index);
        for (Pair pair: bucket) {
            if (pair.key == key) {
                bucket.remove(pair);
                size--;
                break;
            }
        }
    }

    void extend() {
        List<List<Pair>> bucketsTmp = buckets;

        capacity *= extendRatio;

        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++){
            buckets.add(new ArrayList<>());
        }
        size = 0;

        for (List<Pair> bucket: bucketsTmp) {
            for (Pair pair: bucket) {
                put(pair.key, pair.val);
            }
        }
    }

    void print() {
        for (List<Pair> bucket : buckets) {
            List<String> res = new ArrayList<>();
            for (Pair pair : bucket) {
                res.add(pair.key + " -> " + pair.val);
            }
            System.out.println(res);
        }
    }

}
public class practice_hash_map_chaining {
    public static void main(String[] args) {
        /* Initialize hash table */
        PracticeHashMapChaining map = new PracticeHashMapChaining();

        /* Add operation */
        //Add key-value pair (key, value) to the hash table
        map.put(12836, "a");
        map.put(15937, "b");
        map.put(16750, "c");
        map.put(13276, "d");
        map.put(10583, "e");
        System.out.println("\nAfter the addition is completed, the hash table is\nKey -> Value");
        map.print();

        /* Query operation */
        // Enter the key  into the hash table and get the value
        String name = map.get(13276);
        System.out.println("\nEnter student number 13276 and find the name." + name);

        /* Delete operation */
        // Delete the key-value pair (key, value) in the hash table
        map.remove(12836);
        System.out.println("\nAfter deleting 12836, the hash table is\nKey -> Value");
        map.print();
    }
}
