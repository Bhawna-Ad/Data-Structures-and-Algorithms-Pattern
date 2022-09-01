package Graph;

// https://leetcode.com/problems/is-graph-bipartite/
// Time Complexity: O(V+E)
// Space Complexity: O(V)

import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphBFS {
    class Solution {
        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            Integer[] color = new Integer[n];

            for(int i=0; i<n; i++) {
                if(color[i] == null) {
                    if(!bfsCheck(i, graph, color))
                        return false;
                }
            }
            return true;
        }

        private boolean bfsCheck(int node, int[][] graph, Integer[] color) {
            Queue<Integer> q = new LinkedList<>();
            q.add(node);
            color[node] = 1;
            while(!q.isEmpty()) {
                int temp = q.poll();
                for(int it: graph[temp]) {
                    if(color[it] == null) {
                        color[it] = 1 - color[temp];
                        q.add(it);
                    } else if(color[it] == color[temp])
                        return false;
                }
            }
            return true;
        }
    }
}
