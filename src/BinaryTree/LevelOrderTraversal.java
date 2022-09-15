package BinaryTree;

// https://leetcode.com/problems/binary-tree-level-order-traversal/
// Time Complexity: O(N)
// Space Complexity: O(N)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>>ans = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty()) {
                int size = q.size();
                List<Integer>nodes = new ArrayList<>();
                for(int i=0; i<size; i++) {
                    TreeNode node = q.poll();
                    nodes.add(node.val);

                    if(node.left != null)
                        q.add(node.left);

                    if(node.right != null)
                        q.add(node.right);
                }
                ans.add(nodes);
            }

            return ans;
        }
    }
}
