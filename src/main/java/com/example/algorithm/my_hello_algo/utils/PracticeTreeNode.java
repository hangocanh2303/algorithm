package com.example.algorithm.my_hello_algo.utils;

import com.example.hello_algo.utils.TreeNode;

import java.util.List;

public class PracticeTreeNode {
    public int val;
    public PracticeTreeNode left;
    public PracticeTreeNode right;

    public PracticeTreeNode(int val) {
        this.val = val;
    }


    public static PracticeTreeNode listToTreeDFS(List<Integer> arr, int i) {
        if (i < 0 || i >= arr.size() || arr.get(i) == null) {
            return null;
        }
        PracticeTreeNode root = new PracticeTreeNode(arr.get(i));
        root.left = listToTreeDFS(arr, 2 * i + 1);
        root.right = listToTreeDFS(arr, 2 * i + 2);
        return root;
    }

    public static PracticeTreeNode listToTree(List<Integer> arr) {
        return listToTreeDFS(arr, 0);
    }
}
