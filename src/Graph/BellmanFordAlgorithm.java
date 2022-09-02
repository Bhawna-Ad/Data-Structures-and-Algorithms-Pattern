package Graph;

// Find the shortest path from source to every other node in a weighted graph. The weights can be negative.
// Works on directed graphs which do not contain negative cycle.
// Time Complexity: O(N-1)*O(E)
// Space Complexity: O(N)

import java.util.Arrays;
import java.util.List;

public class BellmanFordAlgorithm {
    private class Node {
        int u;
        int v;
        int w;

        Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        Node() {};
        int getU() {
            return this.u;
        }
        int getV() {
            return this.v;
        }
        int getW() {
            return this.w;
        }
    }

    public void BellmanFord(List<Node> edges, int n, int s) {
        Integer[] dist = new Integer[n];
        dist[s] = 0;

        for(int i=1; i<=n-1; i++) {
            for(Node node: edges) {
                dist[node.getV()] = Math.min(dist[node.getV()], dist[node.getU()]+node.getW());
            }
        }

        boolean flag = false;
        for (Node node: edges) {
            if(dist[node.getU()]+node.getW() < dist[node.getV()]) {
                flag = true;
                System.out.println("Negative Cycle.");
                break;
            }
        }

        if(!flag)
            System.out.println(Arrays.toString(dist));
    }
}
