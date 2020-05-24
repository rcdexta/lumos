package recursion;

public class LinkedListLength {

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node node3 = new Node(1);
        Node node2 = new Node(1, node3);
        Node node1 = new Node(1, node2);
        Node head = new Node(1, node1);

        int length = lengthOfList(head);
        System.out.println(length);
    }

    private static int lengthOfList(Node node) {
        if (node == null) return 0;

        return 1 + lengthOfList(node.next);
    }
}
