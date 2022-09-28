package BinaryTree;

// Using morris traversal

public class BinaryTreeToDoublyLinkedList {
     class BinaryTreeNode<T> {
     T data;
     BinaryTreeNode<T> left;
     BinaryTreeNode<T> right;

     public BinaryTreeNode(T data) {
     this.data = data;
     }
     }


    public class Solution {

        public BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
            // Write your code here
            BinaryTreeNode<Integer> dummy = new BinaryTreeNode<Integer>(-1);
            BinaryTreeNode<Integer> prev = dummy;
            BinaryTreeNode<Integer> curr = root;

            while(curr != null) {
                if(curr.left == null) {
                    prev.right = curr;
                    curr.left = prev;
                    prev = curr;
                    curr = curr.right;
                } else {
                    BinaryTreeNode<Integer> p = curr.left;
                    while(p.right!=null && p.right!=curr)
                        p = p.right;

                    if(p.right == null) {
                        p.right = curr;
                        curr = curr.left;
                    }

                    if(p.right == curr) {
                        p.right = null;
                        prev.right = curr;
                        curr.left = prev;
                        prev = curr;
                        curr = curr.right;
                    }
                }
            }

            return dummy.right;
        }


    }
}
