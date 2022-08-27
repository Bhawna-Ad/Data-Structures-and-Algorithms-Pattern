package Graph;

// https://leetcode.com/problems/clone-graph/submissions/

import java.util.ArrayList;
import java.util.*;

public class CloneAGraph {
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

    class Solution {
        public Node cloneGraph(Node node) {
            if(node == null)
                return null;

            Node root = new Node(node.val);
            Node[] vis = new Node[101];
            Arrays.fill(vis, null);

            dfs(root, node, vis);
            return root;
        }

        private void dfs(Node root, Node node, Node[] vis) {
            vis[root.val] = root;

            for(Node it: node.neighbors) {
                if(vis[it.val] == null) {
                    Node n = new Node(it.val);
                    (root.neighbors).add(n);
                    dfs(n, it, vis);
                } else {
                    (root.neighbors).add(vis[it.val]);
                }
            }
        }
    }
}
