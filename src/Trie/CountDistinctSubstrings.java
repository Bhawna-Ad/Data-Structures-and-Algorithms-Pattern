package Trie;

public class CountDistinctSubstrings {

    public class Solution
    {

        private static class Node {
            Node[] links;
            Node() {
                this.links = new Node[26];
            }

            Boolean contains(char ch) {
                return links[ch-'a']!=null;
            }

            void put(char ch, Node node) {
                links[ch-'a'] = node;
            }

            Node get(char ch) {
                return links[ch-'a'];
            }
        }


        public static int countDistinctSubstrings(String s)
        {
            //	  Write your code here.
            Node root = new Node();
            int count = 0;

            for(int i=0; i<s.length(); i++) {
                Node node = root;
                for(int j=i; j<s.length(); j++) {
                    if(!node.contains(s.charAt(j))) {
                        count++;
                        node.put(s.charAt(j), new Node());
                    }
                    node = node.get(s.charAt(j));
                }
            }
            return count + 1;
        }
    }
}