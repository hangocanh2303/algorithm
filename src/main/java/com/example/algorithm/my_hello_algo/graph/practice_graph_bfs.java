package com.example.algorithm.my_hello_algo.graph;

import com.example.algorithm.my_hello_algo.utils.PracticeVertex;
import com.example.hello_algo.utils.Vertex;

import java.util.*;

public class practice_graph_bfs {

    /* Breadth-first traversal of BFS */
    // Use an adjacency list to represent the graph to obtain all adjacent vertices of a specified vertex
    static List<PracticeVertex> graphBFS(PracticeGraphAdjList graph, PracticeVertex startVet){
        // Vertex traversal sequence
        List<PracticeVertex> res = new ArrayList<>();
        // Hash table, used to record the vertices that have been visited
        Set<PracticeVertex> visited = new HashSet<>();
        visited.add(startVet);
        //Queue is used to implement BFS
        Queue<PracticeVertex> que = new LinkedList<>();
        que.offer(startVet);
        // Starting from vertex vet, loop until all vertices are visited
        while (!que.isEmpty()) {
            PracticeVertex vet = que.poll(); //The first vertex of the team leaves the team
            res.add(vet); //Record visited vertices
            for (PracticeVertex adjVet: graph.adjList.get(vet)){ // Traverse all adjacent vertices of this vertex
                if (visited.contains(adjVet)) // Skip vertices that have already been visited
                    continue;
                que.offer(adjVet); // Only enqueue unvisited vertices
                visited.add(adjVet); // Mark the vertex as visited
            }
        }
        // Return the vertex traversal sequence
        return res;
    }

    public static void main(String[] args) {
        /* Initialize undirected graph */
        PracticeVertex[] v = PracticeVertex.valsToVets(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        PracticeVertex[][] edges = { { v[0], v[1] }, { v[0], v[3] }, { v[1], v[2] }, { v[1], v[4] },
                { v[2], v[5] }, { v[3], v[4] }, { v[3], v[6] }, { v[4], v[5] },
                { v[4], v[7] }, { v[5], v[8] }, { v[6], v[7] }, { v[7], v[8] } };
        PracticeGraphAdjList graph = new PracticeGraphAdjList(edges);
        System.out.println("\nAfter initialization, the picture is");
        graph.print();

        /* Breadth-first traversal of BFS */
        List<PracticeVertex> res = graphBFS(graph, v[0]);
        System.out.println("\nBreadth-first traversal (BFS) vertex sequence is");
        System.out.println(PracticeVertex.vetsToVals(res));
    }
}
