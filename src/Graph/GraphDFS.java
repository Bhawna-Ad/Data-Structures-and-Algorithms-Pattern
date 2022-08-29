package Graph;

// https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
// Time Complexity: O(N+E)
// Space Complexity: O(N)+O(N)

import java.util.ArrayList;

public class GraphDFS {
    class Solution {
        // Function to return a list containing the DFS traversal of the graph.
        public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here
            boolean[] vis = new boolean[V];
            ArrayList<Integer> list = new ArrayList<>();

            for(int i=0; i<V; i++) {
                if(!vis[i]) {
                    dfs(i, list, vis, adj);
                }
            }

            return list;
        }

        private void dfs(int node, ArrayList<Integer>list, boolean[] vis, ArrayList<ArrayList<Integer>>adj) {
            vis[node] = true;
            list.add(node);

            for(int i: adj.get(node)) {
                if(!vis[i]) {
                    dfs(i, list, vis, adj);
                }
            }
        }
    }
}
