package Heap;

import java.util.Arrays;

public class HeapImplementation {
    public static void main(String[] args) {
        int[] arr = {-1, 54, 53, 55, 52, 50};
        int n = 5;
        // Since we only need to arrange parent nodes.
        for(int i=n/2; i>0; i--)
            heapify(arr, n, i);
    }

    // Heapify for MaxHeap
    // In a complete binary tree the leaf nodes are from (n/2+1)th index to nth index.
    // We do not have to arrange the leaf nodes, we only need to arrange the parent nodes that are from 1 to n/2.
    // Sorting takes place from the rightmost leaf node.
    // Time Complexity: O(logN)
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2*i;
        int right = 2*i+1;

        if(left <= n && arr[largest]<arr[left]) {
            largest = left;
        }
        if(right <= n && arr[largest]<arr[right])
            largest = right;

        // if the node is at its correct place.
        if (largest != i) {
            swap(arr, largest, i);
            // to arrange the children of the swapped node
            heapify(arr, n, largest);
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    // Heap sort algorithm
    // Swap first and last element
    // Reduce the size
    // Put the root node to its correct position in the heap.
    // Repeat the process
    // Time Complexity: O(NlogN)
    private static void heapSort(int[] arr, int n) {
        int index = n;
        while (index > 1) {
            swap(arr, index, 1);
            index--;

            heapify(arr, index, 1);
        }
    }
}
