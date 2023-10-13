package com.example.algorithm.my_hello_algo.array_linklist;


/* Simple implementation of list class */



import java.util.Arrays;

class PracticeMyList {
    private int[] arr; // Array (storage list elements)

    private int capacity = 10; // list capacity
    private int size = 0; // List length (i.e. current number of elements)

    private static final int extendRatio = 2; // The multiple of each list expansion


    public PracticeMyList() {
        arr = new int[capacity];
    }

    public int size() {
        return size;
    }
    public int capacity(){
        return capacity;
    }

    public void set(int index, int num) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds");
        arr[index] = num;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds");
        return arr[index];
    }

    public void add(int num) {
       if (size == capacity())
           extendCapacity();
       arr[size] = num;
       size++;
    }

    public void insert(int index, int num) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds");
        if (size == capacity())
            extendCapacity();
        //Move index and subsequent elements backward one position
        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index] = num;
        size ++;
    }

    public int remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds");
        int num = arr[index];
        for (int i = index; i < size - 1; i ++){
            arr[i] = arr[i + 1];
        }
        size--;
        return num;
    }

    public void extendCapacity() {
        arr = Arrays.copyOf(arr, capacity() * extendRatio);
        capacity = arr.length;
    }

    public int[] toArray() {
        int size = size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++ ){
            arr[i] = get(i);
        }
        return arr;
    }


}
public class practice_my_list {
    public static void main(String[] args) {
        /* Initialization list */
        PracticeMyList nums = new PracticeMyList();

        /* Add elements at the end */

        nums.add(1);
        nums.add(3);
        nums.add(2);
        nums.add(5);
        nums.add(4);
        System.out.println("list nums = " + Arrays.toString(nums.toArray()) +
                " ，Capacity = " + nums.capacity() + " ，length = " + nums.size());

        /* Insert element in the middle */
        nums.insert(3, 6);
        System.out.println("Inserting the number 6 at index 3 gives us nums = " + Arrays.toString(nums.toArray()));

        /* Delete element */
        nums.remove(3);
        System.out.println("Delete the element at index 3 and get nums = " + Arrays.toString(nums.toArray()));

        /* Access elements */
        int num = nums.get(1);
        System.out.println("Accessing the element at index 1 gives num = " + num);

        /* Update element */
        nums.set(1, 0);
        System.out.println("Update the element at index 1 to 0 , giving nums = " + Arrays.toString(nums.toArray()));

        /* Test expansion mechanism */
        for (int i = 0; i < 10; i++) {
            // When i = 5, the list length will exceed the list capacity, and the expansion mechanism will be triggered at this time
            nums.add(i);
        }
        System.out.println("Expanded list nums = " + Arrays.toString(nums.toArray()) +
                " ，capacity = " + nums.capacity() + " ，length = " + nums.size());
    }


}
