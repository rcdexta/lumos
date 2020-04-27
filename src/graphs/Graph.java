package graphs;

import java.util.*;
import java.util.function.Consumer;

public class Graph {

    Set<Integer> nodes;
    Map<Integer, List<Integer>> adjList;

    public Graph() {
        this.nodes = new HashSet<>();
        this.adjList = new HashMap<>();
    }

    public void addNode(Integer node) {
        this.nodes.add(node);
        this.adjList.put(node, new ArrayList<>());
    }

    public void addEdge(Integer node1, Integer node2) {
        this.adjList.get(node1).add(node2);
        this.adjList.get(node2).add(node1);
    }

    public void removeEdge(Integer node1, Integer node2) {
        this.adjList.get(node1).remove(node2);
        this.adjList.get(node2).remove(node1);
    }

    public void removeNode(Integer node) {
        this.adjList.get(node).forEach(other -> removeEdge(node, other));
        this.nodes.remove(node);
    }

    public void depthFirstSearch(Integer root, Consumer<Integer> callback) {
        List<Integer> visited = new ArrayList<>(this.nodes.size());
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(root);
        visited.add(root);

        while(!stack.isEmpty()) {
            Integer top = stack.pop();
            callback.accept(top);

            List<Integer> neighbors = this.adjList.get(top);
            neighbors.forEach(neighbor -> {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                    visited.add(neighbor);
                }
            });
        }
    }

    public void breadthFirstSearch(Integer root, Consumer<Integer> callback) {
        List<Integer> visited = new ArrayList<>(this.nodes.size());
        Deque<Integer> queue = new ArrayDeque<>();

        queue.add(root);
        visited.add(root);

        while(!queue.isEmpty()) {
            Integer top = queue.removeFirst();
            callback.accept(top);

            List<Integer> neighbors = this.adjList.get(top);
            neighbors.forEach(neighbor -> {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            });
        }
    }
}
