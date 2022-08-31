package Graph;

// https://leetcode.com/problems/course-schedule/
// Time Complexity: O(V+E)
// Space Complexity: O(V) + O(V+E)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectACycleInADirectedGraphUsingBFS {
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
            int[] topo = new int[n];
            int[] indegree = new int[n];
            for(int i=0; i<n; i++) {
                for(int it: adj.get(i)) {
                    indegree[it]++;
                }
            }

            Queue<Integer> q = new LinkedList<>();
            for(int i=0; i<n; i++) {
                if(indegree[i] == 0)
                    q.add(i);
            }

            int count = 0;
            while(!q.isEmpty()) {
                int node = q.poll();
                count++;
                for(int it: adj.get(node)) {
                    indegree[it]--;
                    if(indegree[it] == 0)
                        q.add(it);
                }
            }

            if(count == n)
                return false;
            return true;
        }
    }
}
