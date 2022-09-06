package BinaryTree;

// https://leetcode.com/problems/maximum-width-of-binary-tree/

import com.sun.source.tree.Tree;

import java.util.*;

public class SingleTraversal {
    private class Pair {
        TreeNode node;
        int line;
        Pair(TreeNode node, int line) {
            this.node = node;
            this.line = line;
        }
    }

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
        public int widthOfBinaryTree(TreeNode root) {
            if(root == null)
                return 0;
            Queue<Pair>q = new LinkedList<>();
            int ans = 0;
            q.offer(new Pair(root, 0));

            while(!q.isEmpty()) {
                int size = q.size();
                int min = q.peek().line;
                int first = 0;
                int last = 0;
                for(int i=0; i<size; i++) {
                    TreeNode node = q.peek().node;
                    int index = q.peek().line-min;
                    q.poll();

                    if(i==0)
                        first = index;
                    if(i==size-1)
                        last = index;

                    if(node.left != null)
                        q.offer(new Pair(node.left, 2*index+1));
                    if(node.right != null)
                        q.offer(new Pair(node.right, 2*index+2));
                }
                ans = Math.max(ans, last-first+1);
            }
            return ans;
        }
    }
}
