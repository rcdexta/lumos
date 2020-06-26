package algo;

import java.util.*;

//Reference: https://www.interviewcake.com/concept/java/dijkstras-algorithm
public class Dijkstra {

    // Final shortest distance from starting point
    Map<String, Integer> distance;
    Graph g;

    public Dijkstra() {
        g = new Graph();
        distance = new HashMap<>();
    }

    public void apply(String start) {
        PriorityQueue<Neighbor> queue = new PriorityQueue<>();
        Set<String> settled = new HashSet<>();

        // Initialize all distances to infinity
        for(String node: g.nodes) { //T:O(N)
            distance.put(node, Integer.MAX_VALUE);
        }

        // add starting point as cost 0
        queue.add(new Neighbor(start, 0));
        distance.put(start, 0);

        while(settled.size() != g.nodes.size()) { //T:O(E)
            Neighbor current = queue.poll();

            int currentCost = distance.get(current.name);

            for(Neighbor n: g.getNeighbors(current.name)) {
                if (!settled.contains(n.name)) {
                    int cost = currentCost + n.cost;

                    // if node not already settled, find new cost and add if cheaper
                    if (distance.get(n.name) > cost) {
                        distance.put(n.name, cost);
                    }

                    // because a priority queue, the next neighbor with shortest cost will always be taken up next
                    queue.add(n);
                }
            }

            settled.add(current.name);
        }
    }

    public static void main(String[] args) {
        Dijkstra d = new Dijkstra();
        Graph g = d.g;

        String memphis = g.addNode("Memphis");
        String newOrleans = g.addNode("New Orleans");
        String mobile = g.addNode("Mobile");
        String savannah = g.addNode("Savannah");
        String atlanta = g.addNode("Atlanta");
        String nashville = g.addNode("Nashville");

        g.addNeighbor(memphis, newOrleans, 3);
        g.addNeighbor(memphis, mobile, 7);
        g.addNeighbor(memphis, atlanta, 10);
        g.addNeighbor(memphis, nashville, 15);

        g.addNeighbor(newOrleans, mobile, 3);

        g.addNeighbor(mobile, savannah, 6);
        g.addNeighbor(mobile, atlanta, 2);

        g.addNeighbor(savannah, atlanta, 1);
        g.addNeighbor(atlanta, nashville, 2);

        d.apply(memphis);

        System.out.println(d.distance);
    }
}

class Graph {
    Set<String> nodes;
    Map<String, List<Neighbor>> adjList;

    public Graph() {
        this.nodes = new HashSet<>();
        this.adjList = new HashMap<>();
    }

    public String addNode(String node) {
        if (!nodes.contains(node)) {
            nodes.add(node);
            adjList.put(node, new ArrayList<>());
        }
        return node;
    }

    public void addNeighbor(String node, String neighbor, int cost) {
        Neighbor neighborNode = new Neighbor(neighbor, cost);
        Neighbor other = new Neighbor(node, cost);
        adjList.get(node).add(neighborNode);
        adjList.get(neighbor).add(other);
    }

    public List<Neighbor> getNeighbors(String node) {
        return adjList.get(node);
    }
}


class Neighbor implements Comparable<Neighbor> {
    String name;
    int cost;

    public Neighbor(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String toString() {
        return String.format("%s : %s", name, cost);
    }

    // will be used by priority queue to find the shortest next neighbor
    @Override
    public int compareTo(Neighbor other) {
        return Integer.compare(cost, other.cost);
    }

    // will be used by set for uniqueness
    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != Neighbor.class) return false;
        Neighbor other = (Neighbor) o;
        return name.equals(other.name);
    }
}