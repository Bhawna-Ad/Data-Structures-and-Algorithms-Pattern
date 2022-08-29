package LinkedList;

// https://leetcode.com/problems/linked-list-cycle-ii/
// Time Complexity: O(N)
// Space Complexity: O(1)

public class LinkedListCycleII {

      class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;

            while(fast!=null && fast.next!=null) {
                fast = fast.next.next;
                slow = slow.next;
                if(slow == fast) {
                    fast = head;
                    while(fast != slow) {
                        fast = fast.next;
                        slow = slow.next;
                    }
                    return fast;
                }
            }
            return null;
        }
    }
}
