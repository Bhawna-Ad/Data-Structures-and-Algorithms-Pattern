package BinaryTree;

// https://leetcode.com/problems/binary-tree-inorder-traversal/

import java.util.Stack;

public class InorderTraversal {
    public static void main(String[] args) {

    }
    class Node{
        int val;
        Node left;
        Node right;
        Node(int val, Node right, Node left) {
            this.val = val;
            this.right = right;
            this.left = left;
        }
    }

    // Time Complexity: O(N)
    private void recursiveInorder(Node node) {
        if(node == null)
            return;

        recursiveInorder(node.left);
        System.out.println(node.val);
        recursiveInorder(node.right);
    }

    // Using stack
    // Time Complexity: O(N)
    private void iterativeInorder(Node root) {
        Stack<Node>s = new Stack<>();
        while (true) {
            if(root!=null) {
                s.push(root);
                root = root.left;
            } else {
                if(s.isEmpty())
                    break;
                root = s.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }
}
