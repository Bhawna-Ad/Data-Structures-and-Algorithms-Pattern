package LinkedList;

// https://leetcode.com/problems/merge-two-sorted-lists/submissions/
// Using three pointers
// Time Complexity: O(N)
// Space Complexity: O(1)

public class MergeTwoSortedLists {
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if(list1 == null)
                return list2;

            if(list2 == null)
                return list1;

            if(list1.val > list2.val)
                return mergeTwoLists(list2, list1);

            ListNode res = list1;
            while(list2 != null) {
                ListNode temp = null;
                while(list1!=null && list1.val <= list2.val) {
                    temp = list1;
                    list1 = list1.next;
                }
                temp.next = list2;

                temp = list1;
                list1 = list2;
                list2 = temp;
            }

            return res;
        }
    }
}
