package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointers {

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

    // Solution using queue
    class QueueSolution {
        public Node connect(Node root) {
            if(root == null)
                return root;

            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty()) {
                int size = q.size();
                Node head = new Node(0);
                Node temp = head;
                for(int i=0; i<size; i++) {
                    temp.next = q.poll();
                    temp = temp.next;

                    if(temp.left != null)
                        q.add(temp.left);
                    if(temp.right != null)
                        q.add(temp.right);
                }
                temp.next = null;
                head.next = null;
            }
            return root;
        }
    }

    // Optimal Solution
    class Solution {
        public Node connect(Node root) {
            if(root == null)
                return root;

            Node curr = root;
            while(curr.left != null) {
                Node temp = curr;
                while(temp != null) {
                    if(temp.left != null)
                        temp.left.next = temp.right;
                    if(temp.next != null)
                        temp.right.next = temp.next.left;
                    temp = temp.next;
                }
                curr = curr.left;
            }

            return root;
        }
    }
}
