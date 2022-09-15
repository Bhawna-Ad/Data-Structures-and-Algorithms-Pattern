package BinaryTree;

// https://leetcode.com/problems/diameter-of-binary-tree/
// The diameter is the length of the longest path between any two nodes in the tree not necessarily passing through the root node.
// Time Complexity: O(N)
// Space Complexity: O(N)

public class DiameterOfABinaryTree {

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
        public int diameterOfBinaryTree(TreeNode root) {
            int[] diameter = new int[1];
            dfs(root, diameter);
            return diameter[0];
        }

        private int dfs(TreeNode node, int[] diameter) {
            if(node == null)
                return 0;

            int left = dfs(node.left, diameter);
            int right = dfs(node.right, diameter);

            diameter[0] = Math.max(diameter[0], left+right);
            return 1 + Math.max(left, right);
        }
    }
}
