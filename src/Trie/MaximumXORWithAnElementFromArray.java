package Trie;
import java.util.*;
/**/
public class MaximumXORWithAnElementFromArray {
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

        public int[] maximizeXor(int[] nums, int[][] q) {
            int n = nums.length;
            int idx=0;
            Trie root = new Trie();
            int[][] queries = new int[q.length][3];

            for(int i=0;i<q.length;++i){
                queries[i][0] = q[i][0];
                queries[i][1] = q[i][1];
                queries[i][2] = i;
            }

            int[] ans = new int[queries.length];
            Arrays.sort(nums);
            Arrays.sort(queries, (o1, o2) -> o1[1]-o2[1]);


            for(int i=0;i<queries.length;++i){

                while(idx<n && nums[idx]<=queries[i][1]){
                    root.insert(nums[idx]);
                    idx++;
                }
                if(nums[0]>queries[i][1])
                    ans[queries[i][2]] = -1;
                else
                    ans[queries[i][2]] = root.getMax(queries[i][0]);
            }

            return ans;

        }
    }
}
