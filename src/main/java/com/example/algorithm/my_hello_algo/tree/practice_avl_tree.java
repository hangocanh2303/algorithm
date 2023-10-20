package com.example.algorithm.my_hello_algo.tree;


import com.example.algorithm.my_hello_algo.utils.PracticeTreeNode;

class PracticeAVLTree {
    PracticeTreeNode root;

    public int height(PracticeTreeNode node){
        return node == null ? -1 : node.height;
    }

    private void updateHeight(PracticeTreeNode node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }
}
public class practice_avl_tree {
}
