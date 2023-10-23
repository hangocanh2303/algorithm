package com.example.algorithm.my_hello_algo.tree;


import com.example.algorithm.my_hello_algo.utils.PracticeTreeNode;
import com.example.hello_algo.utils.PrintUtil;

class PracticeAVLTree {
    PracticeTreeNode root;

    public int height(PracticeTreeNode node){
        return node == null ? -1 : node.height;
    }

    private void updateHeight(PracticeTreeNode node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    public int balanceFactor(PracticeTreeNode node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    private PracticeTreeNode rightRotate(PracticeTreeNode node) {
        PracticeTreeNode child = node.left;
        PracticeTreeNode grandChild = child.right;

        child.right = node;
        node.left = grandChild;

        updateHeight(node);
        updateHeight(child);

        return child;
    }

    private PracticeTreeNode leftRotate(PracticeTreeNode node) {
        PracticeTreeNode child = node.right;
        PracticeTreeNode grandChild = child.left;

        child.left = node;
        node.right = grandChild;

        updateHeight(node);
        updateHeight(child);

        return child;
    }

    private PracticeTreeNode rotate(PracticeTreeNode node) {
        int balanceFactor = balanceFactor(node);
        if (balanceFactor > 1) {
            if (balanceFactor(node.left) >= 0) {
                return rightRotate(node);
            }else {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (balanceFactor < -1) {
            if (balanceFactor(node.right) <= 0) {
                return leftRotate(node);
            }else {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private PracticeTreeNode insertHelper(PracticeTreeNode node, int val){
        if (node == null)
            return new PracticeTreeNode(val);
        if (val < node.val)
            node.left = insertHelper(node.left,val);
        else if (val > node.val)
            node.right = insertHelper(node.right, val);
        else
            return node;
        updateHeight(node);
        node = rotate(node);
        return node;
    }

    public void insert(int val) {
        root = insertHelper(root, val);
    }

    private PracticeTreeNode removeHelper(PracticeTreeNode node, int val){
        if (node == null)
            return null;
        if (val < node.val)
            node.left = removeHelper(node.left, val);
        else if (val > node.val)
            node.right = removeHelper(node.right, val);
        else {
            if (node.left == null || node.right == null) {
                PracticeTreeNode child = node.left != null ? node.left : node.right;
                if (child == null)
                    return null;
                else
                    node = child;
            }
            else {
                PracticeTreeNode temp = node.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                node.right = removeHelper(node.right, temp.val);
                node.val = temp.val;
            }
        }
        updateHeight(node);
        node = rotate(node);
        return node;
    }
    public void remove(int val) {
        root = removeHelper(root, val);
    }

    public PracticeTreeNode search(int val){
        PracticeTreeNode curr = root;
        while (curr != null) {
            if (curr.val < val)
                curr = curr.right;
            else if (curr.val > val)
                curr = curr.left;
            else
                break;
        }
        return curr;
    }

}
public class practice_avl_tree {
    static void testInsert(PracticeAVLTree tree, int val) {
        tree.insert(val);
        System.out.println("\nAfter inserting node " + val + ", the AVL tree is ");
        PrintUtil.printTree(tree.root);
    }

    static void testRemove(PracticeAVLTree tree, int val) {
        tree.remove(val);
        System.out.println("\nAfter deleting the node " + val + ", the AVL tree is ");
        PrintUtil.printTree(tree.root);
    }

    public static void main(String[] args) {

        PracticeAVLTree avlTree = new PracticeAVLTree();

        /* Insert node */
        // Please pay attention to how the AVL tree remains balanced after inserting the node.
        testInsert(avlTree, 1);
        testInsert(avlTree, 2);
        testInsert(avlTree, 3);
        testInsert(avlTree, 4);
        testInsert(avlTree, 5);
        testInsert(avlTree, 8);
        testInsert(avlTree, 7);
        testInsert(avlTree, 9);
        testInsert(avlTree, 10);
        testInsert(avlTree, 6);

        /* Insert duplicate nodes */
        testInsert(avlTree, 7);

        /* Delete node */
        // Please pay attention to how the AVL tree remains balanced after deleting the node.
        testRemove(avlTree, 8); // Delete nodes with degree 0
        testRemove(avlTree, 5); // Delete the node with degree 1
        testRemove(avlTree, 4); // Delete the node with degree 2

        /* Query node */
        PracticeTreeNode node = avlTree.search(7);
        System.out.println("\nThe node object found is " + node + ", and the node value = " + node.val);
    }

}
