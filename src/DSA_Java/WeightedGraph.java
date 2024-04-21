package DSA_Java;

import java.util.*;
import java.util.PriorityQueue;

public class WeightedGraph {
    private class Node {
        private final String label;
        private final List<Edge> edges = new ArrayList<>();

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return  label;
        }

        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges() {
            return edges;
        }
    }

    private class Edge {
        Node from, to;
        int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + " -> " + to;
        }
    }

    private final Map<String, Node> nodes = new HashMap<>();

    public void add(String label) {
        nodes.putIfAbsent(label, new Node(label));
    }

    public void addEdge(String from, String to, int weight) {
        var fromNode = nodes.get(from);
        if(fromNode == null)
            throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if(toNode == null)
            throw new IllegalArgumentException();

        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }

    public void print() {
        for(var node: nodes.values()) {
            var targets = node.getEdges();
            if(!targets.isEmpty())
                System.out.println(node + " is connected to " + targets);
        }
    }

    private class NodeEntry {
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    public int getShortestPath(String from, String to) {
        var fromNode = nodes.get(from);

        Map<Node, Integer> distances = new HashMap<>();
        for(var node: nodes.values())
            distances.put(node, Integer.MAX_VALUE);
        distances.replace(fromNode, 0);

        Set<Node> visited = new HashSet<>();

        PriorityQueue<NodeEntry> queue= new PriorityQueue<>(
                Comparator.comparingInt(ne -> ne.priority)
        );
        queue.add(new NodeEntry(fromNode, 0));

        while(!queue.isEmpty()) {
            var current = queue.remove().node;
            visited.add(current);

            for(var edge: current.getEdges()) {
                if(visited.contains(edge.to))
                    continue;

                var newDistance = distances.get(current)  + edge.weight;
                if(newDistance < distances.get(edge.to)){
                    distances.replace(edge.to, newDistance);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }

        return  0;
    }

}
