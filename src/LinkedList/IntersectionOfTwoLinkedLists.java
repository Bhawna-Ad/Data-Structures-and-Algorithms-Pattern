package LinkedList;

// https://leetcode.com/problems/intersection-of-two-linked-lists/
// Using two pointers
// Keep interchanging the pointers every time one of them becomes null until both point to the same node.
// Time Complexiyt: O(M+N)
// Space Complexity: O(1)

public class IntersectionOfTwoLinkedLists {
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode a = headA;
            ListNode b = headB;

            while(a != b) {
                a = a==null ? headB:a.next;
                b = b==null ? headA:b.next;
            }

            return a;
        }
    }
}
