package Heap;

// https://leetcode.com/problems/find-median-from-data-stream/
// Since we have to find the median, we can think of dividing the array in two halves.
// To get the median, if the number of total elements is even then we can take max value from left half and the min value from right half.
// if it is odd then we are going to compare the sizes of the two halves
// if the left half has more values then return the max value from it.
// else if the right half has more values then return the min value from it.
// To get the maximum from left and minimum from right we can use maxheap and minheap respectively.

/*
* We will first insert the value to the maxheap.
* The two conditions that we need to check during inserting values are:
* 1. Size difference between the two heaps should not be more than one.
*       if it is more than one then pop out the value from the heap with greater size and insert it into the one with smaller size.
* 2. Every element in the maxheap should be <= every element in minheap.
*       if an element is found which has a value greater than the min in minheap then we will pop out that value and insert it into the minheap and vice versa.
*
* */

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianInDataStream {
    class MedianFinder {
        // Right half of the array.
        private PriorityQueue<Integer> minHeap;
        // Left half of the array.
        private PriorityQueue<Integer>maxHeap;

        public MedianFinder() {
            this.minHeap = new PriorityQueue<>();
            this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        }

        // Time Complexity: O(logN)
        public void addNum(int num) {
            maxHeap.add(num);

            // Make sure every element in maxHeap is less than every element in minheap.
            if(!minHeap.isEmpty() && maxHeap.peek()>minHeap.peek())
                minHeap.add(maxHeap.poll());

            // Make sure the difference of heap sizes is not more than 1.
            if(maxHeap.size()-minHeap.size() > 1)
                minHeap.add(maxHeap.poll());
            if(minHeap.size()-maxHeap.size() > 1)
                maxHeap.add(minHeap.poll());
        }

        // Time Complexity: O(logN)
        public double findMedian() {
            // For odd length of either of the heap.
            if(minHeap.size() > maxHeap.size())
                return minHeap.peek();
            else if(maxHeap.size() > minHeap.size())
                return maxHeap.peek();

                // For even lengths of the heaps.
            else
                return (double)((maxHeap.peek() + minHeap.peek())/2.0);
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
