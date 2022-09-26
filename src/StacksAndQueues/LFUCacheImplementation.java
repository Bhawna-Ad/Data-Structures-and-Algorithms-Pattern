package StacksAndQueues;

// https://leetcode.com/problems/lfu-cache/
// For LFU we will use two maps:
// 1. to map the frequencies to the doubly linked list
// 2. to map the key to its value.
/*
* For insertion:
* We will check two conditions:
* 1. Whether the node already exists in the cache, if so update it.
* 2. Whether the capacity is full, if so remove lfu node and in case of a tie in frequencies, remove lru node.
*
* For deletion:
* Remove the element present right before the tail where the freq is the least.
*
* */

import java.util.HashMap;

public class LFUCacheImplementation {
    class LFUCache {
        int capacity;
        int size;
        int minFreq;
        HashMap<Integer, Node> cache;
        HashMap<Integer, DLList>frequency;
        private class Node {
            int key;
            int val;
            int freq;
            Node prev;
            Node next;
            private Node(int key, int val) {
                this.key = key;
                this.val = val;
                this.prev = null;
                this.next = null;
                this.freq = 1;
            }
        }

        private class DLList {
            Node head;
            Node tail;
            int size;
            DLList() {
                this.head = new Node(0, 0);
                this.tail = new Node(0, 0);
                this.head.next = this.tail;
                this.tail.prev = this.head;
                this.size = 0;
            }

            public void addNode(Node node) {
                head.next.prev = node;
                node.next = head.next;
                head.next = node;
                node.prev = head;
                this.size++;
            }

            public void removeNode(Node node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                this.size--;
            }


        }

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.minFreq = 0;
            this.cache = new HashMap<>();
            this.frequency = new HashMap<>();
        }

        public int get(int key) {
            Node node = cache.get(key);
            if(node == null)
                return -1;
            updateNode(node);
            return node.val;
        }

        public void put(int key, int value) {
            if(capacity == 0)
                return;

            if(cache.containsKey(key)) {
                Node node = cache.get(key);
                node.val = value;
                updateNode(node);
            } else {
                this.size++;
                if (size > capacity) {
                    DLList minFreqList = frequency.get(minFreq);
                    cache.remove(minFreqList.tail.prev.key);
                    minFreqList.removeNode(minFreqList.tail.prev);
                    size--;
                }
                minFreq = 1;
                Node newNode = new Node(key, value);

                DLList curList = frequency.getOrDefault(1, new DLList());
                curList.addNode(newNode);
                frequency.put(1, curList);
                cache.put(key, newNode);
            }
        }

        public void updateNode(Node node) {
            int curFreq = node.freq;
            DLList list = frequency.get(curFreq);
            list.removeNode(node);

            if(curFreq == minFreq && list.size==0)
                minFreq++;

            node.freq++;

            DLList newList = frequency.getOrDefault(node.freq, new DLList());
            newList.addNode(node);
            frequency.put(node.freq, newList);
        }
    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
