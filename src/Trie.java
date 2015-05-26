
import java.util.HashMap;
import java.util.Map;

class TrieNode {

    boolean isWordEnd;
    Map<Character, TrieNode> children;

    // Initialize your data structure here.
    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
    }
}

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] s = word.toCharArray();
        TrieNode p = root;
        int i = 0;
        int n = s.length;

        // travers existing
        while (i < n) {
            TrieNode next = p.children.get(s[i]);
            if (next != null) {
                p = next;
                i++;
            } else {
                break;
            }
        }

        // append new nodes
        while (i < n) {
            TrieNode newTrie = new TrieNode();
            p.children.put(s[i], newTrie);
            p = newTrie;
            i = i + 1;
        }

        // set word end
        p.isWordEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p = find(root, word);
        return p != null && p.isWordEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p = find(root, prefix);
        return p != null;
    }

    TrieNode find(TrieNode root, String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode child = p.children.get(c);
            if (child == null) {
                return null;
            } else {
                p = child;
            }
        }
        return p;
    }
}
