package BinaryTree;

import java.util.Stack;

// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

public class FlattenBinaryTreeToLinkedList {

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

      // Stack solution
    // We just need to put right node in the stack first and then left node.
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    class StackSolution {
        public void flatten(TreeNode root) {
            if(root == null)
                return;

            TreeNode sentinel = new TreeNode();
            TreeNode curr = sentinel;

            Stack<TreeNode> st = new Stack<>();
            st.push(root);

            while(!st.isEmpty()) {
                TreeNode node = st.pop();

                if(node.right != null)
                    st.push(node.right);

                if(node.left != null)
                    st.push(node.left);

                curr.right = node;
                curr.left = null;
                curr = curr.right;
            }

            root = sentinel.right;
        }
    }

    // Morris Traversal Solution
    // For each node, find the extreme right element of the left subtree and change its right as the right of the current node.
    // Change the right of the current node to left part of the same node.
    // Make the left node null.
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    class Solution {
        public void flatten(TreeNode root) {
            TreeNode curr = root;

            while(curr != null) {
                if(curr.left != null) {
                    TreeNode prev = curr.left;
                    while(prev.right != null)
                        prev = prev.right;

                    prev.right = curr.right;
                    curr.right = curr.left;
                    curr.left = null;
                }

                curr = curr.right;
            }
        }
    }
}
