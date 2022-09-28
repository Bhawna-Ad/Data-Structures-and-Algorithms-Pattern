package BinarySearchTree;

// https://leetcode.com/problems/binary-search-tree-iterator/
// Using a stack start pushing from the left.

import java.util.Stack;

public class BSTIterator {
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

    class BSTIteratorSolution {
        Stack<TreeNode> st;
        public BSTIteratorSolution(TreeNode root) {
            this.st = new Stack<>();
            pushAll(root);
        }

        public int next() {
            TreeNode node = st.pop();
            pushAll(node.right);
            return node.val;
        }

        public boolean hasNext() {
            return !st.isEmpty();
        }

        private void pushAll(TreeNode root) {
            while(root != null) {
                st.push(root);
                root = root.left;
            }
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
