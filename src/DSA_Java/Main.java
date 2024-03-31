package DSA_Java;


public record Main() {
    public static void main(String[] args) {
        var trie = new Tries();
        trie.insert("mat");
        trie.insert("mate");
        trie.insert("mates");
        trie.insert("egg");
        trie.insert("match");
        trie.insert("manipulated");



        System.out.println(trie.findWords(""));

    }
} 
