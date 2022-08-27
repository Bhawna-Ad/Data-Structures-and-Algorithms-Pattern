package LinkedList;

// https://leetcode.com/problems/palindrome-linked-list/
// Find the middle using fast and slow pointers
// Reverse the rest of the linked list from the middle
// Using two pointers check if the linked list is palidromic.
// Time Complexity: O(N) + O(N) + O(N)
// Space Complexity: O(1)

public class PalindromeLinkedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while(fast.next!=null && fast.next.next!=null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            slow.next = reverseList(slow.next);
            slow = slow.next;

            while(slow != null) {
                if(head.val != slow.val)
                    return false;
                head = head.next;
                slow = slow.next;
            }

            return true;
        }

        private ListNode reverseList(ListNode head) {
            if(head == null)
                return null;

            ListNode prev = null;
            ListNode curr = head;
            ListNode next = null;

            while(curr != null) {
                next = curr.next;
                curr.next = prev;

                prev = curr;
                curr = next;
            }

            return prev;
        }
    }
}
