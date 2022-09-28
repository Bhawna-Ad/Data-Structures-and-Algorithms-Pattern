package BinarySearchTree;

public class KthSmallestElementInBST {

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

    class DFSSolution {
        public int kthSmallest(TreeNode root, int k) {
            if(root == null)
                return 0;

            int[] K = new int[1];
            K[0] = k;
            return (dfs(root, K)).val;
        }

        private TreeNode dfs(TreeNode node, int[] K) {
            if(node == null)
                return null;

            TreeNode left = dfs(node.left, K);
            if(left != null)
                return left;

            K[0]--;
            if(K[0] == 0)
                return node;

            return dfs(node.right, K);

        }
    }

    class MorrisTraversalSolution {
        public int kthSmallest(TreeNode root, int k) {
            int count = 0;
            while(root != null) {
                if(root.left == null) {
                    count++;
                    if(count == k)
                        return root.val;
                    root = root.right;
                } else {
                    TreeNode prev = root.left;
                    while(prev.right!=null && prev.right!=root)
                        prev = prev.right;

                    if(prev.right == null) {
                        prev.right = root;
                        root = root.left;
                    } else {
                        count++;
                        prev.right = null;
                        if(count == k)
                            return root.val;

                        root = root.right;
                    }
                }
            }

            return -1;
        }
    }
}
