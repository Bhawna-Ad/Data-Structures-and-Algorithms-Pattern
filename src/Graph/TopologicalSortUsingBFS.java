package Graph;

// https://practice.geeksforgeeks.org/problems/topological-sort/1
// Time Complexity: O(N+E)
// Space Complexity: O(N)+O(N)


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortUsingBFS {
    class Solution
    {
        //Function to return list containing vertices in Topological order.
        static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
        {
            // add your code here
            int[] topo = new int[V];
            int[] indegree = new int[V];
            Queue<Integer> q = new LinkedList<>();

            for(int i=0; i<V; i++) {
                for(int it: adj.get(i)) {
                    indegree[it]++;
                }
            }

            for(int i=0; i<V; i++) {
                if(indegree[i] == 0) {
                    q.add(i);
                }
            }

            int index = 0;
            while(!q.isEmpty()) {
                int node = q.poll();
                topo[index++] = node;

                for(int it: adj.get(node)) {
                    indegree[it]--;
                    if(indegree[it] == 0) {
                        q.add(it);
                    }
                }
            }

            return topo;

        }
    }
}
