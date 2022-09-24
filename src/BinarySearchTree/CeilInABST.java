package BinarySearchTree;

// https://www.codingninjas.com/codestudio/problems/ceil-from-bst_920464

public class CeilInABST {

    class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public class Solution {
        public static int findCeil(TreeNode<Integer> node, int x) {
            // Write your code here
            int ceil = -1;
            while (node != null) {
                if (node.data >= x) {
                    ceil = node.data;
                    node = node.left;
                } else {
                    node = node.right;
                }
            }

            return ceil;
        }
    }

}
