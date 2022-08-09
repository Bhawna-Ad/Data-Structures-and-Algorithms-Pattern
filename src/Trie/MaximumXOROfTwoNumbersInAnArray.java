package Trie;
/**/

//https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
//Time Complexity: O(N*32) + O(M*32)
//Space Complexity: O(N*32)
public class MaximumXOROfTwoNumbersInAnArray {
    class Solution {
        class Trie {
            Node root;
            class Node {
                Node[] links;
                Node() {
                    this.links = new Node[2];
                }

                void put(int index, Node node) {
                    links[index] = node;
                }

                Node get(int index) {
                    return links[index];
                }

                Boolean contains(int bit) {
                    return links[bit]!=null;
                }
            }

            Trie() {
                this.root = new Node();
            }

            void insert(int num) {
                Node node = root;
                for(int i=31; i>=0; i--) {
                    int bit = (num>>i)&1;
                    if(!node.contains(bit))
                        node.put(bit, new Node());
                    node = node.get(bit);
                }
            }

            int getMax(int num) {
                Node node = root;
                int maxNum = 0;
                for(int i=31; i>=0; i--) {
                    int bit = (num>>i) & 1;
                    if(node.contains(1-bit)) {
                        maxNum = maxNum | (1<<i);
                        node = node.get(1-bit);
                    } else
                        node = node.get(bit);
                }

                return maxNum;
            }
        }
        public int findMaximumXOR(int[] nums) {
            Trie trie = new Trie();
            for(int num: nums)
                trie.insert(num);

            int maxx = 0;
            for(int num: nums) {
                maxx = Math.max(maxx, trie.getMax(num));
            }

            return maxx;
        }
    }
}
