package BinaryTree;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// The order in inorder is Left Root Right and the order in preorder is Root Left Right
// So we are just going to consider the first element in preorder as root
// all the elements to the left of this element in inorder array will form the left part of the tree
// all the elements to the right of this element in inorder array will form the right part of the tree.
// Time Complexity: O(N)+O(N)
// Space Complexity: O(N)+O(N)+O(N)

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPreorder {
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for(int num: inorder)
                map.put(num, map.size());

            TreeNode root = build(preorder, map, 0, inorder.length-1);
            return root;
        }

        // Using index variable to iterate through preorder array.
        private int index = 0;

        private TreeNode build(int[] preorder, HashMap<Integer, Integer>map, int inStart, int inEnd) {
            if(inStart > inEnd)
                return null;

            // increment the index by 1 in each recursion call.
            int val = preorder[index++];
            TreeNode node = new TreeNode(val);

            // left part in inorder array.
            node.left = build(preorder, map, inStart, map.get(val)-1);
            // right part in inorder array.
            node.right = build(preorder, map, map.get(val)+1, inEnd);

            return node;
        }
    }
}
