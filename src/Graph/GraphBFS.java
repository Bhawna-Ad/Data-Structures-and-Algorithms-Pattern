package Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
// Time Complexity: O(N+E)
// Space Complexity: O(N) + O(N)

public class GraphBFS {
    class Solution {
        // Function to return Breadth First Traversal of given graph.
        public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here
            Queue<Integer> q = new LinkedList<>();
            boolean[] vis = new boolean[V];
            ArrayList<Integer> list = new ArrayList<>();

            vis[0] = true;
            q.add(0);

            while(!q.isEmpty()) {
                int node = q.poll();
                list.add(node);

                for(int it: adj.get(node)) {
                    if(!vis[it]) {
                        q.add(it);
                        vis[it] = true;
                    }
                }
            }

            return list;
        }
    }
}
