package com.example.algorithm.my_hello_algo.tree;

import com.example.algorithm.my_hello_algo.utils.PracticeListNode;
import com.example.algorithm.my_hello_algo.utils.PracticeTreeNode;
import com.example.hello_algo.utils.PrintUtil;
import com.example.hello_algo.utils.TreeNode;

import java.util.*;

public class practice_binary_tree_bfs {

    public static List<Integer> levelOrder(PracticeTreeNode root) {
        Queue<PracticeTreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            PracticeTreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return list;
    }

    public static void main(String[] args){
        PracticeTreeNode root = PracticeTreeNode.listToTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println("\nInitialize binary tree\n");
        PrintUtil.printTree(root);

        List<Integer> list = levelOrder(root);
        System.out.println("\nNode printing sequence for layer sequential traversal = " + list);
    }
}
