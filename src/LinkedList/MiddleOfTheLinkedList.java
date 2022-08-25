package LinkedList;

// https://leetcode.com/problems/middle-of-the-linked-list/submissions/
// Using fast and slow pointers
// Time Complexity: O(N)
// Space Complexity: O(1)

public class MiddleOfTheLinkedList {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode middleNode(ListNode head) {
            if(head == null)
                return head;

            ListNode fast = head;
            ListNode slow = head;

            while(fast!=null && fast.next!=null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            return slow;
        }
    }
}
