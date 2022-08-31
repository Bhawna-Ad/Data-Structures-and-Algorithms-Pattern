package Graph;

// https://leetcode.com/problems/course-schedule/
// Time Complexity: O(V + E)
// Space Complexity: O(V)

import java.util.ArrayList;
import java.util.List;

public class DetectACycleInADirectedGraphUsingDFS {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<List<Integer>>adj = new ArrayList<>();
            for(int i=0; i<numCourses; i++)
                adj.add(new ArrayList<>());

            for(int[] p: prerequisites) {
                int u = p[0];
                int v = p[1];

                adj.get(v).add(u);
            }

            return !isCyclic(numCourses, adj);
        }

        private boolean isCyclic(int n, List<List<Integer>> adj) {
            boolean[] vis = new boolean[n];
            boolean[] dfsVis = new boolean[n];

            for(int i=0; i<n; i++) {
                if(!vis[i]) {
                    if(checkCycle(i, vis, dfsVis, adj))
                        return true;
                }
            }
            return false;
        }

        private boolean checkCycle(int node, boolean[] vis, boolean[] dfsVis, List<List<Integer>> adj) {
            vis[node] = true;
            dfsVis[node] = true;

            for(int it: adj.get(node)) {
                if(!vis[it]) {
                    if(checkCycle(it, vis, dfsVis, adj))
                        return true;
                } else if(dfsVis[it])
                    return true;
            }
            dfsVis[node] = false;
            return false;
        }
    }
}
