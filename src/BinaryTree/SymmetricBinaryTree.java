package BinaryTree;

// https://leetcode.com/problems/symmetric-tree/

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricBinaryTree {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class RecursiveSolution {
        public boolean isSymmetric(TreeNode root) {
            return checkSymmetry(root.left, root.right);
        }

        private boolean checkSymmetry(TreeNode node1, TreeNode node2) {
            if(node1==null && node2==null)
                return true;

            if( node1==null || node2==null ||node1.val != node2.val)
                return false;

            return checkSymmetry(node1.left, node2.right) && checkSymmetry(node1.right, node2.left);
        }
    }

    class IterativeSolution {
        public boolean isSymmetric(TreeNode root) {
            Queue<TreeNode> q1 = new LinkedList<>();
            Queue<TreeNode>q2 = new LinkedList<>();
            q1.add(root.left);
            q2.add(root.right);

            while(!q1.isEmpty() && !q2.isEmpty()) {
                TreeNode left = q1.poll();
                TreeNode right = q2.poll();

                if(left==null && right==null)
                    continue;

                if(left==null || right==null || left.val!=right.val)
                    return false;

                q1.add(left.left);
                q1.add(left.right);
                q2.add(right.right);
                q2.add(right.left);
            }

            return true;
        }
    }
}
