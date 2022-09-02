package Graph;

// Find the shortest path from the source to every other node in a weighted graph.
// Minimization problem uses greedy method to find the optimal method.
// Uses priority queue
// Time Complexity: O((N+E)logN)
// Space Complexity: O(N) + O(N)

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
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

    public void Dijkstra(int s, List<List<Node>> adj, int n) {
        Integer[] dist = new Integer[n];
        dist[s] = 0;

        PriorityQueue<Node>pq = new PriorityQueue<>(n, new Node());
        pq.add(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (Node it: adj.get(node.getV())) {
                if(dist[node.getV()] + it.getW() < dist[it.getV()]) {
                    dist[it.getV()] = dist[node.getV()]+it.getW();
                    pq.add(new Node(it.getV(), dist[it.getV()]));
                }
            }
        }

        System.out.println(Arrays.toString(dist));

    }
}
