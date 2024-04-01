package DSA_Java;


public record Main() {
    public static void main(String[] args) {
        var trie = new Tries();
        trie.insert("mat");
        trie.insert("mate");
        trie.insert("mates");
        trie.insert("hello");
        trie.insert("meter");
        trie.insert("metric");
        trie.insert("egg");
        trie.insert("match");
        trie.insert("manipulated");
        trie.insert("munching");
        trie.insert("drinking");
        trie.insert("mating");
        trie.insert("murmuring");

        String[] str =  {null, null};
        System.out.println(trie.longestCommonPrefix(str));

    }
} 
