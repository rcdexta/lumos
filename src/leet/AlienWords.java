package leet;

import java.util.*;

public class AlienWords {

    public String alienOrder(String[] words) {
        Graph g = new Graph();

        for(String word: words) {
            for(int i=0;i<word.length();i++) {
                Character c = word.charAt(i);
                g.addVertex(c);
            }
        }

        for(int i=0;i<words.length-1;i++) {
            String first = words[i];
            String second = words[i+1];

            // if one word is prefix of another, invalid ordering!
            if (first.length() > second.length() && first.startsWith(second)) {
                return "";
            }

            for(int j=0;j<Math.min(first.length(), second.length());j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    g.addNeighbor(first.charAt(j), second.charAt(j));
                    break;
                }
            }
        }

        System.out.println(g.adjList);
        System.out.println(g.inDegrees);
        System.out.println(g.topologicalOrder());

        return g.topologicalOrder();
    }
}

class Graph {
    Set<Character> vertices;
    Map<Character, Set<Character>> adjList;
    Map<Character, Integer> inDegrees;

    public Graph() {
        vertices = new HashSet<>();
        adjList = new HashMap<>();
        inDegrees = new HashMap<>();
    }

    public void addVertex(Character vertex) {
        if (!vertices.contains(vertex)) {
            vertices.add(vertex);
            adjList.put(vertex, new HashSet<>());
        }
    }

    public void addNeighbor(Character vertex, Character neighbor) {
        if (!this.adjList.get(vertex).contains(neighbor)) {
            this.adjList.get(vertex).add(neighbor);
            Integer count = inDegrees.getOrDefault(neighbor, 0);
            inDegrees.put(neighbor, count + 1);
        }
    }

    public String topologicalOrder() {
        Queue<Character> queue = new ArrayDeque<>();
        for(Character letter: vertices) {
            Integer count = inDegrees.getOrDefault(letter, 0);
            if (count == 0) queue.add(letter);
        }

        StringBuilder order = new StringBuilder();
        while(!queue.isEmpty()) {
            Character letter = queue.poll();
            order.append(letter);

            for(Character neighbor: adjList.get(letter)) {
                Integer count = inDegrees.get(neighbor);
                count--;
                inDegrees.put(neighbor, count);
                if (count == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return order.toString();
    }


}
