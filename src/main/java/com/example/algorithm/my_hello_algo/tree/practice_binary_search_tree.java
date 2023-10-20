package com.example.algorithm.my_hello_algo.tree;


import com.example.algorithm.my_hello_algo.utils.PracticeTreeNode;
import com.example.hello_algo.utils.PrintUtil;
import com.example.hello_algo.utils.TreeNode;

class PracticeBinarySearchTree {
    private PracticeTreeNode root;

    public PracticeBinarySearchTree(){
        root = null;
    }
    public PracticeTreeNode getRoot() {
        return root;
    }

    public PracticeTreeNode search(int num) {
        PracticeTreeNode curr = root;
        while (curr != null) {
            if (curr.val < num){
                curr = curr.right;
            }else if (curr.val > num){
                curr = curr.left;
            }else {
                break;
            }
        }
        return curr;
    }

    public void insert(int num) {
        //If the tree is empty, initialize the root node
        if (root == null) {
            root = new PracticeTreeNode(num);
            return;
        }
        PracticeTreeNode curr = root, pre = null;
        // Loop search, jump out after crossing the leaf node
        while (curr != null) {
            // Find duplicate nodes and return directly
            if (curr.val == num)
                return;
            pre = curr;
            //The insertion position is in the right subtree of cur
            if (curr.val < num)
                curr = curr.right;
            //The insertion position is in the left subtree of cur
            else
                curr = curr.left;
        }
        //Insert node
        PracticeTreeNode node = new PracticeTreeNode(num);
        if (pre.val < num)
            pre.right = node;
        else
            pre.left = node;
    }

    public void remove(int num){
        //If the tree is empty, return directly early
        if (root == null)
            return;
        PracticeTreeNode curr = root, pre = null;
        // Loop search, jump out after crossing the leaf node
        while (curr != null){
            // Find the node to be deleted and break out of the loop
            if (curr.val == num)
                break;
            pre = curr;
            if (curr.val < num)
                curr = curr.right;
            else
                curr = curr.left;
        }
        if (curr == null)
            return;
        //Number of child nodes = 0 or 1
        if (curr.left == null || curr.right == null){
            // When the number of child nodes = 0 / 1, child = null / the child node
            PracticeTreeNode child = curr.left == null ? curr.right : curr.left;
            // Delete node cur
            if (curr != root) {
                if (pre.left == curr)
                    pre.left = child;
                else
                    pre.right = child;
            }else {
                root = child;
            }
        }
        // number of child nodes = 2
        else {
            // Get the next node of cur in in-order traversal
            PracticeTreeNode tmp = curr.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }

            //Recursively delete node tmp
            remove(tmp.val);
            // overwrite cur with tmp
            curr.val = tmp.val;
        }
    }
}
public class practice_binary_search_tree {
    public static void main(String[] args) {
        /* Initialize binary search tree */
        PracticeBinarySearchTree bst = new PracticeBinarySearchTree();
        // Please note that different insertion orders will generate different binary trees. This sequence can generate a perfect binary tree.
        int[] nums = { 8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15 };
        for (int num : nums) {
            bst.insert(num);
        }
        System.out.println("\nThe initialized binary tree is\n");
        PrintUtil.printTree(bst.getRoot());

        /* Find node */
        PracticeTreeNode node = bst.search(7);
        System.out.println("\nThe node object found is " + node + "，node value = " + node.val);

        /* Insert node */
        bst.insert(16);
        System.out.println("\nInsert node 16 back，The binary tree is\n");
        PrintUtil.printTree(bst.getRoot());

        /* Delete node */
        bst.remove(1);
        System.out.println("\nAfter deleting node 1, the binary tree is\n");
        PrintUtil.printTree(bst.getRoot());
        bst.remove(2);
        System.out.println("\nAfter deleting node 2, the binary tree is\n");
        PrintUtil.printTree(bst.getRoot());
        bst.remove(4);
        System.out.println("\nAfter deleting node 4, the binary tree is\n");
        PrintUtil.printTree(bst.getRoot());
    }
}
