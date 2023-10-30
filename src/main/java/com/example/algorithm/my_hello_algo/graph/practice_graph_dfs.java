package com.example.algorithm.my_hello_algo.graph;


import com.example.algorithm.my_hello_algo.utils.PracticeVertex;
import com.example.hello_algo.utils.Vertex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class practice_graph_dfs {

    /* Depth-first traversal DFS helper function */
    static void dfs(PracticeGraphAdjList graph, Set<PracticeVertex> visited, List<PracticeVertex> res, PracticeVertex vet){
        res.add(vet); //Record visited vertices
        visited.add(vet); // Mark the vertex as visited
        // Traverse all adjacent vertices of this vertex
        for (PracticeVertex adjVet: graph.adjList.get(vet)) {
            if (visited.contains(adjVet))
                continue; // Skip vertices that have already been visited
            // Recursively access adjacent vertices
            dfs(graph, visited, res, adjVet);
        }
    }

    static List<PracticeVertex> graphDFS(PracticeGraphAdjList graph, PracticeVertex startVet){
        List<PracticeVertex> res = new ArrayList<>();
        Set<PracticeVertex> visited = new HashSet<>();
        dfs(graph, visited, res, startVet);
        return res;
    }

    public static void main(String[] args) {
        /* Initialize undirected graph */
        PracticeVertex[] v = PracticeVertex.valsToVets(new int[] { 0, 1, 2, 3, 4, 5, 6 });
        PracticeVertex[][] edges = { { v[0], v[1] }, { v[0], v[3] }, { v[1], v[2] },
                { v[2], v[5] }, { v[4], v[5] }, { v[5], v[6] } };
        PracticeGraphAdjList graph = new PracticeGraphAdjList(edges);
        System.out.println("\nAfter initialization, the picture is");
        graph.print();

        /* Depth-first traversal of DFS */
        List<PracticeVertex> res = graphDFS(graph, v[0]);
        System.out.println("\nThe depth-first traversal (DFS) vertex sequence is");
        System.out.println(PracticeVertex.vetsToVals(res));
    }

}
