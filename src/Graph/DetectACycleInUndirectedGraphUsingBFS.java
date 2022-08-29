package Graph;

// https://leetcode.com/problems/course-schedule/
// Time Complexity: O(N+E)
// Space Complexity: O(N)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectACycleInUndirectedGraphUsingBFS {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<List<Integer>> adj = new ArrayList<>();
            for(int i=0; i<numCourses; i++)
                adj.add(new ArrayList<>());

            for(int i=0; i<prerequisites.length; i++) {
                int u = prerequisites[i][0];
                int v = prerequisites[i][1];

                adj.get(u).add(v);
            }
            boolean vis[] = new boolean[numCourses];
            for(int i=0; i<numCourses; i++)
                if(!vis[i])
                    if(checkForCycle(adj, i,vis))
                        return true;

            return false;
        }

        class Node {
            int first;
            int second;
            public Node(int first, int second) {
                this.first = first;
                this.second = second;
            }
        }

        private boolean checkForCycle(List<List<Integer>> adj, int s, boolean vis[]) {
            Queue<Node> q =  new LinkedList<>();
            q.add(new Node(s, -1));
            vis[s] =true;

            while(!q.isEmpty()) {
                int node = q.peek().first;
                int par = q.peek().second;
                q.poll();

                for(Integer it: adj.get(node)) {
                    if(!vis[it]) {
                        q.add(new Node(it, node));
                        vis[it] = true;
                    }
                    else if(par != it) return true;
                }
            }

            return false;
        }
    }
}
