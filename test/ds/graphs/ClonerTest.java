package ds.graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ClonerTest {

    Node root;

    @BeforeEach
    void setup() {
        Node node0 = new Node(0);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node1 = new Node(1);
        Node node2 = new Node(2);

        node0.addNeighbor(node3);
        node0.addNeighbor(node4);
        node0.addNeighbor(node2);

        node4.addNeighbor(node0);
        node4.addNeighbor(node1);
        node4.addNeighbor(node3);

        node1.addNeighbor(node2);

        node3.addNeighbor(node2);

        node2.addNeighbor(node0);

        root = node0;
    }

    @Test
    void testClone() {
        System.out.println("Original:");
        printGraph(root);

        System.out.println();
        System.out.println("after clone:");
        Node clone = Cloner.clone(root);

        printGraph(clone);
    }

    @Test
    void shouldDFS() {
        Cloner.dfsIterative(root, node -> System.out.println(node));
    }

    void printGraph(Node node) {
        Set<Node> visited = new HashSet<>();
        traverse(node, visited);
    }

    void traverse(Node node, Set<Node> visited) {
        visited.add(node);

        System.out.print(node.data + ": " );
        for(Node n: node.neighbors) {
            System.out.print(n.data + ", ");
        }
        System.out.println("");

        for(Node n: node.neighbors) {
            if (!visited.contains(n)) {
                traverse(n, visited);
            }
        }
    }
}