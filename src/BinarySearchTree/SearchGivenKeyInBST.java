package BinarySearchTree;

// https://leetcode.com/problems/search-in-a-binary-search-tree/

public class SearchGivenKeyInBST {

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
        public TreeNode searchBST(TreeNode root, int val) {
            TreeNode node = root;
            while(node != null) {
                if(node.val < val)
                    node = node.right;
                else if(node.val > val)
                    node = node.left;
                else
                    return node;
            }

            return null;
        }
    }
}
