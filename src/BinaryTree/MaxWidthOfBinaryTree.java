package BinaryTree;

// Use level order traversal
// Formula = first_index - last_index + 1
// For a node (i) in 0-based indexing:
//  left child = 2i+1
//  right child = 2i+2
// Time Complexity: O(N)
// Space Complexity: O(N)

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBinaryTree {

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
        private class Pair {
            TreeNode node;
            int index;
            Pair(TreeNode node, int index) {
                this.node = node;
                this.index = index;
            }
        }
        public int widthOfBinaryTree(TreeNode root) {
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(root, 0));
            int ans = 0;

            while(!q.isEmpty()) {
                int size = q.size();
                int last = 0;
                int first = 0;

                for(int i=0; i<size; i++) {
                    Pair p = q.poll();
                    int index = p.index;

                    if(i == 0)
                        first = index;
                    if(i == size-1)
                        last = index;

                    if(p.node.left != null)
                        q.add(new Pair(p.node.left, 2*index + 1));
                    if(p.node.right != null)
                        q.add(new Pair(p.node.right, 2*index + 2));
                }
                ans = Math.max(ans, last-first+1);
            }

            return ans;
        }
    }
}
