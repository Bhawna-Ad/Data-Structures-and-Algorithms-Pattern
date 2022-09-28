package BinarySearchTree;

public class KthLargestElementInBST {
    class Node
    {
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data = data;
            left=null;
            right=null;
        }
    }

    class DFSSolution {
        // return the Kth largest element in the given BST rooted at 'root'
        public int kthLargest(Node root,int K)
        {
            //Your code here
            int[] k = new int[1];
            k[0] = K;
            return (dfs(root, k)).data;
        }

        private Node dfs(Node node, int[] k) {
            if(node == null)
                return null;

            Node right = dfs(node.right, k);
            if(right != null)
                return right;

            k[0]--;
            if(k[0] == 0)
                return node;

            return dfs(node.left, k);
        }
    }

    class MorrisTraversalSolution {
        // return the Kth largest element in the given BST rooted at 'root'
        public int kthLargest(Node root,int K)
        {
            //Your code here
            int count = 0;
            while(root != null) {
                if(root.right == null) {
                    count++;
                    if(count == K)
                        return root.data;
                    root = root.left;
                } else {
                    Node prev = root.right;
                    while(prev.left!=null && prev.left!=root)
                        prev = prev.left;

                    if(prev.left == null) {
                        prev.left = root;
                        root = root.right;
                    } else {
                        count++;
                        prev.left = null;
                        if(count == K)
                            return root.data;

                        root = root.left;
                    }
                }
            }

            return -1;
        }
    }
}
