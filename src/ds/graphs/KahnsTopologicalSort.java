package ds.graphs;

import java.util.*;

public class KahnsTopologicalSort {

    public static List<Integer> topologicalSort(Graph graph) {
        int[] inDegrees = new int[graph.nodes.size()];// S:O(V)

        // Calculate indegrees for every node
        for(Integer node: graph.nodes) { // T:O(v)
            List<Integer> neighbors = graph.adjList.get(node);
            for(Integer n: neighbors) { //T:O(E)
                inDegrees[n]++;
            }
        }

        // Find nodes with zero fan-in and add them to the queue
        Queue<Integer> queue = new ArrayDeque<>(); //S:O(V)
        for(Integer node: graph.nodes) { //T:O(V)
            if (inDegrees[node] == 0) {
                queue.add(node);
            }
        }

        List<Integer> results = new ArrayList<>(); //S:O(V)

        // Iterate over neighbors and add to queue when in-degree is zero
        while(!queue.isEmpty()) { //T:O(V)
            Integer element = queue.poll();
            results.add(element);

            for(Integer n: graph.adjList.get(element)) { //T:O(E)
                inDegrees[n]--;
                if (inDegrees[n] == 0) {
                    queue.add(n);
                }
            }
        }

        if (results.size() != graph.nodes.size()) throw new RuntimeException("Graph has cycles");

        return results;
    }


}
