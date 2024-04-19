package DSA_Java;


public record Main() {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A","B");
        graph.addEdge("C","A");
        graph.addEdge("B","C");
        graph.addEdge("D","A");

        System.out.println(graph.hasCycle());
    }
} 
