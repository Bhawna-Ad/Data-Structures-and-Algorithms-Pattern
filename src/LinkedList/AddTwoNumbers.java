package LinkedList;

// https://leetcode.com/problems/add-two-numbers/submissions/
// Add three values to the variable sum:
// 1. value of l1
// 2. value of l2
// 3. carry (sum / 10)
// Time Complexity: O(N)
// Space Complexity: O(N)

public class AddTwoNumbers {
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode();
            ListNode temp = head;

            int carry = 0;
            while(l1!=null || l2!=null || carry>0) {
                int sum = 0;
                if(l1 != null) {
                    sum = sum + l1.val;
                    l1 = l1.next;
                }

                if(l2 != null) {
                    sum = sum + l2.val;
                    l2 = l2.next;
                }

                sum = sum + carry;
                carry = sum / 10;

                ListNode node = new ListNode(sum%10);
                temp.next = node;
                temp = temp.next;
            }

            return head.next;
        }
    }
}


/*
* why carry > 0 ?
* Take the test case:
* [9,9,9,9,9,9,9]
* [9,9,9,9]
*
*
* output: [8,9,9,9,0,0,0]
* Expected: [8,9,9,9,0,0,0,1]
*
* */
