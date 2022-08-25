package LinkedList;

// https://leetcode.com/problems/reverse-linked-list/
// Using Three pointers, Keep changing the links and move the pointer.
// Time Complexity: O(N)
// Space Complexity: O(1)

public class ReverseLinkedList {


     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode reverseList(ListNode head) {
            if(head == null)
                return head;

            ListNode curr = head;
            ListNode prev = null;
            ListNode next = null;

            while(curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            head = prev;
            return head;
        }
    }
}
