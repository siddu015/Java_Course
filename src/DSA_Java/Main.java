package DSA_Java;


public record Main() {
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();
        graph.add("A");
        graph.add("B");
        graph.add("C");
        graph.add("D");

        graph.addEdge("A","B", 20);
        graph.addEdge("C","A", 10);
        graph.addEdge("B","C", 5);
        graph.addEdge("D","A", 15);

        graph.print();
    }
} 
