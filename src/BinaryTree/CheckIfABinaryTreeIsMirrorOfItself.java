package BinaryTree;

import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/mirror-tree/1
// Using stack swap the nodes at each level.
// Time Complexity: O(N)
// Space Complexity: O(N)

public class CheckIfABinaryTreeIsMirrorOfItself {
    class Node
    {
        int data;
        Node left, right;
        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    class StackSolution {
        void mirror(Node root) {
            if(root == null) return;
            Stack<Node> st = new Stack<>();
            st.push(root);

            while(!st.isEmpty()) {
                Node node = st.pop();

                if(node.right != null) {
                    st.push(node.right);
                }

                if(node.left != null) {
                    st.push(node.left);
                }

                Node temp = node.right;
                node.right = node.left;
                node.left = temp;
            }
        }
    }
}
