package StacksAndQueues;

public class ImplementStackUsingArrays {
    public  class Stack {
        int[] arr;
        int size;
        Stack() {
            this.arr = new int[100];
            this.size = 0;
        }

        public void push(int val) {
            if (isFull())
                return;

            arr[size++] = val;
        }

        public int pop() {
            if(isEmpty())
                return -1;

            return arr[--size];
        }

        public int peek() {
            if (isEmpty())
                return -1;

            return arr[size-1];
        }

        public void print() {
            if (isEmpty())
                return;

            for(int i=size-1; i>=0; i--)
                System.out.print(arr[i] + " ");

            System.out.println();
        }

        public boolean isFull() {
            return size == arr.length;
        }

        public boolean isEmpty() {
            return size==0;
        }

        public int size() {
            return size;
        }
    }
}
