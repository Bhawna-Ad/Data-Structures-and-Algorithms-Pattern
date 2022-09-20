package BinaryTree;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>>ans = new ArrayList<>();
            if(root == null)
                return ans;

            Queue<TreeNode> q = new LinkedList<>();
            boolean leftToRight = true;
            q.add(root);

            while(!q.isEmpty()) {
                int n = q.size();
                List<Integer>list = new ArrayList<>();
                for(int i=0; i<n; i++) {
                    TreeNode node = q.poll();
                    if(node.left != null)
                        q.add(node.left);
                    if(node.right != null)
                        q.add(node.right);

                    if(leftToRight)
                        list.add(node.val);
                    else
                        list.add(0, node.val);
                }

                ans.add(list);
                leftToRight = !leftToRight;
            }

            return ans;
        }
    }
}
