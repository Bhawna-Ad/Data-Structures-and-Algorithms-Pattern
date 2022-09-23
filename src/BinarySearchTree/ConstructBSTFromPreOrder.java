package BinarySearchTree;

// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
// Set an upper bound and create the nodes.
// We do not need inorder traversal since we are setting an upper bound.
// Time Complexity: O(N)
// Space Complexity: O(N)

public class ConstructBSTFromPreOrder {
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
        private int index = 0;
        public TreeNode bstFromPreorder(int[] preorder) {
            if(preorder.length == 0)
                return null;

            return buildTree(preorder, Integer.MAX_VALUE);
        }

        private TreeNode buildTree(int[] preorder, int bound) {
            if(index == preorder.length)
                return null;

            if(preorder[index] > bound)
                return null;

            TreeNode node = new TreeNode(preorder[index++]);
            node.left = buildTree(preorder, node.val);
            node.right = buildTree(preorder, bound);

            return node;
        }
    }
}
