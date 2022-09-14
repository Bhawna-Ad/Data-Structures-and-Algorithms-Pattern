package BinaryTree;

// In a single traversal implement all the traversals (preorder, inorder, postorder)
// Time Complexity: O(N)
// Space Complexity: O(N)

import java.util.*;

public class SingleTraversal {
    private class Node {
        int val;
        Node left;
        Node right;
        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private class Pair {
        Node node;
        int num;
        Pair(Node node, int num) {
            this.node = node;
            this.num = num;
        }
    }

    public List<List<Integer>> singleTraversal(Node root) {
        Stack<Pair>st = new Stack<>();
        List<Integer>pre = new ArrayList<>();
        List<Integer>in = new ArrayList<>();
        List<Integer>post = new ArrayList<>();
        List<List<Integer>>ans = new ArrayList<>();

        st.push(new Pair(root, 1));

        while (!st.isEmpty()) {
            Pair p = st.pop();

            // Preorder
            // 1Root 2Left 3Right
            if(p.num == 1) {
                pre.add(p.node.val);
                p.num++;
                st.push(p);
                if(p.node.left != null)
                    st.push(new Pair(p.node.left, 1));
            }

            // Inorder
            // 1Left 2Root 3Right
            else if(p.num == 2) {
                in.add(p.node.val);
                p.num++;
                st.push(p);
                if(p.node.right != null)
                    st.push(new Pair(p.node.right, 1));
            }

            // Postorder
            // 1Left 2Right 3Root
            else
                post.add(p.node.val);
        }

        ans.add(pre);
        ans.add(in);
        ans.add(post);

        return ans;
    }
}
