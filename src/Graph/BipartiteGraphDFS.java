package Graph;

// https://leetcode.com/problems/is-graph-bipartite/
// Time Complexity: O(V+E)
// Space Complexity: O(V+E)

public class BipartiteGraphDFS {
    class Solution {
        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            Integer[] color = new Integer[n];

            for(int i=0; i<n; i++) {
                if(color[i] == null) {
                    if(!dfsCheck(i, color, graph))
                        return false;
                }
            }

            return true;
        }

        private boolean dfsCheck(int s, Integer[] color, int[][] graph) {
            if(color[s] == null)
                color[s] = 1;

            for(int it: graph[s]) {
                if(color[it] == null) {
                    color[it] = 1 - color[s];
                    if(!dfsCheck(it, color, graph))
                        return false;
                } else if(color[it] == color[s])
                    return false;
            }

            return true;
        }
    }
}
