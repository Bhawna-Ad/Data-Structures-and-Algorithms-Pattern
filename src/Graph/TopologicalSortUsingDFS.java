package Graph;

// https://practice.geeksforgeeks.org/problems/topological-sort/1
// Time Complexity: O(N+E)
// Space Complexity: O(N) + O(N)

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortUsingDFS {
    class Solution
    {
        //Function to return list containing vertices in Topological order.
        static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
        {
            // add your code here
            Stack<Integer> stack = new Stack<>();
            boolean[] vis = new boolean[V];

            for(int i=0; i<V; i++) {
                if(!vis[i]) {
                    dfs(i, vis, stack, adj);
                }
            }

            int[] topo = new int[V];
            int index = 0;
            while(!stack.isEmpty()) {
                topo[index++] = stack.pop();
            }

            return topo;
        }

        static void dfs(int node, boolean[] vis, Stack<Integer>stack, ArrayList<ArrayList<Integer>> adj) {
            vis[node] = true;

            for(int it: adj.get(node)) {
                if(!vis[it]) {
                    dfs(it, vis, stack, adj);
                }
            }

            stack.push(node);
        }
    }
}
