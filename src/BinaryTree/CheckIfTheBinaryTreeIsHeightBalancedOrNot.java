package BinaryTree;

// height(left) - height(right) <= 1

public class CheckIfTheBinaryTreeIsHeightBalancedOrNot {

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
        public boolean isBalanced(TreeNode root) {
            return dfs(root) != -1;
        }

        private int dfs(TreeNode node) {
            if(node == null)
                return 0;

            int left = dfs(node.left);
            int right = dfs(node.right);

            if(left==-1 || right==-1)
                return -1;

            if(Math.abs(right-left) > 1)
                return -1;

            return 1+Math.max(left, right);
        }
    }
}
