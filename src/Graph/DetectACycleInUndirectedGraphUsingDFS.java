package Graph;

// https://leetcode.com/problems/course-schedule/
// Time Complexity: O(N+E)
// Space Complexity: O(N)

import java.util.ArrayList;
import java.util.List;

public class DetectACycleInUndirectedGraphUsingDFS {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            boolean[] vis = new boolean[numCourses];
            boolean[] dfsVis = new boolean[numCourses];

            List<List<Integer>> adj = new ArrayList<>();
            for(int i=0; i<numCourses; i++)
                adj.add(new ArrayList<>());

            for(int[] pair: prerequisites) {
                int u = pair[0];
                int v = pair[1];

                adj.get(u).add(v);
            }

            for(int i=0; i<numCourses; i++) {
                if(!vis[i]) {
                    if(isCyclic(i, adj, vis, dfsVis))
                        return false;
                }
            }

            return true;
        }

        private boolean isCyclic(int node, List<List<Integer>> adj, boolean[] vis, boolean[] dfsVis) {
            vis[node] = true;
            dfsVis[node] = true;

            for(int it: adj.get(node)) {
                if(!vis[it]) {
                    if(isCyclic(it, adj, vis, dfsVis))
                        return true;
                }
            }
            dfsVis[node] = false;
            return false;
        }
    }
}
