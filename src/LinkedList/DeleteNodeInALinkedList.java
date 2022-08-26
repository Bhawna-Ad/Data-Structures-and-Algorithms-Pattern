package LinkedList;

// https://leetcode.com/problems/delete-node-in-a-linked-list/
// Shift the nodes.
// Time Complexity: O(1)
// Space Complexity: O(1)

public class DeleteNodeInALinkedList {

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }

    class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
