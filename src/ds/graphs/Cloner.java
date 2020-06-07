package ds.graphs;

import java.util.HashMap;
import java.util.Map;

public class Cloner {

    static Node clone(Node root) {
        Map<Integer, Node> visited = new HashMap<>();
        Node node = traverseAndClone(root, visited);
        return node;
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
