package BinaryTree;

import java.util.ArrayList;
import java.util.List;

// https://www.interviewbit.com/problems/path-to-given-node/

public class RootToNodePath {
      class TreeNode {
          int val;
          TreeNode left;
         TreeNode right;
          TreeNode(int x) {
          val = x;
           left=null;
           right=null;
          }
      }

    public class Solution {
        public int[] solve(TreeNode A, int B) {
            List<Integer> list = new ArrayList<>();
            dfs(A, B, list);
            int[] ans = new int[list.size()];
            for(int i=0; i<list.size(); i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }

        private boolean dfs(TreeNode node, int val, List<Integer>list) {
            if(node == null) {
                return false;
            }

            list.add(node.val);
            if(node.val == val) {
                return true;
            }

            if(dfs(node.left, val, list) || dfs(node.right, val, list)) {
                return true;
            }

            list.remove(list.size()-1);
            return false;
        }
    }

}
