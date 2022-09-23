package BinaryTree;

// https://www.codingninjas.com/codestudio/problems/childrensumproperty_790723
// If the children sum is greater than the root value then assign the children sum to the root.
// If the children sum is lesser than the root value then assign each children the value same as the root.
// Do the process twice once moving down in the tree and once moving up the tree.

public class ChildrenSumProperty {


     class BinaryTreeNode < Integer > {
         int data;
         BinaryTreeNode < Integer > left;
         BinaryTreeNode < Integer > right;

         public BinaryTreeNode(int data) {
         this.data = data;
        }
     }


    public class Solution {
        public static void changeTree(BinaryTreeNode < Integer > root) {
            // Write your code here.
            if(root == null)
                return;

            int child = 0;
            if(root.left != null)
                child += root.left.data;
            if(root.right != null)
                child += root.right.data;

            if(child >= root.data) {
                root.data = child;
            } else {
                if(root.left != null)
                    root.left.data = root.data;
                if(root.right != null)
                    root.right.data = root.data;
            }

            changeTree(root.left);
            changeTree(root.right);

            int tot = 0;
            if(root.left != null)
                tot += root.left.data;
            if(root.right != null)
                tot += root.right.data;
            if(root.left!=null || root.right!=null)
                root.data = tot;
        }
    }
}
