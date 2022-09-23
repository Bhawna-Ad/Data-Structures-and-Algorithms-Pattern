package Heap;

import java.util.*;

// https://leetcode.com/problems/top-k-frequent-elements/submissions/
// Map the frequencies of all the values in the array.
// Using a priority queue to arrange values in a heap according to their frequency.
// Pop out the min values and maintain the minheap size equal to k.
// All the elements left in the heap will be the k frequent elements.
// Time Complexity: O(Nlogk)
// Space Complexity: O(k) + O(N)

public class TopKFrequentElements {
    class Solution {
        private class Pair {
            int val;
            int freq;
            Pair(int val, int freq) {
                this.val = val;
                this.freq = freq;
            }
        }
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer>map = new HashMap<>();
            PriorityQueue<Pair>minHeap = new PriorityQueue<>((a, b)->a.freq-b.freq);

            for(int num: nums)
                map.put(num, map.getOrDefault(num, 0)+1);

            for(int val: map.keySet()) {
                minHeap.add(new Pair(val, map.get(val)));
                if(minHeap.size() > k)
                    minHeap.poll();
            }

            int[] ans = new int[k];
            while(!minHeap.isEmpty())
                ans[--k] = minHeap.poll().val;

            return ans;
        }
    }
}
