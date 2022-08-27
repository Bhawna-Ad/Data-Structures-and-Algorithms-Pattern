package LinkedList;

// https://leetcode.com/problems/reverse-nodes-in-k-group/
// Time Complexity: O((N/K)*K) = O(N)
// Space Complexity: O(1)

public class ReverseNodesInKGroups {
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if(head == null || k == 1)
                return head;

            ListNode dummy = new ListNode();
            dummy.next = head;

            ListNode curr = dummy;
            ListNode prev = dummy;
            ListNode next = dummy;

            int count = 0;
            while(curr.next != null) {
                curr = curr.next;
                count++;
            }

            while(count >= k) {
                curr = prev.next;
                next = curr.next;
                for(int i=1; i<k; i++) {
                    curr.next = next.next;
                    next.next = prev.next;
                    prev.next = next;
                    next = curr.next;
                }

                prev = curr;
                count -= k;
            }

            return dummy.next;
        }
    }
}
