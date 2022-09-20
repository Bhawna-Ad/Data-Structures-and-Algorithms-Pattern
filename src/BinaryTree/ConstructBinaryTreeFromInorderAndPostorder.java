package BinaryTree;

// Build right part first and then left part of the tree.
// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
// Time Complexity: O(N)
// Space Complexity: O(N)

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorder {
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
        private int index;
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.index = postorder.length-1;
            HashMap<Integer, Integer>map = new HashMap<>();

            for(int num: inorder)
                map.put(num, map.size());

            TreeNode root = build(postorder, map, 0, inorder.length-1);
            return root;
        }

        private TreeNode build(int[] postorder, HashMap<Integer, Integer> map, int inStart, int inEnd) {
            if(inStart > inEnd || index<0)
                return null;

            int val = postorder[index--];
            TreeNode node = new TreeNode(val);


            node.right = build(postorder, map, map.get(val)+1, inEnd);
            node.left = build(postorder, map, inStart, map.get(val)-1);

            return node;
        }
    }
}
