package BinarySearchTree;

import java.util.Stack;

// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
// We will use a BST iterator to iterate over the tree and using binary search we will find the elements.
// Time Complexity: O(N)
// Space Complexity: O(H)*2

public class TwoSumIV {
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
        private class BSTIterator {
            Stack<TreeNode> st;
            boolean isReverse;
            public BSTIterator(TreeNode root, boolean isReverse) {
                this.st = new Stack<>();
                this.isReverse = isReverse;
                pushAll(root);
            }

            public int next() {
                TreeNode node = st.pop();
                if(!isReverse)
                    pushAll(node.right);
                else
                    pushAll(node.left);

                return node.val;
            }

            public boolean hasNext() {
                return !st.isEmpty();
            }

            private void pushAll(TreeNode node) {
                while(node != null) {
                    st.push(node);
                    if(isReverse) {
                        node = node.right;
                    } else {
                        node = node.left;
                    }
                }
            }
        }
        public boolean findTarget(TreeNode root, int k) {
            if(root == null)
                return false;

            BSTIterator l = new BSTIterator(root, false);
            BSTIterator h = new BSTIterator(root, true);

            int low = l.next();
            int high = h.next();

            while(low < high) {
                int sum = low + high;
                if(sum == k)
                    return true;
                else if(sum < k) {
                    if(l.hasNext())
                        low = l.next();
                    else
                        return false;
                }
                else{
                    if(h.hasNext())
                        high = h.next();
                    else
                        return false;
                }
            }

            return false;
        }
    }
}
