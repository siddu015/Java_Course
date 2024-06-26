package DSA_Java;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Tries {
    private int numberOfWords;

    private static class Node {
        private final char value;
        private final Hashtable<Character, Node> children = new Hashtable<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public void removeChild(char ch){
            children.remove(ch);
        }

    }

    private final Node root = new Node(' ');

    public void insert(String word) {
        var current = root;
        for (var ch: word.toCharArray()) {
            if(!current.hasChild(ch))
                current.addChild(ch);
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;

        numberOfWords++;
    }

    public boolean contains(String word) {
        if(word == null)
            return false;

        var current = root;
        for(var ch: word.toCharArray()) {
            if(!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public boolean containsRecursive(String word) {
        if(word == null)
            return false;

        return containsRecursive(root, word, 0);
    }

    private boolean containsRecursive(Node root, String word, int index) {
        if(index == word.length()) {
            return root.isEndOfWord;
        }

        var ch = word.charAt(index);
        if(!root.hasChild(ch))
            return false;

        var child = root.getChild(ch);
        return containsRecursive(child, word, index + 1);
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(Node root) {
        System.out.println(root.value);

        for(var child: root.getChildren())
            traverse(child);
    }

    public void remove(String word) {
        if (word == null)
            return;
        remove(root, word, 0);
    }

    private void remove(Node root, String word, int index) {
        if(index == word.length()) {
            root.isEndOfWord = false;
            numberOfWords--;
            return;
        }

        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if(child == null)
            return;

        remove(child, word, index + 1);

        if(!child.hasChildren() && !child.isEndOfWord){
            root.removeChild(ch);
        }
    }

    public List<String> findWords(String prefix) {
        List<String> words = new ArrayList<>();
        var lastNode = findLastNodeOf(prefix);
        findWords(lastNode, prefix, words);

        return words;
    }

    private void findWords(Node root, String prefix, List<String> words) {
        if(root == null)
            return;

        if(root.isEndOfWord)
            words.add(prefix);

        for(var child: root.getChildren())
            findWords(child, prefix + child.value, words);
    }

    private Node findLastNodeOf(String prefix) {
        if(prefix == null)
            return null;

        var current = root;
        for(var ch: prefix.toCharArray()) {
            var child = current.getChild(ch);
            if(child == null)
                return null;
            current = child;
        }
        return current;
    }

    public int countWords(){
        return numberOfWords;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        var trie = new Tries();
        for (String str : strs) {
            if(str == null)
                return "";
            trie.insert(str); // Insert all strings into the trie
        }

        return longestCommonPrefix(trie.root);

    }

    private String longestCommonPrefix(Node root) {
        Node current = root;
        StringBuilder prefix = new StringBuilder();

        while (current.children.size() == 1 && !current.isEndOfWord) {
            var ch = current.getChildren()[0].value;
            prefix.append(ch);
            current = current.getChild(ch);
        }

        return prefix.toString();
    }
}
