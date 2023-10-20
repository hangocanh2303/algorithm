package com.example.algorithm.my_hello_algo.tree;

import com.example.algorithm.my_hello_algo.utils.PracticeTreeNode;
import com.example.hello_algo.utils.PrintUtil;
import com.example.hello_algo.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

public class practice_binary_tree_dfs {
    static ArrayList<Integer> list = new ArrayList<>();

    static void preOrder(PracticeTreeNode root) {
        if (root == null)
            return;
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    static void inOrder(PracticeTreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    static void postOrder(PracticeTreeNode root) {
        if (root == null)
            return;
        postOrder(root.right);
        list.add(root.val);
        postOrder(root.left);
    }

    public static void main(String[] args) {
        /* Initialize binary tree */
        // Here we use a function that directly generates a binary tree from an array
        PracticeTreeNode root = PracticeTreeNode.listToTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println("\nInitialize binary tree\n");
        PrintUtil.printTree(root);

        /* Preorder traversal */
        list.clear();
        preOrder(root);
        System.out.println("\nPrint sequence of nodes traversed in preorder = " + list);

        /* In-order traversal */
        list.clear();
        inOrder(root);
        System.out.println("\nNode printing sequence for in-order traversal = " + list);

        /* Postorder traversal */
        list.clear();
        postOrder(root);
        System.out.println("\nNode printing sequence for postorder traversal = " + list);
    }

}
