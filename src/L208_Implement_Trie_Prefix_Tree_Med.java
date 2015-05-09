
import java.util.HashMap;
import java.util.Map;

public class L208_Implement_Trie_Prefix_Tree_Med {

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
                if (p.children.get(s[i]) != null) {
                    p = p.children.get(s[i]);
                    i++;
                } else {
                    break;
                }
            }

            // append new nodes
            while (i < n) {
                TrieNode newtrie = new TrieNode();
                p.children.put(s[i], newtrie);
                p = newtrie;
                i = i + 1;
            }
            
            p.isWordEnd = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode child = p.children.get(c);
                if (child == null) {
                    return false;
                } else {
                    p = child;
                }
            }
            return p.isWordEnd;
        }

    // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode p = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                TrieNode child = p.children.get(c);
                if (child == null) {
                    return false;
                } else {
                    p = child;
                }
            }
            return true;
        }
    }

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
}
