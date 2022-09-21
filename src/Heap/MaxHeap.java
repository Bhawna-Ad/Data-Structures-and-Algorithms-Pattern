package Heap;

// The parent value is greater than the values of children.

/*
* Insertion in MaxHeap
* insert the value at the end
* then check whether the value of the node's parent is greater than the value of current node.
* If not then swap the value with the parent until the right position is found.
*
* Deletion in MaxHeap
* Deletion happens at the root node
* Swap the values of root node and the last node in the tree
* Remove the last node
* Propagate root node to its correct position:
*       check the greater child and swap the values of the child and the root node
* */

class MaxHeap {
    private int[] arr;
    public int size;

    public MaxHeap() {
        this.arr = new int[100];
        this.arr[0] = -1;
        this.size = 0;
    }

    // Time Complexity: O(logN)
    public void insert(int val) {
        size = size+1;
        int index = size;
        arr[index] = val;

        while(index > 1) {
            int parent = index/2;
            if(arr[parent] < arr[index]) {
                swap(parent, index);
                index = parent;
            }
            else
                return;
        }
    }

    // Time Complexity: O(logN)
    public void delete() {
        if(size == 0) {
            System.out.println("Heap is Empty.");
            return;
        }

        swap(1, size);
        size = size-1;

        int index = 1;
        while (index < size) {
            int left = 2*index;
            int right = 2*index + 1;

            if(left<size && arr[index]<arr[left]) {
                swap(left, index);
                index = left;
            } else if(right<size && arr[index]<arr[right]) {
                swap(right, index);
                index = right;
            } else {
                return;
            }
        }
    }

    private void swap(int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public void print() {
        for(int i=1; i<=size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
}