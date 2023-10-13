package com.example.algorithm.my_hello_algo.array_linklist;

import com.example.algorithm.my_hello_algo.utils.PracticeListNode;
import com.example.hello_algo.utils.ListNode;
import com.example.hello_algo.utils.PrintUtil;

public class PracticeLinkList {

    static void insert(PracticeListNode node0, PracticeListNode nodeInsert) {
        // get current node after node0
        PracticeListNode n1 = node0.next;

        // point next of node insert to n1
        nodeInsert.next = n1;

        // point next of node n0 to node insert
        node0.next = nodeInsert;
    }

    static void remove(PracticeListNode node0) {
        if (node0.next == null)
            return;
        PracticeListNode n1 = node0.next;
        PracticeListNode n2 = n1.next;
        node0.next = n2;
    }

    static PracticeListNode access(PracticeListNode head, int index) {
        for (int i = 0; i < index; i++){
            if (head == null)
                return null;
            head = head.next;
        }
        return head;
    }

    static int find(PracticeListNode head, int findValue){
        int index = 0;
        while (head != null) {
            if (head.val == findValue)
                return index;
            head = head.next;
            index++;
        }
        return -1;
    }

    public static void main(String[] args){
        /* Initialize linked list */
        //Initialize each node

        PracticeListNode n0 = new PracticeListNode(1);
        PracticeListNode n1 = new PracticeListNode(3);
        PracticeListNode n2 = new PracticeListNode(2);
        PracticeListNode n3 = new PracticeListNode(5);
        PracticeListNode n4 = new PracticeListNode(4);
        //Construct reference pointer
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println("The initialized linked list is");
        PrintUtil.printLinkedList(n0);


        /* Insert node */
        insert(n0, new PracticeListNode(0));
        System.out.println("The linked list after inserting the node is");
        PrintUtil.printLinkedList(n0);

        /* Delete node */
        remove(n0);
        System.out.println("The linked list after deleting the node is");
        PrintUtil.printLinkedList(n0);

        /* Access node */
        PracticeListNode node = access(n0, 3);
        System.out.println("The value of the node at index 3 in the linked list = " + node.val);

        /* Find node */
        int index = find(n0, 2);
        System.out.println("The index of the node with value 2 in the linked list = " + index);
    }
}
