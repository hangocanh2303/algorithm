package com.example.algorithm.my_hello_algo.hashing;

class PracticeHashMapOpenAddressing {
    private int size;
    private int capacity = 4;
    private final double loadThres = 2.0 / 3.0;
    private final int extendRatio = 2;
    private Pair[] buckets;

    private final Pair TOMBSTONE = new Pair(-1, "-1");

    public PracticeHashMapOpenAddressing() {
        size = 0;
        buckets = new Pair[capacity];
    }

    private int hashFunc(int key){
        return key % capacity;
    }

    private double loadFactor() {
        return (double) size / capacity;
    }

    /* Search the bucket index corresponding to key */
    private int findBucket(int key){
        int index = hashFunc(key);
        int firstTombstone = -1;
        //Linear detection, jump out when encountering an empty bucket
        while (buckets[index] != null) {
            // If key is encountered, return the corresponding bucket index
            if (buckets[index].key == key) {
            // If a deletion mark has been encountered before, move the key-value pair to this index
                if (firstTombstone != -1) {
                    buckets[firstTombstone] = buckets[index];
                    buckets[index] = TOMBSTONE;
                    return firstTombstone; //Return the moved bucket index
                }
                return index; // Return bucket index
            }
            //Record the first delete mark encountered
            if (firstTombstone == -1 && buckets[index] == TOMBSTONE){
                firstTombstone = index;
            }
            // Calculate the bucket index and return to the head after crossing the tail
            index = (index + 1) % capacity;
        }
        // If key does not exist, return the index of the added point
        return firstTombstone == -1 ? index : firstTombstone;
    }

    public String get(int key){
        int index = hashFunc(key);
        if (buckets[index] != null && buckets[index] != TOMBSTONE){
            return buckets[index].val;
        }
        return null;
    }

    public void put(int key, String val){
        if (loadFactor() > loadThres){
            extend();
        }
        int index = findBucket(key);
        if (buckets[index] != null && buckets[index] != TOMBSTONE){
            buckets[index].val = val;
            return;
        }
        buckets[index] = new Pair(key, val);
        size ++;
    }

    private void extend() {
        Pair[] bucketsTmp = buckets;
        capacity *= extendRatio;
        buckets = new Pair[capacity];
        size = 0;
        for (Pair pair: bucketsTmp) {
            if (pair != null && pair != TOMBSTONE){
                put(pair.key, pair.val);
            }
        }
    }

    public void remove(int key){
        int index = findBucket(key);
        if (buckets[index] != null && buckets[index] != TOMBSTONE){
            buckets[index] = TOMBSTONE;
            size--;
        }
    }

    public void print() {
        for (Pair pair : buckets) {
            if (pair == null) {
                System.out.println("null");
            } else if (pair == TOMBSTONE) {
                System.out.println("TOMBSTONE");
            } else {
                System.out.println(pair.key + " -> " + pair.val);
            }
        }
    }
}


public class practice_hash_map_open_addressing {
}
