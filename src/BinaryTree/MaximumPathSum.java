package BinaryTree;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/
// At every node compare the max with the sum of that node's value, left value and right value.
// Time Complexity: O(N)
// Space Complexity: O(N)

public class MaximumPathSum {
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
        private int maxx;
        public int maxPathSum(TreeNode root) {
            maxx = Integer.MIN_VALUE;
            dfs(root);
            return maxx;
        }

        private int dfs(TreeNode node) {
            if(node == null)
                return 0;

            // We compare for the max value since we have to neglect the nodes with a negative value.
            // For eg :
            //          30
            //        /    \
            //     -21      -20
            int left = Math.max(0, dfs(node.left));
            int right = Math.max(0, dfs(node.right));

            maxx = Math.max(maxx, left+right+node.val);

            return node.val + Math.max(left, right);
        }
    }
}
