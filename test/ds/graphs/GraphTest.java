package ds.graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    Graph g;

    @BeforeEach
    void setup() {
        g = new Graph();
    }

    @Test
    void addNode() {
        g.addNode(2);
        assertTrue(g.nodes.contains(2));
        assertTrue(g.adjList.containsKey(2));
    }

    @Test
    void addEdge() {
        g.addNode(2);
        g.addNode(3);

        g.addEdge(2, 3);
        assertTrue(g.adjList.get(2).contains(3));
        assertTrue(g.adjList.get(3).contains(2));
    }

    @Test
    void removeEdge() {
        g.addNode(2);
        g.addNode(3);
        g.addNode(4);
        g.addEdge(2, 3);
        g.addEdge(2, 4);

        g.removeEdge(2, 3);

        assertTrue(g.adjList.get(2).contains(4));
        assertFalse(g.adjList.get(2).contains(3));
        assertTrue(g.adjList.get(3).isEmpty());
    }

    @Test
    void removeNode() {
        g.addNode(2);
        g.addNode(3);
        g.addNode(4);
        g.addEdge(2, 3);
        g.addEdge(2, 4);

        g.removeNode(3);

        assertEquals(new HashSet<>(asList(2, 4)), g.nodes);
        assertEquals(new HashSet<>(Collections.singletonList(4)), g.adjList.get(2));
    }

    @Test
    /**
     *      1
     *   2     3
     * 4   5
     */
    void depthFirstSearch() {
        g.addNode(1);
        g.addNode(2);
        g.addNode(3);
        g.addNode(4);
        g.addNode(5);
        g.addEdge(1, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 5);
        g.addEdge(2, 4);

        List<Integer> path = new ArrayList<>();
        g.depthFirstSearch(1, path::add);
        assertEquals(asList(1, 2, 4, 5, 3), path);
    }

    @Test
    /**
     *      1
     *   2     3
     * 4   5
     */
    void breadthFirstSearch() {
        g.addNode(1);
        g.addNode(2);
        g.addNode(3);
        g.addNode(4);
        g.addNode(5);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);

        List<Integer> path = new ArrayList<>();
        g.breadthFirstSearch(1, path::add);
        assertEquals(asList(1, 2, 3, 4, 5), path);
    }
}