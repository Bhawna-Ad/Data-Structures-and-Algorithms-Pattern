package StacksAndQueues;

public class ImplementQueueUsingArrays {
    public class Queue {
        int[] arr;
        int front;
        int rear;
        int size;
        Queue() {
            this.arr = new int[100];
            this.front = 0;
            this.rear = 0;
            this.size = 0;
        }

        public void offer(int val) {
            if (isFull())
                return;

            arr[rear++] = val;
            size++;
        }

        public int poll() {
            if(isEmpty())
                return -1;

            size--;
            return arr[front++];
        }

        public int peek() {
            if (isEmpty())
                return -1;

            return arr[front];
        }

        public void print() {
            if (isEmpty())
                return;

            for(int i=front; i<rear; i++)
                System.out.print(arr[i] + " ");

            System.out.println();
        }

        public int size() {
            return size;
        }

        public boolean isFull() {
            return rear == arr.length;
        }

        public boolean isEmpty() {
            return front == rear;
        }
    }
}
