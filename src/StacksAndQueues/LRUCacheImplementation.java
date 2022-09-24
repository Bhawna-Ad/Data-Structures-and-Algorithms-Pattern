package StacksAndQueues;

// To implement the LRU cache we will use a doubly linked list to make operations easier.
// Every time a node is inserted, it will take place at the head.
// We need to check two conditions while inserting:
//      if the capacity of the cache is full we will remove the least recently used node which will be present right before the tail.
//      if the key is already present in the map then we will remove that value from the list and insert the updated value at the front.
// While calling get function we will remove the node from the list and insert it back at the front and return the value.

import java.util.HashMap;

public class LRUCacheImplementation {
    class LRUCache {
        private Node head;
        private Node tail;
        private int capacity;
        private HashMap<Integer, Node>map;

        private class Node {
            int key;
            int val;
            Node prev;
            Node next;
            Node(int key, int val) {
                this.key = key;
                this.val = val;
                this.prev = null;
                this.next = null;
            }
        }

        public LRUCache(int capacity) {
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            this.head.next = tail;
            this.tail.prev = head;
            this.capacity = capacity;
            this.map = new HashMap<>();
        }

        public int get(int key) {
            if(!map.containsKey(key))
                return -1;

            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }

        public void put(int key, int value) {
            if(map.containsKey(key))
                remove(map.get(key));

            if(map.size() == capacity)
                remove(tail.prev);

            insert(new Node(key, value));
        }

        private void insert(Node node) {
            map.put(node.key, node);
            head.next.prev = node;
            node.prev = head;
            node.next = head.next;
            head.next = node;

        }

        private void remove(Node node) {
            map.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
