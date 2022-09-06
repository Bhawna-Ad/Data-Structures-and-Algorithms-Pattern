package BinaryTree;

import java.util.*;
// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
// Time Complexity: O(N*logN*logN*logN)
// Space Complexity: O(N)

public class VerticalOrderTraversal {
    public class TreeNode {
         int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if(root == null)
                return ans;

            Queue<Tuple> q = new LinkedList<>();
            Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
            q.add(new Tuple(root, 0, 0));

            while(!q.isEmpty()) {
                Tuple temp = q.poll();
                TreeNode node = temp.node;
                int x = temp.row;
                int y = temp.col;

                if(!map.containsKey(x))
                    map.put(x, new TreeMap<>());

                if(!map.get(x).containsKey(y))
                    map.get(x).put(y, new PriorityQueue<>());

                map.get(x).get(y).add(node.val);

                if(node.left != null) {
                    q.add(new Tuple(node.left, x-1, y+1));
                }

                if(node.right != null) {
                    q.add(new Tuple(node.right, x+1, y+1));
                }

            }

            for(Map<Integer, PriorityQueue<Integer>> entry : map.values()) {
                ans.add(new ArrayList<>());
                for(PriorityQueue<Integer>nodes: entry.values()) {
                    while(!nodes.isEmpty())
                        ans.get(ans.size()-1).add(nodes.poll());
                }
            }

            return ans;
        }

        class Tuple {
            TreeNode node;
            int row;
            int col;
            Tuple(TreeNode node, int row, int col) {
                this.node = node;
                this.row = row;
                this.col = col;
            }
        }
    }
}
