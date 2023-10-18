package com.example.algorithm.my_hello_algo.tree;

import com.example.algorithm.my_hello_algo.utils.PracticeTreeNode;
import com.example.hello_algo.utils.PrintUtil;

public class practice_binary_tree {
    public static void main(String[] args){

        PracticeTreeNode n1 = new PracticeTreeNode(1);
        PracticeTreeNode n2 = new PracticeTreeNode(2);
        PracticeTreeNode n3 = new PracticeTreeNode(3);
        PracticeTreeNode n4 = new PracticeTreeNode(4);
        PracticeTreeNode n5 = new PracticeTreeNode(5);

        //Construct reference pointer (i.e. pointer)
        n1.left =  n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        System.out.println("\nInitialize binary tree\n");
        PrintUtil.printTree(n1);

        /* Insert and delete nodes */
        PracticeTreeNode P = new PracticeTreeNode(0);
        //Insert node P between n1 -> n2
        n1.left = P;
        P.left = n2;

        System.out.println("\nAfter inserting node P\n");
        PrintUtil.printTree(n1);

       // Delete node P
        n1.left = n2;
        System.out.println("\nAfter deleting node P\n");
        PrintUtil.printTree(n1);
    }
}
