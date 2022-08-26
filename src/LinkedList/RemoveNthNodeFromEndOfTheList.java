package LinkedList;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
// Using fast and slow pointers
// run the fast pointer until n
// Time Complexity: O(N)
// Space Complexity: O(1);

public class RemoveNthNodeFromEndOfTheList {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode node = new ListNode();
            node.next = head;
            ListNode fast = node;
            ListNode slow = node;

            for(int i=1; i<=n; i++)
                fast = fast.next;

            while(fast.next!=null) {
                fast = fast.next;
                slow = slow.next;
            }

            slow.next = slow.next.next;
            return node.next;
        }
    }
}
