package BinarySearchTree;

// https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
// Time Complexity: O(N)
// Space Complexity: O(1)

public class MaximumSumBSTInBinaryTree {
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
        private int maxSum = 0;
        private class Tuple {
            int max;
            int min;
            int sum;
            Tuple(int max, int min, int sum) {
                this.max = max;
                this.min = min;
                this.sum = sum;
            }
        }

        public int maxSumBST(TreeNode root) {
            getLargestSum(root);
            return maxSum;
        }

        private Tuple getLargestSum(TreeNode root) {
            if(root == null)
                return new Tuple(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);

            Tuple left = getLargestSum(root.left);
            Tuple right = getLargestSum(root.right);

            if(left.max < root.val && root.val < right.min) {
                int sum = left.sum + right.sum + root.val;
                maxSum = Math.max(maxSum, sum);
                return new Tuple(Math.max(root.val, Math.max(left.max, right.max)),
                        Math.min(root.val, Math.min(left.min, right.min)),
                        sum);
            }

            return new Tuple(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.sum, right.sum));
        }
    }
}
