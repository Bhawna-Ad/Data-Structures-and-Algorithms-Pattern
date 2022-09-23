package Heap;

// https://www.codingninjas.com/codestudio/problems/merge-k-sorted-arrays_975379?leftPanelTab=0

import java.util.*;

public class MergeKSortedArrays {
    // Using priority queue (minheap) to sort the elements since each time the element is popped it will be the min of all elements in the heap.
    // Time Complexity: O(N^2 logN)
    public class PriorityQueueSolution
    {
        public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
        {
            // Write your code here.
            PriorityQueue<Integer>minHeap = new PriorityQueue<>();
            for(ArrayList<Integer>list : kArrays) {
                for(int num: list) {
                    minHeap.add(num);
                }
            }

            ArrayList<Integer>ans = new ArrayList<>();
            while(!minHeap.isEmpty()) {
                ans.add(minHeap.poll());
            }

            return ans;
        }
    }

    // Merge Sort solution using extra space
    // Time Complexity: O(NlogN)
    public class MergeSortSolution
    {
        public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
        {
            // Write your code here.
            ArrayList<Integer>ans = new ArrayList<>();
            ans = kArrays.get(0);

            for(int i=1; i<k; i++) {
                ans = mergeArrays(ans, kArrays.get(i));
            }

            return ans;
        }

        private static ArrayList<Integer> mergeArrays(ArrayList<Integer>list1, ArrayList<Integer>list2) {
            ArrayList<Integer>ans = new ArrayList<>();
            int i = 0;
            int j = 0;
            while(i<list1.size() && j<list2.size()) {
                if(list1.get(i) < list2.get(j)) {
                    ans.add(list1.get(i));
                    i++;
                } else {
                    ans.add(list2.get(j));
                    j++;
                }
            }

            while(i < list1.size()) {
                ans.add(list1.get(i));
                i++;
            }

            while(j < list2.size()) {
                ans.add(list2.get(j));
                j++;
            }

            return ans;
        }
    }

    // Merge Sort solution in place (at first index)
    // Time Complexity: O(NlogN)
    public class MergeSortInPlaceSolution
    {
        public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
        {
            // Write your code here.
            for(int i=1; i<k; i++) {
                mergeArrays(kArrays.get(0), kArrays.get(i));
            }

            return kArrays.get(0);
        }

        private static void mergeArrays(ArrayList<Integer>list1, ArrayList<Integer>list2) {
            ArrayList<Integer>ans = new ArrayList<>();
            int i = 0;
            int j = 0;
            while(i<list1.size() && j<list2.size()) {
                if(list1.get(i) >= list2.get(j)) {
                    list1.add(i, list2.get(j));
                    j++;
                }
                i++;
            }

            while(j < list2.size()) {
                list1.add(list2.get(j));
                j++;
            }
        }
    }

    // Using priority queue
    // Insert first element of all the k arrays in the minHeap.
    // now until the heap is empty, pop out the min element and insert the next element for the same row in the heap.
    // Time Complexity: O(nlogK)
    // Space Complexity: O(k)
    public class Solution
    {
        private static class Triple {
            int val;
            int row;
            int index;
            Triple(int val, int row, int index) {
                this.val = val;
                this.row = row;
                this.index = index;
            }
        }
        public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
        {
            // Write your code here.
            PriorityQueue<Triple>minHeap = new PriorityQueue<>((a, b)->a.val-b.val);
            for(int i=0; i<k; i++)
                minHeap.add(new Triple(kArrays.get(i).get(0), i, 0));

            ArrayList<Integer>ans = new ArrayList<>();
            while(!minHeap.isEmpty()) {
                Triple t = minHeap.poll();
                ans.add(t.val);
                int row = t.row;
                int index = t.index;

                if(index+1 < kArrays.get(row).size())
                    minHeap.add(new Triple(kArrays.get(row).get(index+1), row, index+1));
            }

            return ans;
        }
    }

}
