package com.example.algorithm.my_hello_algo.tree;

import com.example.algorithm.my_hello_algo.utils.PracticeTreeNode;
import com.example.hello_algo.utils.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PracticeArrayBinaryTree {
    private List<Integer> tree;

    public PracticeArrayBinaryTree(List<Integer> arr) {
        tree = new ArrayList<>(arr);
    }

    public int size(){
        return tree.size();
    }
    public Integer val(int i){
        if (i < 0 || i >= size())
            return null;
        return tree.get(i);
    }

    public Integer left(int i){
        return 2 * i + 1;
    }

    public Integer right(int i){
        return 2 * i + 2;
    }

    public Integer parent(int i) {
        return (i - 1) / 2;
    }

    public List<Integer> levelOrder() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size(); i++){
            if (val(i) != null)
                result.add(val(i));
        }
        return result;
    }

    private void dfs(Integer i, String order, List<Integer> res) {
        if (val(i) == null)
            return;
        if (order == "pre")
            res.add(val(i));
        dfs(left(i), order, res);
        if (order == "in")
            res.add(val(i));
        dfs(right(i), order, res);
        if (order == "post")
            res.add(val(i));
    }

    public List<Integer> preOrder() {
        List<Integer> res = new ArrayList<>();
        dfs(0, "pre", res);
        return res;
    }

    public List<Integer> inOrder() {
        List<Integer> res = new ArrayList<>();
        dfs(0, "in", res);
        return res;
    }

    public List<Integer> postOrder() {
        List<Integer> res = new ArrayList<>();
        dfs(0, "post", res);
        return res;
    }

}
public class practice_array_binary_tree {
    public static void main(String[] args) {
        //Initialize binary tree
        // Here we use a function that directly generates a binary tree from an array
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, null, 6, 7, 8, 9, null, null, 12, null, null, 15);

        PracticeTreeNode root = PracticeTreeNode.listToTree(arr);
        System.out.println("\nInitialize binary tree\n");
        System.out.println("Array representation of binary tree：");
        System.out.println(arr);
        System.out.println("Linked list representation of binary tree：");
        PrintUtil.printTree(root);

        // Binary tree class under array representation
        PracticeArrayBinaryTree abt = new PracticeArrayBinaryTree(arr);

        //Access node
        int i = 1;
        Integer l = abt.left(i);
        Integer r = abt.right(i);
        Integer p = abt.parent(i);
        System.out.println("\nThe index of the current node is " + i + " ，The value is " + abt.val(i));
        System.out.println("The index of its left child node is " + l + " ，The value is " + (l == null ? "null" : abt.val(l)));
        System.out.println("The index of its right child node is " + r + " ，The value is " + (r == null ? "null" : abt.val(r)));
        System.out.println("The index of its parent node is " + p + " ，The value is " + (p == null ? "null" : abt.val(p)));

        // 遍历树
        List<Integer> res = abt.levelOrder();
        System.out.println("\nThe layer-order traversal is：" + res);
        res = abt.preOrder();
        System.out.println("Pre-order traversal is：" + res);
        res = abt.inOrder();
        System.out.println("In-order traversal is：" + res);
        res = abt.postOrder();
        System.out.println("Post-order traversal is：" + res);
    }
}
