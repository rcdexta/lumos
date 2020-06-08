package ds.graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class KahnsTopologicalSortTest {

    // Reference: https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/

    Graph graph;

    @BeforeEach
    void setup() {
        graph = new Graph();
        graph.addNode(5);
        graph.addNode(4);
        graph.addNode(0);
        graph.addNode(2);
        graph.addNode(1);
        graph.addNode(3);

        graph.adjList.get(5).add(0);
        graph.adjList.get(5).add(2);
        graph.adjList.get(4).add(0);
        graph.adjList.get(4).add(1);
        graph.adjList.get(2).add(3);
        graph.adjList.get(3).add(1);
    }

    @Test
    void topologicalSort() {
        List<Integer> results = KahnsTopologicalSort.topologicalSort(graph);
        System.out.println(results);
    }
}