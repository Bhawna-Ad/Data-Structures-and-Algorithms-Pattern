package LinkedList;

// https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1
// Time Complexity: O(N)
// Space Complexity: O(1)

public class FlatteningALinkedList {
    class Node
    {
        int data;
        Node next;
        Node bottom;

        Node(int d)
        {
            data = d;
            next = null;
            bottom = null;
        }
    }

/*  Function which returns the  root of
    the flattened linked list. */
    class GfG {
        Node flatten(Node root) {
            // Your code here
            if(root == null || root.next == null) {
                return root;
            }

            root.next = flatten(root.next);
            root = mergeTwoLinkedLists(root, root.next);

            return root;
        }

        private Node mergeTwoLinkedLists(Node a, Node b) {
            Node head = new Node(0);
            Node temp = head;

            while(a!=null && b!=null) {
                if(a.data < b.data) {
                    temp.bottom = a;
                    temp = temp.bottom;
                    a = a.bottom;
                } else {
                    temp.bottom = b;
                    temp = temp.bottom;
                    b = b.bottom;
                }
            }

            if(a != null) temp.bottom = a;
            else temp.bottom = b;
            return head.bottom;
        }
    }
}
