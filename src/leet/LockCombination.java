package leet;

import java.util.*;

public class LockCombination {

    String SEPARATOR = "XXXX";

    public int openLock(String[] deadends, String target) {

        Set<String> seen = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new ArrayDeque<>();

        String node = "0000";
        queue.add(node);
        seen.add(node);
        queue.add(SEPARATOR);
        int depth = 0;

        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.equals(SEPARATOR)) {
                depth++;
                if (!queue.isEmpty() && !queue.peek().equals(SEPARATOR)) queue.add(SEPARATOR);
            } else if (node.equals(target)) {
                return depth;
            } else {
                List<String> neighbors = bfs(node, seen);
                for (String neighbor : neighbors) {
                    queue.add(neighbor);
                    seen.add(neighbor);
                }
            }
        }

        return -1;
    }

    private List<String> bfs(String node, Set<String> seen) {
        List<String> neighbors = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char c = node.charAt(i);
            String forward = node.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + node.substring(i + 1);
            String backward = node.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + node.substring(i + 1);
            if (!seen.contains(forward)) neighbors.add(forward);
            if (!seen.contains(backward)) neighbors.add(backward);
        }
        return neighbors;
    }
}
