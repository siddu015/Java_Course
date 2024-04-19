package DSA_Java;


public record Main() {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("1");
        graph.addNode("2");
        graph.addNode("3");
        graph.addNode("4");
        graph.addNode("5");

        graph.addEdge("1","2");
        graph.addEdge("1","3");
        graph.addEdge("1","5");
        graph.addEdge("2","3");
        graph.addEdge("2","4");
        graph.addEdge("5","1");
        graph.addEdge("5","3");

//        graph.removeNode("4");
        graph.traverseDepthFirst("0");
    }
} 
