package ds.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    public int data;
    public List<Node> neighbors = new ArrayList<>();
    public Node(int d) {data = d;}

    public void addNeighbor(Node n) {
        neighbors.add(n);
    }

    public String toString() {
        return "<" + data + ">";
    }

    @Override
    public boolean equals(Object other) {
        if (other.getClass() != Node.class) return false;
        return ((Node)other).data == this.data;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(data);
    }
}
