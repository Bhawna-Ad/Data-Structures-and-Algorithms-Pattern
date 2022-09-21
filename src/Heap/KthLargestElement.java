package Heap;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
// Push elements into the heap such the size of the heap is never greater than k.
// Time Complexity: O(Nlogk)
// Space Complexity: O(k)

import java.util.PriorityQueue;

public class KthLargestElement {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(int num: nums) {
                pq.add(num);
                if(pq.size() > k)
                    pq.poll();
            }

            return pq.poll();
        }
    }
}
