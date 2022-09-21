package Heap;

// A heap is a complete binary tree (all the levels of the tree are filled completely except possibly the last one).
// The insertion takes place from the leftmost side of the tree.
// In a heap
// Node = ith index
// left child = 2*ith index
// right child = 2*i + 1 th index
// parent = i/2 th index

public class MinHeap {
    int arr[];
    int size;
    MinHeap() {
        this.arr = new int[100];
        this.size = 0;
        arr[0] = -1;
    }

    public void insert(int val) {
        size++;
        int index = size;
        arr[size] = val;

        while(index > 1) {
            int parent = index/2;
            if(arr[index] < arr[parent]) {
                swap(index, parent);
                index = parent;
            } else
                return;
        }
    }

    public void delete() {
        if(size == 0)
            return;

        swap(1, size);
        size--;

        int index = 1;
        while (index < size) {
            int left = 2*index;
            int right = 2*index+1;

            if(left<size && arr[left]<arr[index]) {
                swap(left, index);
                index = left;
            } else if(right<size && arr[right]<arr[index]) {
                swap(right, index);
                index = right;
            } else
                return;
        }
    }

    private void swap(int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public void print() {
        for (int i=1; i<=size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
