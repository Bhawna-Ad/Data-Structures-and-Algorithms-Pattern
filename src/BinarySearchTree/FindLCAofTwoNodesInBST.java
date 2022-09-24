package BinarySearchTree;

// We only need to look for whether both the nodes are present to the left of the root or right of the root.
// Time Complexity: O(N)

public class FindLCAofTwoNodesInBST {
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            while(root != null) {
                if(root.val>p.val && root.val>q.val)
                    root = root.left;
                else if(root.val<p.val && root.val<q.val)
                    root = root.right;
                else
                    return root;
            }

            return null;
        }
    }
}
