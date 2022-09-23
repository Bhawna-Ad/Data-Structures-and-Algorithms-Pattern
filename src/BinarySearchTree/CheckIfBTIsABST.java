package BinarySearchTree;

// https://leetcode.com/problems/validate-binary-search-tree/
// For each node check if the value is in range or not.

public class CheckIfBTIsABST {
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
        public boolean isValidBST(TreeNode root) {
            return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean isValid(TreeNode node, long lower, long upper) {
            if(node == null)
                return true;

            if(lower > upper)
                return false;

            if(node.val <= lower || node.val >= upper)
                return false;

            return isValid(node.left, lower, node.val) && isValid(node.right, node.val, upper);
        }
    }
}
