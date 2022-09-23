package BinarySearchTree;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

public class ConstructBSTFromGivenKeys {
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
        public TreeNode sortedArrayToBST(int[] nums) {
            if(nums.length == 0)
                return null;

            return buildTree(nums, 0, nums.length-1);
        }

        private TreeNode buildTree(int[] nums, int low, int high) {
            if(low > high)
                return null;

            int mid = (low+high)/2;

            TreeNode node = new TreeNode(nums[mid]);
            node.left = buildTree(nums, low, mid-1);
            node.right = buildTree(nums, mid+1, high);

            return node;
        }
    }
}
