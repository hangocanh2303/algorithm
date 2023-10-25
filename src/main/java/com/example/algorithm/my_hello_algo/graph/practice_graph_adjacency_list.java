package com.example.algorithm.my_hello_algo.graph;




import com.example.algorithm.my_hello_algo.utils.PracticeVertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PracticeGraphAdjList {
    Map<PracticeVertex, List<PracticeVertex>> adjList;

    public PracticeGraphAdjList(PracticeVertex[][] edges){
        this.adjList = new HashMap<>();
        for (PracticeVertex[] edge: edges){
            addVertex(edge[0]);
            addVertex(edge[1]);
            addEdge(edge[0], edge[1]);
        }
    }

    public int size() {
        return adjList.size();
    }

    public void addVertex(PracticeVertex vet){
        if (adjList.containsKey(vet))
            return;
        adjList.put(vet, new ArrayList<>());
    }

    public void removeVertex(PracticeVertex vet) {
        if (!adjList.containsKey(vet))
            throw new IllegalArgumentException();
        adjList.remove(vet);
        for (List<PracticeVertex> list: adjList.values()) {
            list.remove(vet);
        }
    }



    public void addEdge(PracticeVertex vet1, PracticeVertex vet2) {
        if (!adjList.containsKey(vet1) || !adjList.containsKey(vet2) || vet1 == vet2)
            throw new IllegalArgumentException();
        adjList.get(vet1).add(vet2);
        adjList.get(vet2).add(vet1);
    }

    public void removeEdge(PracticeVertex vet1, PracticeVertex vet2){
        if (!adjList.containsKey(vet1) || !adjList.containsKey(vet2) || vet1 == vet2)
            throw new IllegalArgumentException();
        adjList.get(vet1).remove(vet2);
        adjList.get(vet2).remove(vet1);
    }

    public void print() {
        System.out.println("adjacency list =");
        for (Map.Entry<PracticeVertex, List<PracticeVertex>> pair : adjList.entrySet()) {
            List<Integer> tmp = new ArrayList<>();
            for (PracticeVertex vertex : pair.getValue())
                tmp.add(vertex.val);
            System.out.println(pair.getKey().val + ": " + tmp + ",");
        }
    }

}
public class practice_graph_adjacency_list {
    public static void main(String[] args) {
        /* Initialize undirected graph */
        PracticeVertex[] v = PracticeVertex.valsToVets(new int[] { 1, 3, 2, 5, 4 });
        PracticeVertex[][] edges = { { v[0], v[1] }, { v[0], v[3] }, { v[1], v[2] },
                { v[2], v[3] }, { v[2], v[4] }, { v[3], v[4] } };
        PracticeGraphAdjList graph = new PracticeGraphAdjList(edges);
        System.out.println("\nAfter initialization, the picture is");
        graph.print();

        /* Add edge */
        //Vertices 1, 2 are v[0], v[2]
        graph.addEdge(v[0], v[2]);
        System.out.println("\nAfter adding edges 1-2, the picture is");
        graph.print();

        /* Delete edge */
        //Vertices 1, 3 are v[0], v[1]
        graph.removeEdge(v[0], v[1]);
        System.out.println("\nAfter deleting edges 1-3, the picture shows");
        graph.print();

        /* Add vertices */
        PracticeVertex v5 = new PracticeVertex(6);
        graph.addVertex(v5);
        System.out.println("\nAfter adding vertex 6, the picture is");
        graph.print();

        /* Delete vertices */
        //Vertex 3 is v[1]
        graph.removeVertex(v[1]);
        System.out.println("\nAfter deleting vertex 3, the picture is");
        graph.print();
    }
}
