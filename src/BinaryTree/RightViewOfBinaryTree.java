package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-right-side-view/

public class RightViewOfBinaryTree {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Iterative Solution
    // for left view add the last element of each level to the list.
    // Time Complexity: O(N)
    // Space Complexiyt: O(N)
    class IterativeTree {
        //Function to return list containing elements of left view of binary tree.
        ArrayList<Integer> rightView(Node root) {
            // Your code here
            ArrayList<Integer>list = new ArrayList<>();
            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty()) {
                int size = q.size();
                for(int i=0; i<size; i++) {
                    Node node = q.poll();
                    //last element at each level
                    if(i == size-1) {
                        list.add(node.data);
                    }

                    if(node.left != null) {
                        q.add(node.left);
                    }
                    if(node.right != null) {
                        q.add(node.right);
                    }
                }
            }
            return list;
        }
    }



    // Recursive Solution
    // At every level add the first element while traversing right first which is when the level number is equal to the size of the list until now.
    // Time Complexity: O(N)
    // Space Complexity: O(H)  (better)
    class RecursiveTree {
        //Function to return list containing elements of left view of binary tree.
        ArrayList<Integer> rightView(LeftViewOfBinaryTree.Node root) {
            // Your code here
            ArrayList<Integer>list = new ArrayList<>();
            right(list, 0, root);
            return list;
        }

        private void right(ArrayList<Integer>list, int level, LeftViewOfBinaryTree.Node node) {
            if(node == null)
                return;

            if(level == list.size())
                list.add(node.data);

            right(list, level+1, node.right);
            right(list, level+1, node.left);
        }
    }
}
