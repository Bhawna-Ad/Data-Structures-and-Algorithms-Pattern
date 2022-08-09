package Trie;

//https://www.codingninjas.com/codestudio/problems/complete-string_2687860
//Time Complexity: Exponential
//Space Complexity: Exponential
public class CompleteString {

    class Solution {
        private static class Trie {
            private Node root;
            private class Node {
                Node[] links;
                Boolean flag;
                Node() {
                    this.links = new Node[26];
                    this.flag = false;
                }

                Boolean contains(char ch) {
                    return links[ch-'a'] != null;
                }

                void put(char ch, Node node) {
                    links[ch-'a'] = node;
                }

                Node get(char ch) {
                    return links[ch-'a'];
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

            Boolean checkIfPrefixExists(String word) {
                Boolean flag = true;
                Node node = root;
                for(int i=0; i<word.length() && flag; i++) {
                    if(!node.contains(word.charAt(i)))
                        return false;
                    node = node.get(word.charAt(i));
                    flag = flag & node.flag;
                }

                return flag;
            }
        }

        public static String completeString(int n, String[] a) {
            // Write your code here.
            Trie trie = new Trie();
            for(String s: a) {
                trie.insert(s);
            }

            String longest = "";
            for(String s: a) {
                if(trie.checkIfPrefixExists(s)) {
                    if(longest.length() < s.length())
                        longest = s;
                    else if(s.length()==longest.length() && s.compareTo(longest)<0)
                        longest = s;
                }
            }

            return longest=="" ? "None" : longest;

        }
    }
}
