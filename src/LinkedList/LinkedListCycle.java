package LinkedList;

// https://leetcode.com/problems/linked-list-cycle/
// Using fast and slow pointers
// If the two pointers meet then there is a cycle present false otherwise.
// Time Complexity: O(N)
// Space Complexity: O(1)

public class LinkedListCycle {
      class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if(head == null)
                return false;

            ListNode fast = head;
            ListNode slow = head;

            while(fast!=null && fast.next!=null) {
                fast = fast.next.next;
                slow = slow.next;

                if(fast == slow)
                    return true;
            }

            return false;
        }
    }
}
