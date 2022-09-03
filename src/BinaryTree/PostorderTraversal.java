package BinaryTree;

// https://leetcode.com/problems/binary-tree-postorder-traversal/

import java.util.Stack;

public class PostorderTraversal {
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
    private void recursivePostorder(Node node) {
        if (node == null)
            return;

        recursivePostorder(node.left);
        recursivePostorder(node.right);
        System.out.println(node.val);
    }

    // Using two stacks
    private void iterativePreorder(Node node) {
        Stack<Node>s1 = new Stack<>();
        Stack<Node>s2 = new Stack<>();
        s1.push(node);
        while (!s1.isEmpty()) {
            node = s1.pop();
            s2.push(node);

            if(node.left != null)
                s1.push(node.left);
            if(node.right != null)
                s1.push(node.right);
        }

        while (!s2.isEmpty()){
            System.out.println(s2.pop());
        }
    }
}
