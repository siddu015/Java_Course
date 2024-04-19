package DSA_Java;

import java.util.*;
import java.util.Stack;

public class Graph {
    private static class Node {
        String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private final Map<String, Node> nodes = new HashMap<>();
    private final Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        var fromNode = nodes.get(from);
        if(fromNode == null)
            throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if(toNode == null)
            throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode);
    }

    public void print() {
        for(var source: adjacencyList.keySet()) {
            var targets = adjacencyList.get(source);
            if(!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
        }
    }

    public void removeNode(String label) {
        var node = nodes.get(label);
        if(node == null) return;

        for(var n: adjacencyList.keySet())
            adjacencyList.get(n).remove(node);

        adjacencyList.remove(node);
        nodes.remove(node);
    }

    public void removeEdge(String from, String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if(fromNode == null || toNode == null) return;

        adjacencyList.get(fromNode).remove(toNode);
    }

    public void traverseDepthFirst(String root) {
        if(!nodes.containsKey(root))
            return;

        traverseDepthFirstRec(nodes.get(root), new HashSet<>());
    }

    private void traverseDepthFirstRec(Node root, Set<Node> visited) {
        System.out.println(root);
        visited.add(root);

        for(var node: adjacencyList.get(root))
            if(!visited.contains(node))
                traverseDepthFirstRec(node, visited);
    }

    private void traverseDepthFirstIte(String root) {
        var node = nodes.get(root);
        if(node == null)
            return;

        Set<Node> visited = new HashSet<>();

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            var current = stack.pop();

            if(visited.contains(current))
                continue;

            System.out.println(current);
            visited.add(current);

            for(var neighbour: adjacencyList.get(current))
                if(!visited.contains(neighbour))
                    stack.push(neighbour);
        }
    }
}