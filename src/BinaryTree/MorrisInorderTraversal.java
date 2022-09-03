package BinaryTree;

// https://leetcode.com/problems/binary-tree-inorder-traversal/
// Time Complexity: O(N)
// Space Complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer>list = new ArrayList<>();
            while(root != null) {
                if(root.left == null) {
                    list.add(root.val);
                    root = root.right;
                } else {
                    TreeNode prev = root.left;
                    while(prev.right!=null && prev.right!=root)
                        prev = prev.right;
                    if(prev.right == null) {
                        prev.right = root;
                        root = root.left;
                    } else {
                        prev.right = null;
                        list.add(root.val);
                        root = root.right;
                    }
                }
            }
            return list;
        }
    }
}

