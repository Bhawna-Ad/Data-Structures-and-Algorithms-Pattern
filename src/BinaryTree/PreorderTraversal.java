package BinaryTree;

// https://leetcode.com/problems/binary-tree-preorder-traversal/
// Time Complexity: O(N)

import java.util.Stack;

public class PreorderTraversal {
    private class Node {
        int val;
        Node left;
        Node right;
        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    private void recursivePreorder(Node node) {
        if(node == null)
            return;

        System.out.println(node.val);
        recursivePreorder(node.left);
        recursivePreorder(node.right);
    }

    // Using stack
    private void iterativePreorder(Node root) {
        Stack<Node>s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node top = s.pop();
            System.out.println(top.val);
            if(top.right != null)
                s.push(top.right);
            if(top.left != null)
                s.push(top.left);
        }
    }
}
