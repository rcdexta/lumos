package ds.graphs;

import java.util.*;
import java.util.function.Consumer;

public class Cloner {

    static Node clone(Node root) {
        Map<Integer, Node> visited = new HashMap<>();
        Node node = traverseAndClone(root, visited);
        return node;
    }

    static void dfsIterative(Node root, Consumer<Node> callback) {
        Set<Integer> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            Node node = stack.pop();
            visited.add(node.data);

            System.out.println(node);
            System.out.println(visited);
            System.out.println(stack);
            System.out.println();

//            callback.accept(node);
            for(Node neighbor: node.neighbors) {
                if (!visited.contains(neighbor.data)) {
                    stack.push(neighbor);
                }
            }
        }
    }

    private static Node traverseAndClone(Node node, Map<Integer, Node> visited) {
        Node clone = new Node(node.data);
        visited.put(node.data, clone);
        for(Node neighbor: node.neighbors) {
            Node next = visited.get(neighbor.data);
            if (next != null) {
                clone.addNeighbor(next);
            } else {
                clone.addNeighbor(traverseAndClone(neighbor, visited));
            }
        }
        return clone;
    }
}
