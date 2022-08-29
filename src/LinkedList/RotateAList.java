package LinkedList;

// https://leetcode.com/problems/rotate-list/description/
// Time Complexity: O(N)
// Space Complexity: O(1)

public class RotateAList {
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if(head==null || head.next==null)
                return head;
            int length = 0;
            ListNode tail = head;
            while(tail.next != null) {
                length++;
                tail = tail.next;
            }
            length++;

            tail.next = head;
            tail = head;
            length = length - (k%length);
            while(length > 1) {
                tail = tail.next;
                length--;
            }

            head = tail.next;
            tail.next = null;
            return head;
        }
    }
}
