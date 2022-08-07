package Trie;

public class ImplementTrie {
    class Trie {
        private Node root;

        private class Node {
            Node[] links;
            Boolean flag;
            Node() {
                this.links = new Node[26];
                this.flag = false;
            }

            boolean contains(char ch) {
                return links[ch-'a'] != null;
            }

            void put(char ch, Node node) {
                links[ch - 'a'] = node;
            }

            Node get(char ch) {
                return links[ch - 'a'];
            }

            void setEnd() {
                this.flag = true;
            }
        }

        public Trie() {
            this.root = new Node();
        }

        public void insert(String word) {
            Node node = root;
            for(int i=0; i<word.length(); i++) {
                if(!node.contains(word.charAt(i)))
                    node.put(word.charAt(i), new Node());

                node = node.get(word.charAt(i));
            }

            node.setEnd();
        }

        public boolean search(String word) {
            Node node = root;
            for(int i=0; i<word.length(); i++) {
                if(!node.contains(word.charAt(i)))
                    return false;

                node = node.get(word.charAt(i));
            }

            return node.flag == true;
        }

        public boolean startsWith(String prefix) {
            Node node = root;
            for(int i=0; i<prefix.length(); i++) {
                if(!node.contains(prefix.charAt(i)))
                    return false;
                node = node.get(prefix.charAt(i));
            }

            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
