package Graph;

// Using PriorityQueue
// Time Complexity: O(NlogN)
// Space Complexity: O(N)

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MSTUsingPrimsAlgorithm {
    public static void main(String[] args) {
    }

    class Node implements Comparator<Node> {
        private int v;
        private int w;
        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        Node() {};
        int getV() {
            return this.v;
        }
        int getW() {
            return this.w;
        }

        @Override
        public int compare(Node node1, Node node2) {
            if(node1.w < node2.w)
                return -1;
            if(node1.w > node2.w)
                return 1;
            return 0;
        }
    }

    private void primsAlgo(int n, List<List<Node>>adj) {
        Integer[] key = new Integer[n];
        int[] parent = new int[n];
        boolean[] mst = new boolean[n];

        PriorityQueue<Node>pq = new PriorityQueue<>(n, new Node());
        key[0] = 0;
        parent[0] = -1;
        pq.add(new Node(key[0], 0));

        while(!pq.isEmpty()) {
            int u = pq.poll().getV();
            mst[u] = true;

            for(Node it: adj.get(u)) {
                if(!mst[it.getV()] && it.getW()<key[it.getV()]) {
                    parent[it.getV()] = u;
                    key[it.getV()] = it.getW();
                    pq.add(new Node(it.getV(), key[it.getV()]));
                }
            }
        }
    }
}
