package com.example.algorithm.my_hello_algo.graph;

import com.example.hello_algo.utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;

class PracticeGraphAdjMat {
    List<Integer> vertices;
    List<List<Integer>> adjMat;

    public int size() {
        return vertices.size();
    }

    public PracticeGraphAdjMat(int[] vertices, int[][] edges){
        this.vertices  = new ArrayList<>();
        this.adjMat = new ArrayList<>();

        for (int val: vertices) {
            addVertex(val);
        }

        for (int[] e: edges) {
            addEdge(e[0], e[1]);
        }
    }

    /* Add vertices */
    public void addVertex(int val){
        int n = size();
        //Add the value of the new vertex to the vertex list
        vertices.add(val);
        //Add a row to the adjacency matrix
        List<Integer> newRow = new ArrayList<>(n);
        for (int j = 0; j < n; j++) {
            newRow.add(0);
        }
        adjMat.add(newRow);
        //Add a column to the adjacency matrix
        for (List<Integer> row: adjMat) {
            row.add(0);
        }
    }

    public void removeVertex(int index) {
        if (index >= size())
            throw new IndexOutOfBoundsException();
        // Remove the vertex at index from the vertex list
        vertices.remove(index);
        // Delete the row at index in the adjacency matrix
        adjMat.remove(index);
        // Delete the column at index in the adjacency matrix
        for (List<Integer> row: adjMat){
            row.remove(index);
        }
    }

    /* Add edge */
    // Parameters i, j correspond to vertices element index
    public void addEdge(int i, int j) {
        // Index out-of-bounds and equality processing
        if (i < 0 || j < 0 || i >= size() || j >= size() || i == j)
            throw new IndexOutOfBoundsException();
        adjMat.get(i).set(j, 1);
        adjMat.get(j).set(i, 1);
    }

    public void removeEdge(int i, int j){
        if (i < 0 || j < 0 || i >= size() || j >= size() || i == j)
            throw new IndexOutOfBoundsException();
        adjMat.get(i).set(j, 0);
        adjMat.get(j).set(i, 0);
    }

    /* Print adjacency matrix */
    public void print() {
        System.out.print("vertex list = ");
        System.out.println(vertices);
        System.out.println("adjacency matrix =");
        PrintUtil.printMatrix(adjMat);
    }


}
public class practice_graph_adjacency_matrix {
    public static void main(String[] args) {
        /* Initialize undirected graph */
        // Please note that the edges element represents the vertex index, which corresponds to the vertices element index
        int[] vertices = { 1, 3, 2, 5, 4 };
        int[][] edges = { { 0, 1 }, { 0, 3 }, { 1, 2 }, { 2, 3 }, { 2, 4 }, { 3, 4 } };
        PracticeGraphAdjMat graph = new PracticeGraphAdjMat(vertices, edges);
        System.out.println("\nAfter initialization, the picture is");
        graph.print();

        /* Add edge */
        //The indices of vertices 1 and 2 are 0 and 2 respectively
        graph.addEdge(0, 2);
        System.out.println("\nAfter adding edges 1-2, the picture is");
        graph.print();

        /* Delete edge */
        //The indices of vertices 1 and 3 are 0 and 1 respectively
        graph.removeEdge(0, 1);
        System.out.println("\nAfter deleting edges 1-3, the picture shows");
        graph.print();

        /* Add vertices */
        graph.addVertex(6);
        System.out.println("\nAfter adding vertex 6, the picture is");
        graph.print();

        /* Delete vertices */
        //The index of vertex 3 is 1
        graph.removeVertex(1);
        System.out.println("\nAfter deleting vertex 3, the picture is");
        graph.print();
    }
}
