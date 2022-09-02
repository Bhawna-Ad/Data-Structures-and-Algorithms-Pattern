package Graph;

// Kosaraju's Algorithm
// Step1: Sort all the nodes in order of last visited. (Topological Sort)
// Step2: Transpose the graph.
// Step3: Perform DFS according to finishing time.
// Time Complexity: O(N) + O(N+E) + O(N+E)
// Space Complexity: O(N+E) + O(N) + O(N)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StronglyConnectedComponents {
    public static void main(String[] args) {
        int[][] graph = {{0,1}, {1,3}, {3,4}, {1,2}, {2,0}};
        System.out.println("Number of Connected Components in the graph: " + kosarajuAlgo(graph, 5));
    }

    private static int kosarajuAlgo(int[][] graph, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());

        for(int i=0; i<graph.length; i++) {
            int u = graph[i][0];
            int v = graph[i][1];

            adj.get(u).add(v);
        }

        // Step1
        Stack<Integer>s = new Stack<>();
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!vis[i]) {
                topo(i, vis, s, adj);
            }
        }

        // Step2
        List<List<Integer>> rev = new ArrayList<>();
        transpose(graph, rev);

        // Step3
        Arrays.fill(vis, false);
        int count = 0;
        while (!s.isEmpty()) {
            int node = s.pop();
            if(!vis[node]) {
                count++;
                System.out.print("SCC: ");
                dfs(node, vis, rev);
                System.out.println();
            }
        }

        return count;
    }

    private static void topo(int node, boolean[] vis, Stack<Integer>s, List<List<Integer>> adj) {
        vis[node] = true;

        for(int it: adj.get(node)) {
            if(!vis[it]) {
                topo(it, vis, s, adj);
            }
        }

        s.push(node);
    }

    private static void transpose(int[][] graph, List<List<Integer>> adj) {
        int n = graph.length;
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());

        for(int i=0; i<n; i++) {
            int u = graph[i][0];
            int v = graph[i][1];

            adj.get(v).add(u);
        }
    }

    private static void dfs(int node, boolean[] vis, List<List<Integer>> adj) {
        System.out.print(node);
        vis[node] = true;

        for(int it: adj.get(node)) {
            if(!vis[it])
                dfs(it, vis, adj);
        }
    }
}
