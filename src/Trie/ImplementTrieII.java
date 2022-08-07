package Trie;

public class ImplementTrieII {
    public class Trie {
        private Node root;
        private class Node {
            Node[] links;
            int word_count;
            int prefix_count;

            Node() {
                this.links = new Node[26];
                this.word_count = 0;
                this.prefix_count = 0;
            }

            Boolean contains(char ch) {
                return links[ch - 'a'] != null;
            }

            void put(char ch, Node node) {
                links[ch - 'a'] = node;
            }

            Node get(char ch) {
                return links[ch - 'a'];
            }
        }
        public Trie() {
            // Write your code here.
            this.root = new Node();
        }

        public void insert(String word) {
            // Write your code here.
            Node node = root;
            for(int i=0; i<word.length(); i++) {
                if(!node.contains(word.charAt(i)))
                    node.put(word.charAt(i), new Node());
                node = node.get(word.charAt(i));
                node.prefix_count++;
            }
            node.word_count++;
        }

        public int countWordsEqualTo(String word) {
            // Write your code here.
            Node node = root;
            for(int i=0; i<word.length(); i++) {
                if(!node.contains(word.charAt(i)))
                    return 0;
                node = node.get(word.charAt(i));
            }

            return node.word_count;
        }

        public int countWordsStartingWith(String word) {
            // Write your code here.
            Node node = root;
            for(int i=0; i<word.length(); i++) {
                if(!node.contains(word.charAt(i)))
                    return 0;
                node = node.get(word.charAt(i));
            }

            return node.prefix_count;
        }

        public void erase(String word) {
            // Write your code here.
            Node node = root;
            for(int i=0; i<word.length(); i++) {
                if(!node.contains(word.charAt(i)))
                    return;
                node = node.get(word.charAt(i));
                node.prefix_count--;
            }
            node.word_count--;
        }

    }
}
