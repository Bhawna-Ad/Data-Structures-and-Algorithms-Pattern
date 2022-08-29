package LinkedList;

// https://leetcode.com/problems/copy-list-with-random-pointer/
// Time Complexity: O(N) + O(N) + O(N)
// Space Complexity: O(N)

public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /*
    Without using extra space
    1. create copy nodes and insert them after the original ones.
    2. create a copy of random pointers.
    3. remove the links not needed.
    */

    class Solution {
        public Node copyRandomList(Node head) {
            //create copy nodes
            Node p = head;
            while(p != null) {
                Node temp = new Node(p.val);
                temp.next = p.next;
                p.next = temp;
                p = p.next.next;
            }

            //copy of random pointers
            p = head;
            while(p != null) {
                if(p.random!=null)
                    p.next.random = p.random.next;
                p = p.next.next;
            }

            //Separating both the lists
            Node dummy = new Node(0);
            Node prev = head;
            Node copy = dummy;
            Node curr = null;

            while(prev != null) {
                curr = prev.next.next;
                copy.next = prev.next;
                copy = copy.next;

                prev.next = curr;
                prev = prev.next;
            }
            return dummy=dummy.next;
        }
    }
}
