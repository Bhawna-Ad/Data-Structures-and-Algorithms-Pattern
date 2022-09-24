package BinarySearchTree;

// https://www.codingninjas.com/codestudio/problems/floor-from-bst_920457

public class FloorInBST {
    class TreeNode<T>
    {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

    public class Solution {

        public static int floorInBST(TreeNode<Integer> root, int X) {
            //    Write your code here.
            int floor = -1;
            while(root != null) {
                if(root.data <= X) {
                    floor = root.data;
                    root = root.right;
                } else {
                    root = root.left;
                }
            }

            return floor;
        }
    }
}
